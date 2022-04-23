package com.screens;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import com.services.Directory;


public class FileMenu implements Screen {
	private Directory dir = new Directory();
	
	public static WelcomeScreen welcome = new WelcomeScreen();
	
	private ArrayList<String> options = new ArrayList<String>();

	private Scanner in;


    public FileMenu() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }

	public void show() {
		// TODO Auto-generated method stub
		System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }
	}

	public void getUserInput() {
		// TODO Auto-generated method stub
		int selectedOption  = 0;
        in = new Scanner(System.in);
        do {
        	selectedOption = in.nextInt();
            this.navigateOption(selectedOption);
        }while (selectedOption != 4);
	}

	public void navigateOption(int option) {
		// TODO Auto-generated method stub
		switch(option) {

	        case 1: // Add File
	            this.addFile();
	            System.out.println();
	            this.show();
	            break;
	        case 2: // Delete File
	            this.deleteFile();
	            System.out.println();
	            this.show();
	            break;
	        case 3: // Search File
	            this.searchFile();
	            System.out.println();
	            this.show();
	            break;
	        
	        case 4: // Return to Menu
	        	System.out.println();
	        	welcome.show();
	            
	            break;
	       
	        default:
	            System.out.println("Invalid Option");
	            System.out.println();
	            this.show();
	            break;
		}
		
	}
	
	private void addFile() {
		// TODO Auto-generated method stub
        System.out.println("\nPlease Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);
        
		try {
			FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}

	private void deleteFile() {
		// TODO Auto-generated method stub
		System.out.println("\nPlease Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
        
	    //TODO: Delete file
        // Finished TODO
        
		Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	      }
	}

	private void searchFile() {
		// TODO Auto-generated method stub
		Boolean found = false;
    	
    	System.out.println("\nPlease Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
        
        //TODO Fix it so ArrayList obtains files
        //Finished TODO
        
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
	}
	
	private String getInputString() {

        in = new Scanner(System.in);
        return(in.nextLine());

    }

}
