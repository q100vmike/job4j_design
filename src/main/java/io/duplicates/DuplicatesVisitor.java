package io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, Set<String>> map = new HashMap<>();

    public Map<FileProperty, Set<String>> getDuplicate() {
        return map.entrySet().stream()
                .filter(d -> d.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(attributes.size(), file.getFileName().toString());
        map.merge(fileProperty, new HashSet<>(Arrays.asList(file.toAbsolutePath().toString())),
                (prev, next) -> {
                    prev.add(file.toAbsolutePath().toString());
                    return prev;
                });
        return super.visitFile(file, attributes);
    }
}