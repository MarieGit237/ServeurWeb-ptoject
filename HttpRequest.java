import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest {
    
    private String method;

    private String url;
    
    private void readClientRequest(Socket socket){
        try {
            
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = "";
            while((response = input.readLine()).isEmpty() == false)
            System.out.println(response);

        } catch (Exception e) {
            System.err.println("Erreur de lecture" +e.getMessage());
        }
    }

    public void HttpRequest(Socket socket){

    }

   public  String getMethod(){
        return method;
    }

    public String getUrl(){
        return url;
    }


}
