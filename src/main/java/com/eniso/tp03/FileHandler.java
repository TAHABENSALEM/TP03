/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.tp03;

/**
 *
 * @author DELL
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



import java.io.BufferedWriter;



import java.io.IOException;
import java.util.regex.Matcher;

public class FileHandler {

    public String filePath;
    public long fileSizeInKb;
    public long numberOfLines;
    public List<String> fileContent;

    public FileHandler(String filePath) {
        if (!Files.exists(Paths.get(filePath))) {
            System.err.println("Error: File not found: " + filePath);
            return;
        }

        this.filePath = filePath;

        try {
            this.fileSizeInKb = Files.size(Paths.get(filePath));
            this.numberOfLines = Files.lines(Paths.get(filePath)).count();
            this.fileContent = Files.lines(Paths.get(filePath)).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error: An error occurred while processing the file: " + e.getMessage());
        }
    }

    public List<String> findLinesWithPattern(String pattern) {
        List<String> matchingLines = new ArrayList<>();
        Pattern regexPattern = Pattern.compile(pattern);

        for (String line : fileContent) {
            Matcher matcher = regexPattern.matcher(line);
            if (matcher.find()) {
                matchingLines.add(line);
            }
        }
        return matchingLines;
}

    public static boolean compareStrings1(String str1, String str2) {
        return str1.equals(str2); // Comparaison basée sur l'égalité exacte des caractères
    }

    public static boolean compareStrings2(String str1, String str2) {
        return str1.equalsIgnoreCase(str2); // Comparaison sans tenir compte de la casse
    }

    public static boolean compareStrings3(String str1, String str2) {
        return str1 == str2 ; // Comparaison lexicographique
    }




    public void reverseString(int lineIndex) {
        if (lineIndex <= 0 || lineIndex > fileContent.size()) {
            System.err.println("Error: Invalid line index provided.");
            return;
        }

        String reversedLine = new StringBuilder(fileContent.get(lineIndex - 1)).reverse().toString();
        fileContent.set(lineIndex - 1, reversedLine);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void removeDuplicates(int lineIndex) {
        if (lineIndex <= 0 || lineIndex > fileContent.size()) {
            System.err.println("Error: Invalid line index provided.");
            return;
        }

        String line = fileContent.get(lineIndex - 1);
        Set<Character> uniqueChars = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (uniqueChars.add(c)) {
                sb.append(c);
            }
        }
        fileContent.set(lineIndex - 1, sb.toString());
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String l : fileContent) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
