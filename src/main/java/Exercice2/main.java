/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercice2;

/**
 *
 * @author DELL
 */
public class main {
    public static void main(String[] args) {
// Clé de chiffrement
String key = "secret";
// Texte clair à chiffrer
String plaintext = "Hello, world";
// Création de l’objet XORCipher
XORCipher xorCipher = new XORCipher(key);
// Chiffrement du texte clair
String encryptedText = xorCipher.encrypt(plaintext);
System.out.println("Texte chiffré : " + encryptedText);
// Déchiffrement du texte chiffré
String decryptedText = xorCipher.decrypt(encryptedText);
System.out.println("Texte déchiffré : " + decryptedText);
}
}
