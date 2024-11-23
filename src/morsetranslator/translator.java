/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package morsetranslator;

/**
 *
 * @author semih
 */
public class translator {

    String[] morse = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
        "-----", ".----", "..---", "...--", "....-", ".....", "-....",
        "--...", "---..", "----.",
        ".-.-.-", "--..--", "..--..", ".----.", "-.-.--", "-..-.", "-.--.",
        "-.--.-", ".-...", "---...", "-.-.-.", "-...-", ".-.-.", "-....-",
        "..--.-", ".-..-.", "...-..-", ".--.-.",
        "-.-..", "--.-.", "..", "---.", "...-...", "..--"
    };

    char[] words = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '.', ',', '?', '\'', '!', '/', '(', ')', '&',
        ':', ';', '=', '+', '-', '_', '\"', '$', '@',
        'ç', 'ğ', 'ı', 'ö', 'ş', 'ü'
    };

    public String getWords(String txt, boolean mors, boolean word) {
        String output = "";

        if (!mors && word) {
            String[] temp = txt.split(" ");

            for (int i = 0; i < temp.length; i++) {
                if (temp[i].equals("/")) {
                    output += " ";
                    continue;
                }

                output += convertWord(temp[i]);
            }
        } else if (mors && !word) {
            char[] temp = txt.toLowerCase().toCharArray();
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == ' ') {
                    output += "/ ";
                    continue;
                }

                output += convertMorse(temp[i]) + " ";
            }
        }
        return output;
    }

    private String convertWord(String txt) {
        for (int i = 0; i < morse.length; i++) {
            if (txt.equals(morse[i])) {
                return String.valueOf(words[i]);
            }
        }
        return "(!)";
    }

    private String convertMorse(char word) {
        for (int i = 0; i < words.length; i++) {
            if (word == words[i]) {
                return morse[i];
            }
        }

        return "(!)";
    }
}
