package com.screens;

import java.util.*;

import com.services.FileService;


public class WelcomeScreen implements Screen {
	
	public static FileMenu file = new FileMenu();
	
	private String welcomeText = "Welcome to Virtual Key For Your Repositories!";
	private String developerText = "Developer: Shubham Patel";
	    
	private ArrayList<String> options = new ArrayList<String>();
	private Scanner in;


	public WelcomeScreen() {
		options.add("1. Show Files");
	    options.add("2. File Operations Menu");
	    options.add("3. Quit");
	}
	

	public void introWS() {
		System.out.println(welcomeText);
		System.out.println(developerText);
		System.out.println();
		show();
	}

	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Main Menu");
        for (String s : options)  {
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
        }while (selectedOption != 3);
	}

	public void navigateOption(int option) {
		// TODO Auto-generated method stub
		switch(option) {
	    	case 1: // Show Files in Directory
	    		this.showFiles();
	    		System.out.println();
	    		this.show();            
	    		break;
	        
	        case 2: // Show File Operation menu
	        	System.out.println();
	        	file.show();
	        	file.getUserInput();
	            break;
	        
	        case 3:
	        	System.out.println("Thank you for joining us......");
	        	System.out.println("Have a good day!!");
	            break;
	        default:
	            System.out.println("Invalid Option");
	            System.out.println();
	            this.show();
	            break;
	}
	}

	public void showFiles() {

        //Get the files from the Directory
        System.out.println("List of Files: ");
    	FileService.printFiles();

    }

}
