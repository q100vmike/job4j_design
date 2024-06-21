package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> result = new ArrayList<String>();

        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            input.lines()
                    .filter(l -> "404".equals(l.substring(l.lastIndexOf(" ") - 3, l.lastIndexOf(" "))))
                    .forEach(result :: add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
    }
}