import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket clientSocket = new Socket("localhost", 2663);
        System.out.println("connected to the server on port: " + clientSocket.getPort());
        OutputStream outputStream = clientSocket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("person 1", 35));
        persons.add(new Person(" person 2", 22));
        persons.add(new Person("person 3", 21));
        persons.add(new Person("person 4", 8));
        System.out.println("Sending persons to the server...");
        objectOutputStream.writeObject(persons);
        System.out.println("closing connection...");
        clientSocket.close();
    }
}
