package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines()
                    .filter(l -> !l.startsWith("#"))
                    .filter(l -> !l.isEmpty())
                    .filter(l -> {
                        if (!l.matches("^.+=.+$")) {
                            throw new IllegalArgumentException("not possible inside yml file");
                        }
                        return true;
                    })
                    .map(line -> line.split("=", 2))
                    .collect(Collectors.toMap(s -> s[0], s -> s[1]))
                    .entrySet()
                    .forEach(entry -> values.put(entry.getKey(), entry.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Config("data/app.properties"));
        Config cfg = new Config("data/pair_with_error.properties");
        cfg.load();
    }

}