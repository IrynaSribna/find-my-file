package com.ira;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class FindMyFile
{
    public static void main(String[] args)
    {
        if (args.length != 2) {
            System.err.println("Wrong number of arguments. Correct usage: path to directory and file name");
            System.exit(-1);
        }

        String directory = args[0];
        String fileName = args[1];

        Path directoryPath = Paths.get(directory).toAbsolutePath();

        File dir = new File(directory);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("The provided path to the directory is invalid");
        }

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
            boolean found = false;
            for (Path path : directoryStream) {
                if (path.getFileName().toString().equals(fileName)) {
                    System.out.println("File is found: " + path.toUri());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("File not found within Directory!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
