/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

    public static String lowerCase(String str) {
        String newString = ""; 
        char newChar; 
        int changer; 
        for(int i = 0; i < str.length();i++){
            newChar = str.charAt(i);
            if(newChar >= 'A' && newChar <= 'Z'){
                changer = (int)(newChar);
                changer = changer + 32;
                newChar = (char)changer; 
            }
            newString = newString + newChar;    
        }
        return newString;
    }
}