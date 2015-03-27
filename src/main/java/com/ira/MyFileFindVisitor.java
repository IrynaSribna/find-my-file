package com.ira;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by iryna.sribna on 27.03.2015.
 */
public class MyFileFindVisitor extends SimpleFileVisitor<Path> {
    private String fileName;

    public MyFileFindVisitor(String fileName) {
        this.fileName = fileName;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }

    private void find(Path path) {
        Path name = path.getFileName();
        if (fileName.equals(name.getFileName().toString())) {
            System.out.println("Found the file: " + path.toUri());
        }
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }
}
