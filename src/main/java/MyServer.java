import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class MyServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(2663);
        Socket ssocket = serverSocket.accept();
        System.out.println("Connection from: " + ssocket.getInetAddress() + " " + ssocket.getPort() + "!");
        InputStream inputStream = ssocket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        List<Person> personsOnServer = (List<Person>) objectInputStream.readObject();
        System.out.println("recieved " + personsOnServer.size() + " persons");
        System.out.println("All persons:");
        personsOnServer.forEach((p) -> System.out.println(p.name + " " + p.age));
    }
}
