
abstract class Cipher {
    public abstract String encrypt(String plainText);
    public abstract String decrypt(String cipherText);
    
    public void displayInformation(String cipherName) {
        System.out.println("--- Using " + cipherName + " ---");
    }
}

class CaesarCipher extends Cipher {
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plainText) {
        StringBuilder result = new StringBuilder();
        for (char character : plainText.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int newPosition = (character - base + shift) % 26;
                result.append((char) (base + newPosition));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String cipherText) {
        StringBuilder result = new StringBuilder();
        for (char character : cipherText.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int newPosition = (character - base - (shift % 26) + 26) % 26;
                result.append((char) (base + newPosition));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}

class ReverseCipher extends Cipher {

    @Override
    public String encrypt(String plainText) {
        return new StringBuilder(plainText).reverse().toString();
    }

    @Override
    public String decrypt(String cipherText) {
        return new StringBuilder(cipherText).reverse().toString();
    }
}

// Main execution class
public class Program6 {
    public static void main(String[] args) {
        String secretMessage = "Hello Java World!";
        System.out.println("Original Message: " + secretMessage + "\n");
        Cipher myCaesar = new CaesarCipher(3); // Shift by 3
        myCaesar.displayInformation("Caesar Cipher");
        
        String encryptedCaesar = myCaesar.encrypt(secretMessage);
        System.out.println("Encrypted: " + encryptedCaesar);
        System.out.println("Decrypted: " + myCaesar.decrypt(encryptedCaesar) + "\n");

        Cipher myReverse = new ReverseCipher();
        myReverse.displayInformation("Reverse Cipher");
        
        String encryptedReverse = myReverse.encrypt(secretMessage);
        System.out.println("Encrypted: " + encryptedReverse);
        System.out.println("Decrypted: " + myReverse.decrypt(encryptedReverse));
    }
}