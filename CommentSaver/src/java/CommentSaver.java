
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
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
    
    String filePath;

    
    public CommentSaver() {
        //create folder
        filePath = System.getProperty("user.dir") + "/comments";
        File file = new File(filePath);
        if(!file.exists()) {
            if(! file.mkdir()) {
                System.err.println("ERROR making new directory");
                System.exit(1);
            }
        }
        // create file
        filePath += "/commentFile.txt";
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println("ERROR creating user file");
                System.exit(1);
            }
        }    
    }
    
    /**
     * This will add a comments to the end of the comments file.
     * User that made the comment, time, and date will be saved as well
     * @param user
     * @param comment 
     */
    public void add(String user, String comment) {
        File file = new File(filePath);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            // get the curretn time           
            Calendar c = Calendar.getInstance();
            writer.append("<h3>" 
                    + user + "-- Day:" + c.get(Calendar.DAY_OF_MONTH)
                    + " Month:" + c.get(Calendar.MONTH)
                    + " Year:" + c.get(Calendar.YEAR)
                    + " -- " + c.get(Calendar.HOUR) 
                    + ":" + c.get(Calendar.MINUTE) 
                    + ":" +  c.get(Calendar.SECOND) 
                    + "</h3>");
            writer.append("<p>" + comment + "</p>");
            writer.close();
        } catch (IOException ex) {
            System.err.println("ERROR writing to file");
            System.exit(1);
        }
        
    }
    
    /**
     * This gets all of the comments from the file, 
     * and returns it in reverse order
     * @return 
     */
    public String getUserComments() {
        Deque <String> deque = new LinkedList<String>();
        File file = new File(filePath);
        if(!file.exists()) {
            return "No Comments";
        }
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            String com = reader.readLine();
            while (com != null) {
                deque.addFirst(com + "\n\n");
                com = reader.readLine();
            }
            
        } catch (IOException e) {
            System.err.println("ERROR reader user file");
            System.exit(1);
        }
        // now to reverse the deque
        String comments = "";
        
        while(!deque.isEmpty()) {
            comments += deque.pollFirst();
        }
        
        return comments;
    }
    
}
