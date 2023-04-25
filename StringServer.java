import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    String input = "";


    public String handleRequest(URI url){
        if(url.getPath().equals("/")){
            return String.format("This is your string : %s", input);
        }
        else{
            System.out.println("Path: " + url.getPath());
            if(url.getPath().contains("/add-message")){
                String[] parameters = url.getQuery().split("=");
                input += parameters[1] + "\n";
                return String.format("Your string has been updated! Its now this: %s", input);
            }
        }
        return "404 Not Found!";
            
    }


}

class StringServer{
    public static void main(String[] args) throws IOException{
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49141");
            return;
        }
        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

