
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chad
 */
public class CommentSaver {
    
    String baseFilePath;
    
    public CommentSaver() {
        baseFilePath = System.getProperty("user.dir") + "/comments";
        File file = new File(baseFilePath);
        if(!file.exists()) {
            if(! file.mkdir()) {
                System.err.println("ERROR making new directory");
                System.exit(1);
            }
        }    
    }
    
    public void add(String user, String comment) {
        // if the user doesn' have a file make a new one
        
        File file = new File(getUserFilePath(user));
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println("ERROR creating user file");
                System.exit(1);
            }
        }    
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(comment + "\n<--->\n");
            writer.close();
        } catch (IOException ex) {
            System.err.println("ERROR writing to file");
            System.exit(1);
        }
        
    }
    
    public String getUserComments(String user) {
        String filePath = getUserFilePath(user);
        System.err.println(filePath + " User: " + user);
        File file = new File(filePath);
        if(!file.exists()) {
            System.err.println("Unknown user");
            return "No Comments";
        }
        String comments = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            String com = reader.readLine();
            while (com != null) {
                comments += com + "\n";
                com = reader.readLine();
            }
            
        } catch (IOException e) {
            System.err.println("ERROR reader user file");
            System.exit(1);
        }
        return comments;
    }
    
    private String getUserFilePath(String user) {
        return baseFilePath + "/" + user + ".txt";
    }
    
}
