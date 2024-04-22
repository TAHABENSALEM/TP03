/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercice2;

/**
 *
 * @author DELL
 */
public class XORCipher {
    public String key;

    public XORCipher(String key) {
        this.key = key;
    }
    public String encrypt(String plaintext) {
        StringBuffer ciphertext = new StringBuffer();
        for (int i = 0; i < plaintext.length(); i++) {
            int plaintextValue = plaintext.charAt(i);
            int keyValue = this.key.charAt(i % this.key.length());
            int encryptedValue = plaintextValue ^ keyValue;
            ciphertext.append((char) encryptedValue);
        }
        return ciphertext.toString();
    }
    public String decrypt(String ciphertext) {
        StringBuffer decryptedText = new StringBuffer();
        for (int i = 0; i < ciphertext.length(); i++) {
            int ciphertextValue = ciphertext.charAt(i);
            int keyValue = this.key.charAt(i % this.key.length());
            int decryptedValue = ciphertextValue ^ keyValue;
            decryptedText.append((char) decryptedValue);
        }
        return decryptedText.toString();
    }
}