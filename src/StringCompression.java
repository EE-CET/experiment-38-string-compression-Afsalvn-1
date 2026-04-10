import java.util.Scanner;

public class StringCompression {

    // Task: Perform basic string compression using character counts
    public String compress(String s) {
        // If string is too short, compression won't help
        if (s == null || s.length() <= 2) return s;

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            // Look ahead: is the next character the same as the current one?
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                // Character has changed or we reached the end
                compressed.append(s.charAt(i));
                compressed.append(count);
                count = 1; // Reset counter for the next unique character
            }
        }

        String result = compressed.toString();
        
        // Constraint: Return original if compressed is not smaller
        return result.length() < s.length() ? result : s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String s = sc.nextLine();
            StringCompression scObj = new StringCompression();
            System.out.println(scObj.compress(s));
        }
        sc.close();
    }
}
