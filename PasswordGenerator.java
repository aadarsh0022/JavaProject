import java.util.*;

public class PasswordGenerator {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Get user's preferences
        System.out.print("Do you want to use uppercase letters? (Yes/No) ");
        String useUppercase = input.nextLine().toLowerCase();
        
        System.out.print("Do you want to use lowercase letters? (Yes/No) ");
        String useLowercase = input.nextLine().toLowerCase();
        
        System.out.print("Do you want to use numbers? (Yes/No) ");
        String useNumbers = input.nextLine().toLowerCase();
        
        System.out.print("Do you want to use symbols? (Yes/No) ");
        String useSymbols = input.nextLine().toLowerCase();
        
        // Get desired password length
        System.out.print("Enter desired password length: ");
        int passwordLength = input.nextInt();
        
        // Build password alphabet
        String passwordAlphabet = "";
        if (useUppercase.equals("yes")) {
            passwordAlphabet += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (useLowercase.equals("yes")) {
            passwordAlphabet += "abcdefghijklmnopqrstuvwxyz";
        }
        if (useNumbers.equals("yes")) {
            passwordAlphabet += "0123456789";
        }
        if (useSymbols.equals("yes")) {
            passwordAlphabet += "!@#$%^&*()_+-=[]{}\\|;':\",./<>?";
        }
        
        // Generate password
        String password = "";
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(passwordAlphabet.length());
            password += passwordAlphabet.charAt(randomIndex);
        }
        System.out.println("Generated Password: " + password);
        
        // Check password strength
        int score = 0;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else {
                hasSymbol = true;
            }
        }
        if (hasUppercase) {
            score++;
        }
        if (hasLowercase) {
            score++;
        }
        if (hasNumber) {
            score++;
        }
        if (hasSymbol) {
            score++;
        }
        if (password.length() >= 8) {
            score++;
        }
        if (password.length() >= 16) {
            score++;
        }
        
        // Display strength information
        System.out.println("\nPassword Strength:");
        if (score <= 2) {
            System.out.println("- Weak password. It is recommended to use a stronger password.");
        } else if (score == 3) {
            System.out.println("- Medium strength password.");
        } else if (score == 4) {
            System.out.println("- Good password.");
        } else if (score == 5) {
            System.out.println("- Great password!");
        }
        
        // Display useful information
        System.out.println("\nPassword Security Tips:");
        System.out.println("- Avoid using the same password for multiple accounts.");
        System.out.println("- Avoid using easily guessable passwords, such as dictionary words or letter/number sequences.");
}
}