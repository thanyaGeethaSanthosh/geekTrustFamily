package com.geektrust.io;

import java.util.Scanner;

public class FileScanner {
    private final Scanner fileScanner;

    public FileScanner(Scanner scanner) {
        this.fileScanner = scanner;
    }

    public boolean hasNext() {
        return fileScanner.hasNext();
    }

    public String nextLine() {
        return fileScanner.nextLine();
    }
}
