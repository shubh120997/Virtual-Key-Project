package com.services;

import java.io.File;


public class FileService {
	private static Directory fileDirectory = new Directory();
    
    public static void printFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : FileService.fileDirectory.getFiles())
        {
            System.out.println(file.getName());
        }
    }
    
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        FileService.fileDirectory = fileDirectory;
    }
}
