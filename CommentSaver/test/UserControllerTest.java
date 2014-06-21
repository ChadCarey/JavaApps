/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author chad
 */
public class UserControllerTest {
    
    public UserControllerTest() {
        System.err.println("Starting");
        UserController u = new UserController();
        System.err.println("User added: " + u.addUser("Brady", "mordor"));
        System.err.println("finished add user");
        System.err.println("Brady exists: " + u.userExists("Brady"));
        System.err.println("Can Log in: " + u.validLogin("Brady", "mordor"));
        System.err.println("User added: " + u.addUser("Shawn", "mordor"));
        System.err.println("Shawn exists: " + u.userExists("Brady"));
        System.err.println("Can Log in: " + u.validLogin("Shawn", "mordor"));
        System.err.println("User added: " + u.addUser("John", "mordor"));
        System.err.println("John exists: " + u.userExists("John"));
        System.err.println("Can Log in: " + u.validLogin("John", "mordor"));
        System.err.println("Ending test");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    
}
