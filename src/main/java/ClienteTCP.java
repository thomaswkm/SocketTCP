import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5050;

        try {
            Socket clienteSocket = new Socket(host,puerto);
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(clienteSocket.getOutputStream()));
            salida.write(new Scanner(System.in).nextLine());
            salida.newLine();
            salida.flush();

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            String respuesta = entrada.readLine();
            System.out.println(respuesta);
            clienteSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
