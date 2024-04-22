/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.tp03;

/**
 *
 * @author DELL
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main {
    

public static void main(String[] args) {
FileHandler fileHandler = new FileHandler("C:\\Users\\DELL\\Desktop\\fichier.txt");
int lineIndexToReverse = 1;
fileHandler.reverseString(lineIndexToReverse);
int lineIndexToRemoveDuplicates = 2;
fileHandler.removeDuplicates(lineIndexToRemoveDuplicates);

String pattern = "epoch";
ArrayList<String> linesWithPattern = (ArrayList<String>) fileHandler.findLinesWithPattern(pattern);
String str1 = "hello";
String str2 = "Hello";
System.out.println("Comparaison avec equals : " + fileHandler.compareStrings1(str1, str2));
String str5 = "hello";
String str6 = "HELLO";
System.out.println("Comparaison avec equalsIgnoreCase : " + fileHandler.compareStrings3(str5,
str6));
String str7 = "hello";
String str8 = "hello";
System.out.println("Comparaison avec == : " + fileHandler.compareStrings3(str7, str8));
System.out.println("Comparaison avec == : "+ fileHandler.compareStrings3(new
String("hello"),"hello"));
System.out.println("Comparaison avec == : "+ fileHandler.compareStrings3(new String("hello"),
new String("hello")));
System.out.println("Ligne contenant le motif ’" + pattern + "’ : " + linesWithPattern.get(0));
}
}