package com.services;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Directory {
	public static final String name = "directory/";

    private ArrayList<File> files = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    
    File Dfiles = path.toFile();
    
    public String getName() {
        return name;
    }
 
    public ArrayList<File> fillFiles() {
    	
        File[] directoryFiles = Dfiles.listFiles();
        
        
        
    	files.clear();
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    		else {
    			System.out.println("This is the empty directory.");
    		}
    	}
    	
    	Collections.sort(files);
    	
    	return files;
    }
    
    public ArrayList<File> getFiles() {
    	
    	fillFiles();
    	return files;
    }
}
