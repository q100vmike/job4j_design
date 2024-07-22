package serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Film {

    private String name;
    private List<String> genre;
    private int year;
    private Person starring;

    public Film(String name, List<String> genre, int year, Person starring) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.starring = starring;
    }

    public static void main(String[] args) {
        Film film = new Film("Alien", List.of("Action", "Horror"), 1979,
                new Person("Sigourney Weaver", 30));
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(film));
    }
}
