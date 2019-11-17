import java.util.*;
/**
 * This program will decode a message from morse code to english.
 * 
 * Date 10.8.19
 * @author William Costa
 */
public class MorseDecoder {
    public static void main(String[] args) {
        //creating a scanner to read in the line of morse code
        //  replace with a string later.
        String out = "";
        ArrayList<String> decoded = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter message: ");
        String RawInp = reader.nextLine();
        morse(RawInp, out, decoded);
    }//end of main
    /**
     * Creates a Hashmap that contains the charactors for morse code as the keys and then the corresponding alphabetic letter or number as the value.
     * @return's a hashmap that contains the alphabet as the values and their corresponding morse code as the keys
     */
    public static HashMap<String, String> theKey() {
        String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

        String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----" };
        // morsecode, alphabet
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i <= 35; i++) {
            hm.put(morseCodes[i], alphabet[i]);
        }
        return hm;
    }//end of theKey

    /**
     * This method will call theKey() method and recieve a hashmap which it will then search for the given key
     * and return the value that corresponds with the key
     * @param input a string that contains morse code
     * @return's the value that corresponded with the given key
     */
    public static String decoder(String input) { //just sending the substring to be decoded
        String reInput = (String) theKey().get(input);
        return reInput;
    }

    /**
     * This method uses recursion to decode a message from morse code to english letters
     * @param RawInp a String that holds the users input from the main method
     * @param output is an empty string that will hold the decoded strings as it got through all the possible combinations
     */
    public static void morse(String RawInp, String output, ArrayList<String> decoded){//decoded does nothing
        if(RawInp.length() == 0){
            System.out.println(output); 
        }
        for (int i = 1; i <= RawInp.length(); i++){
            
            String subString = RawInp.substring(0, i);
            String temp = decoder(subString);
             
            if (theKey().containsValue(temp)){
                String sum = output + temp;
                decoded.add(sum);
                morse(RawInp.substring(i), output + temp, decoded);//figure "out" what morse is from notes
            }
        }
    
    }
    
}
