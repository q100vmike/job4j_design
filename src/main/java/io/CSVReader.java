package io;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class  CSVReader {

    private static List<String> filterColumns = new ArrayList<>();

    private static void validation(ArgsName argsName) {
        File filein = new File(argsName.get("path"));
        if (!filein.isFile()) {
            throw new IllegalArgumentException("1'st argument are wrong!");
        }
    }

    private static void setFilterColumn(String line) {
        String[] filter = line.split(",");
        filterColumns = Arrays.asList(filter);
    }
    public static void handle(ArgsName argsName) throws Exception {
        File file = new File(argsName.get("path"));
        String delimiter = argsName.get("delimiter");
        Map<String, List<String>> csv = new HashMap<>();
        List<String> values = new ArrayList<>();
        boolean firstLine = true;
        int counter = 0;
        String pattern = "\\" + delimiter + "|\r\n";
        StringBuilder resultCsv = new StringBuilder();

        validation(argsName);
        setFilterColumn(argsName.get("filter"));

        try (var scanner = new Scanner(file).useDelimiter(System.lineSeparator())) {
            String[] header = new String[0];
            String text = "";
            while (scanner.hasNextLine()) {
                text = scanner.next();
                if (firstLine) {
                    header = text.split(delimiter);
                    Arrays.stream(header)
                            .toList()
                            .forEach(s -> csv.put(s, new ArrayList<>()));
                    firstLine = false;
                    scanner.useDelimiter(pattern);
                } else {
                    csv.get(header[counter]).add(text);
                    counter = counter == header.length - 1 ? 0 : counter + 1;
                }
            }
            int length = csv.get(header[counter]).size();

            for (String col : filterColumns) {
                resultCsv.append(col).append(delimiter);
            }
            resultCsv.deleteCharAt(resultCsv.length() - 1)
                    .append(System.lineSeparator());
            for (int j = 0; j < length; j++) {
                for (String col : filterColumns) {
                    resultCsv.append(csv.get(col).get(j)).append(delimiter);
                }
                resultCsv.deleteCharAt(resultCsv.length() - 1)
                        .append(System.lineSeparator());
            }
            output(argsName.get("out"), resultCsv);
        }
    }
    public static void output(String path, StringBuilder text) throws IOException {
        if ("stdout".equals(path)) {
            System.out.println(text);
        } else {
            File file = new File("path");
            try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
                writer.write(String.valueOf(text));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("Program needs 4 arguments!");
        }

        ArgsName argsName = ArgsName.of(args);
        validation(argsName);
        setFilterColumn(argsName.get("filter"));

        handle(argsName);
    }
}