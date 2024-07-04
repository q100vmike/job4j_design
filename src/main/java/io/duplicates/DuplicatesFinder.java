package io.duplicates;

import io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        Map<FileProperty, Set<String>> duplicates = duplicatesVisitor.getDuplicate();
        duplicates.forEach((file, set) -> {
            System.out.println(file.getName().toString() + "-" + (((double) file.getSize() / 1024) / 1024) + "Mb");
            set.forEach(p -> System.out.println(p.toString()));
        });
    }
}