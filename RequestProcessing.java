import java.net.Socket;

class RequestProcessing implements Runnable
 {
    private Socket clientSocket;
    RequestProcessing(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run()
    {
        //Traitement à effectuer
    }
 }