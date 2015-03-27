package com.ira;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by iryna.sribna on 27.03.2015.
 */
public class FileTreeWalkFind {

    //search with recursive
    public static void main(String[] args) {
        if (args.length !=2) {
            System.out.println("usage: FileTreeWalkFind <start-path> <file-name>");
            System.exit(-1);
        }

        Path startPath = Paths.get(args[0]).toAbsolutePath();
        String fileToSearch = args[1];

        try {
            Files.walkFileTree(startPath, new MyFileFindVisitor(fileToSearch));
            System.out.println("Search is done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
