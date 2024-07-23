package serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class SerializeToJsonObject {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Action");
        list.add("Horror");
        JSONArray jsonGanre = new JSONArray(list);
        Person person = new Person("Sigourney Weaver", 30);

        final Film film = new Film("Alien", true, List.of("Action", "Horror"), 1979);
        film.setPerson(person);
        person.setFilm(film);

        JSONObject jsonPerson = new JSONObject(person);

        JSONObject jsonFilm = new JSONObject();
        jsonFilm.put("name", film.getName());
        jsonFilm.put("hit", film.isHit());
        jsonFilm.put("year", film.getYear());
        jsonFilm.put("starring", jsonPerson);
        jsonFilm.put("genre", jsonGanre);

        System.out.println(jsonFilm.toString());
        System.out.println(new JSONObject(film).toString());
    }
}
