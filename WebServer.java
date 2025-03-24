
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private void readRequest(Socket Socket){
        try {
            
            BufferedReader input = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
            String response = input.readLine();
            System.out.println(response);

        } catch (Exception e) {
            System.err.println("Erreur de lecture" +e.getMessage());
        }
        
    }

        
    private void sendResponse(Socket Socket){
        try {
            OutputStream Output = Socket.getOutputStream();
            String Response = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nContent-Length: 27\r\n Requete traitee avec success";             
            Output.write(Response.getBytes());
            Output.flush();

        } catch (Exception e) {
           System.err.println("Erreur" +e.getMessage());
        }
            
    }

    
    public void run(int portNumber){
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {  
            System.out.println("Le serveur a démarré sur le port: "+portNumber);

            while(true){
                Socket ClientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion établie.");
                readRequest(ClientSocket);
                sendResponse(ClientSocket);
                ClientSocket.close();
                System.out.println("Fermeture de la connexion");
            }
        }catch(Exception e){
            System.err.println("Erreur de coonexion: " +e.getMessage());
        }
    }
}
