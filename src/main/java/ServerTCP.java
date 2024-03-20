import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        int puerto = 5050;
        try {

            ServerSocket serverSocket = new ServerSocket(puerto);

            while (true){
                Socket socket = serverSocket.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String contenido = entrada.readLine();
                int cantidadCaracteres = contenido.split(" ").length;
                BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                salida.write("Respuesta desde el servidor: " + cantidadCaracteres + " palabras recibidas.\n");
                salida.flush();
                socket.close();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
