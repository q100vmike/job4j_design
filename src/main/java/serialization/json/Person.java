package serialization.json;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.json.JSONPropertyIgnore;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int age;

    private Film film;

    public void setFilm(Film film) {
        this.film = film;
    }

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @JSONPropertyIgnore
    public Film getFilm() {
        return film;
    }

    public void setName(String name) {
        this.name = name;
    }
}
