package com.ge.exercise1;

import static org.junit.Assert.assertEquals;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() {
        try {
            Class<?> parserClass = Class.forName("com.ge.exercise1.MyParser");
            parser = (Parser) parserClass.newInstance();
        } catch (Exception e) {
            Assume.assumeNoException(e);
        }
    } 

    @Test
    public void parseApplicationDataSimpleTest() {
        String simpleTestData = "Application(id: 0,name: MyApp,users:[User(id: 1,name: Jeet Jones),User(id: 2,name: Beth Jones)],groups:[Group(id: 1,name: SimpleGroup,users:[User(id: 1,name: Beth Jones)]),Group(id: 2,name: Jeet's Group,users:[User(id: 2,name: Jeet Jones),User(id: 3,name: Ram Jones)])])";
        Application app = parser.parseApplicationData(simpleTestData);

        assertEquals("SimpleGroup", app.getGroup("1").getName());
        assertEquals(1, app.getGroup("1").size);
        
        Group group = (Group) app.getGroups().toArray()[1];
        assertEquals("Jeet's Group", ((Group) app.getGroups().toArray()[1]).getName());
        
        assertEquals("Jeet Jones", ((User)group.getUsers().toArray()[0]).getName());
        
        assertEquals("Beth Jones", app.getUser("2").getName());
    }
}