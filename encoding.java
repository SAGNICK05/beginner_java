// import required classes and package, if any    
import java.util.Scanner; 
import java.io.*;  

// create class CaesarCipherExample for encryption and decryption    
public class encoding 
{   
    // ALPHABET string denotes alphabet from a-z   
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   

    // create encryptData() method for encrypting user input string with given shift key   
    public static String encryptData(String inputStr, int shiftKey)   
    {   
        // convert inputStr into lower case   
        inputStr = inputStr.toLowerCase();   

        // encryptStr to store encrypted data   
        String encryptStr = "";   

        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++)   
        {   
            // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));   

            // get encrypted char for each char of inputStr   
            int encryptPos = (shiftKey + pos) % 26;   
            char encryptChar = ALPHABET.charAt(encryptPos);   

            // add encrypted char to encrypted string   
            encryptStr += encryptChar;   
        }   

        // return encrypted string   
        return encryptStr;   
    }   

    // create decryptData() method for decrypting user input string with given shift key   
    public static String decryptData(String inputStr, int shiftKey)   
    {   
        // convert inputStr into lower case   
        inputStr = inputStr.toLowerCase();   

        // decryptStr to store decrypted data   
        String decryptStr = "";   

        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++)   
        {   

            // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));   

            // get decrypted char for each char of inputStr   
            int decryptPos = (pos - shiftKey) % 26;   

            // if decryptPos is negative   
            if (decryptPos < 0){   
                decryptPos = ALPHABET.length() + decryptPos;   
            }   
            char decryptChar = ALPHABET.charAt(decryptPos);   

            // add decrypted char to decrypted string   
            decryptStr += decryptChar;   
        }   
        // return decrypted string   
        return decryptStr;   
    }   

    // main() method start   
    public static void main(String[] args)   
    {   
        // create an instance of Scanner class   
        Scanner sc = new Scanner(System.in);   

        // take input from the user   
        System.out.println("Enter a string for encryption : ");   
        String inputStr = sc.nextLine();   

        System.out.println("Enter the shift: ");   
        int shiftKey = Integer.valueOf(sc.nextLine());   
        System.out.println("Encrypted Data ===> "+(encryptData(inputStr, shiftKey)).toUpperCase());   
        System.out.println("Decrypted Data ===> "+(decryptData(encryptData(inputStr, shiftKey), shiftKey)).toUpperCase());   

        // close Scanner class object   
        sc.close();   
    }   
}   