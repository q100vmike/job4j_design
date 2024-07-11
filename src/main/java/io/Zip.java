package io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private ArgsName argsName;

    private void validateArgs(String[] args) {
        argsName = ArgsName.of(args);
        if (args.length < 3) {
            throw new IllegalArgumentException("Program needs 3 arguments!");
        }
        File file = new File(argsName.get("d"));
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("1'st argument are wrong!");
        }
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException("2'nd argument are wrong!");
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("3'nd argument are wrong!");
        }
    }

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                String src = String.valueOf(source);
                zip.putNextEntry(new ZipEntry(src));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(src))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void zipFiles() throws IOException {
        List<Path> sources = Search.search(Paths.get(argsName.get("d")),
                path -> !path.toFile()
                        .getName().endsWith(argsName.get("e")));
        packFiles(sources, new File(argsName.get("o")));
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.validateArgs(args);
        zip.zipFiles();

        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}