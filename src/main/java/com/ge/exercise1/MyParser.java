package com.ge.exercise1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyParser implements Parser{

	private static final Logger LOGGER = LogManager.getLogger(MyParser.class);
	
	@Override
	public Application parseApplicationData(String parseData) {
		
		Application application = new ApplicationImplClass();
		
		/*Method to convert text to JSON*/
		String jsonFromText = MyParser.jsonFromText(parseData);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			/*Converting JSON to Application Model*/
			application = objectMapper.readValue(jsonFromText, ApplicationImplClass.class);
		} catch (JsonParseException e) {
			LOGGER.error("JsonParseException while creating JSON to Model: "+ e.getMessage());
		} catch (JsonMappingException e) {
			LOGGER.error("JsonMappingException while creating JSON to Model: "+ e.getMessage());
		} catch (IOException e) {
			LOGGER.error("IOException while creating JSON to Model: "+ e.getMessage());
		} 
		LOGGER.info("Model after parsing the JSON: "+ application);
		
		return application;
	}
	private static String jsonFromText(String textData){
		textData = textData.replace("(", ":{").replace(")", "}");
		StringBuilder stringBuilder = new StringBuilder();
		List<String> strList= Arrays.asList(textData.split(":"));
		for(String eachStr: strList){
			if(eachStr.contains("[")){
				eachStr = "[";
			}
			if(eachStr.contains("},")){
				eachStr = eachStr.substring(0, eachStr.indexOf(","));
			}
			if(eachStr.contains(",")){
				eachStr = eachStr.replace(",", "\",\"");
			}
			stringBuilder.append("\""+eachStr+"\":");
		}
		stringBuilder = new StringBuilder(stringBuilder.toString().replace("\"[", "[\"").replace("{", "{\"").replace("}", "\"}")
				.replace(":\"{", ":{").replace("]\"", "]").replace("}\"", "}").replace(":}","}").replace(":\"{", ":{\"")
				.replace("[\"\":", "[").replace(":}", "}").replace("\" ", "\"").replace("}:{", "},{"));

		return stringBuilder.substring(stringBuilder.indexOf("{"),stringBuilder.length()-1);

	}
}
