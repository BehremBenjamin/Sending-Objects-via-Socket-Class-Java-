import java.io.Serializable;

public class Person  implements Serializable {
    String name;
    int age;

    public Person(String name, int godiste) {
        this.name=name;
        this.age = godiste;
    }
    public String getIme() {
        return name;
    }
    public int get() {
        return age;
    }
}
