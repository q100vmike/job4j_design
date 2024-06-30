package io;
import java.io.*;
import java.util.StringJoiner;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean start = false;
        StringJoiner output = new StringJoiner("");

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith("400") || line.startsWith("500")) {
                    if (!start) {
                        output.add(line.substring(4) + ";");
                        start = true;
                    }
                } else {
                    if (start) {
                        output.add(line.substring(4) + ";");
                        output.add(System.lineSeparator());
                        start = false;
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            writer.write(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}