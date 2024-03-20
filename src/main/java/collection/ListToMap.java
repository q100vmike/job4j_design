package collection;

import java.util.stream.Collectors;
import java.util.stream.Stream;
public class ListToMap {
    public static void main(String[] args) {
        int p = 0;
        System.out.println(
                Stream.of(1, 1, 2, 2).collect(
                        Collectors.toMap(
                                e -> e,
                                e -> e * e,
                                (existing, replacement) -> existing
                        ))
        );
        System.out.println("Приехали!!!!!!!!!");
    }
}
