import java.io.File;
import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String path = sc.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {

            System.out.println("\nFiles in the directory:");

            File[] files = dir.listFiles();

            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                }
            }

        } else {
            System.out.println("Invalid Directory");
        }

        sc.close();
    }
}
