public class WebServerApplication {
    public static void main(String[] args) {
        int portNumber = 80;
        WebServer webserver = new WebServer();
        webserver.run(portNumber);
    }
}
