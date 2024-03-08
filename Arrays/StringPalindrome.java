package Arrays;

public class StringPalindrome {
    public static boolean palindrome(String word){
        char[] letters= word.toCharArray();

        int j=letters.length-1;
        int i=0;

        while(i<j){
            if (letters[i]!=letters[j])
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean result= palindrome("madam");
        System.out.println(result? "It is a palindrome": "It is not a palindrome");

        result=palindrome("that");
        System.out.println(result? "It is a palindrome": "It is not a palindrome");
    }
}
