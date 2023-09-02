package refactoring;

import java.util.*;
import java.util.stream.Collectors;

public class LoopsSortsAndIfs {
    public static void main(String[] args) {
        Arrays.stream("this is an array of strings".split(" "))
                .filter(s -> s.length() % 2 == 0)
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}
