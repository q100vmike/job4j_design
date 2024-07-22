package serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Film {

    private String name;
    private boolean hit;
    private List<String> genre;
    private int year;
    private Person starring;

    public Film(String name, boolean hit, List<String> genre, int year, Person starring) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.starring = starring;
        this.hit = hit;
    }

    public static void main(String[] args) {
        Film film = new Film("Alien", true, List.of("Action", "Horror"), 1979,
                new Person("Sigourney Weaver", 30));
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(film));
    }
}
