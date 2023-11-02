import java.util.Scanner;

public class Password {

    public static void main(String[] args) {

        // Password parameters
        final int NUM_LOWER_LETTERS = 1;
        final int NUM_UPPER_LETTERS = 1;
        final int NUM_DIGITS = 1;
        final int NUM_SPECIAL_CHARACTERS = 1;
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int sCharacterCount = 0;

        // Scanner and user input
        Scanner userInput = new Scanner(System.in);
        Scanner userConfirm = new Scanner(System.in);
        System.out.println("Please enter your new password: ");
        String input = userInput.nextLine();
        int inputLength = input.length();
        userInput.close();

        // Loop through user input for password parameters
        for(int i=0; i<inputLength; i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch))
                upperCount++;
            else if (Character.isLowerCase(ch))
                lowerCount++;
            else if (Character.isDigit(ch))
                digitCount++;
        }

        // Enforce password parameters
        if(upperCount >= NUM_UPPER_LETTERS && lowerCount >= NUM_LOWER_LETTERS && digitCount >= NUM_DIGITS){
            System.out.println("Valid password");
            System.out.println("Please re-enter your password to confirm: ");
            String input2 = userConfirm.nextLine();
            if(userConfirm != userInput){
                System.out.println("Passwords do not match.");
            } else {
                System.out.println("Password created successfully.");
            }
            
        }else{
            System.out.println("The password did not have enough of the following:");
                if(upperCount < NUM_UPPER_LETTERS)
                    System.out.println("Uppercase letters");
                if(lowerCount < NUM_LOWER_LETTERS)
                    System.out.println("Lowercase letters");
                if(digitCount < NUM_DIGITS)
                    System.out.println("Numbers");
                if(sCharacterCount < NUM_SPECIAL_CHARACTERS)
                    System.out.println("Special Characters");
                if(inputLength < 8)
                    System.out.println("Length of password needs to be at least 8 characters.");
                if(inputLength > 16)
                    System.out.println("Length of password must be less than 16 characters.");
        }
    }
}