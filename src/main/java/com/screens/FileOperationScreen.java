package com.screens;

import java.util.*;

public class FileOperationScreen implements Screen {
	
	public static WelcomeScreen welcome = new WelcomeScreen();
	
	private ArrayList<String> options = new ArrayList<String>();

	private Scanner in;


    public FileOperationScreen() {
    	
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
		System.out.println("Inside Add File method");
	}

	private void deleteFile() {
		// TODO Auto-generated method stub
		System.out.println("Inside Delete File method");
	}

	private void searchFile() {
		// TODO Auto-generated method stub
		System.out.println("Inside Search File method");
	}

}
