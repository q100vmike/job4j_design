package io;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVReader {

    private List<String> filterColumns = new ArrayList<>();

    private int maxColunn = 0;




    private void validation(ArgsName argsName) {
        File file = new File(argsName.get("path"));
        if (!file.isFile()) {
            throw new IllegalArgumentException("1'st argument are wrong!");
        }
        file = new File(argsName.get("out"));
        if (!("stdout".equals(argsName.get("out"))) && !file.isDirectory()) {
            throw new IllegalArgumentException("3'd argument are wrong!");
        }
    }

    private void setFilterColumn(String line, String delimiter) {
        String[] filter = line.split(delimiter);
        filterColumns = Arrays.asList(filter);
    }
    public static void handle(ArgsName argsName) throws Exception {
        File file = new File(argsName.get("path"));
        Map<String, List<String>> csv = new HashMap<>();
        List<String> values = new ArrayList<>();
     /*   int j = 0;
        String[] filter = argsName.get("filter").split(",");
        List<Integer> colNumber = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(argsName.get("path")))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line == null) break;
                j++;
                var scanner = new Scanner(line).useDelimiter(argsName.get("delimiter"));
                while (scanner.hasNext()) {
                    var column = scanner.next();
                    if (j == 1) {
                        for (int i = 0; i < filter.length - 1; i++) {
                            if (column.equalsIgnoreCase(filter[i])) {
                                colNumber.add(i);
                            }
                        }
                    } else {

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try (var scanner = new Scanner(file).useDelimiter(System.lineSeparator())) {
            //argsName.get("delimiter")
            while (scanner.hasNextLine()) {
                    String text = scanner.next();
                Arrays.stream(text.split(";"))
                        .forEach(s -> csv.put(s, new ArrayList<>()));


                    System.out.println(text);
                scanner.useDelimiter(";");

                //scanner.useDelimiter(";");
                //System.out.println(scanner.next());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        /* здесь добавьте валидацию принятых параметров
        *  -path=file.csv -delimiter=;  -out=stdout -filter=name,age
        * */
/*        if (args.length < 4) {
            throw new IllegalArgumentException("Program needs 4 arguments!");
        }
        ArgsName argsName = ArgsName.of(args);

        File file = new File(argsName.get("path"));
        if (!file.isFile()) {
            throw new IllegalArgumentException("1'st argument are wrong!");
        }
        file = new File(argsName.get("out"));
        if (!("stdout".equals(argsName.get("out"))) && !file.isDirectory()) {
            throw new IllegalArgumentException("3'd argument are wrong!");
        }*/
        if (args.length < 4) {
            throw new IllegalArgumentException("Program needs 4 arguments!");
        }
        CSVReader reader = new CSVReader();
        ArgsName argsName = ArgsName.of(args);
        reader.validation(argsName);
        reader.setFilterColumn(argsName.get("filter"), argsName.get("delimiter"));

        handle(argsName);
    }
}