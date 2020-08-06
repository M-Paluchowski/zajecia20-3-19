import com.google.common.collect.Streams;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("Ania", "Tomek", "Joanna");
        Stream<Integer> ages = Stream.of(18, 28, 13);

        Streams.zip(names, ages, (name, age) -> name + "_" + age)
            .forEach(System.out::println);

        List<Integer> first = List.of(1, 2, 3, 4, 5);
        List<Integer> second = List.of(4, 5, 6, 7, 8);

        Collection<Integer> disjunction = CollectionUtils.disjunction(first, second);
        System.out.println(disjunction);

        Collection<Integer> intersection = CollectionUtils.intersection(first, second);
        System.out.println(intersection);

        List<Integer> integers = List.of(1, 2, 3, 4);
        Collection<List<Integer>> permutations = CollectionUtils.permutations(integers);
        System.out.println(permutations);

        //Apache Commons Collections, Apache Commons Lang, Apache Commons Math, Google Guava
    }
}
