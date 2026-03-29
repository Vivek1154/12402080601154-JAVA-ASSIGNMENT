import java.io.*;
import java.net.*;

public class Program7Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String msg;
            while (true) {
                System.out.print("Enter message: ");
                msg = userInput.readLine();

                out.println(msg);

                String response = in.readLine();
                System.out.println(response);

                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
