package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class LambdaTest {

    @Test
    void map_테스트() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .map(integer -> integer += 1)
                .collect(Collectors.toList())
                .forEach((integer) -> System.out.println(integer));
    }

    @Test
    void max_테스트() {
        Integer integer = Integer.valueOf(10);
        Integer integer2 = Integer.valueOf(200);
        Integer integer3 = Integer.valueOf(200);

        List<Integer> integerList = Arrays.asList(integer, integer2, integer3);

        Integer maxInteger = integerList.stream()
                .max(Integer::compareTo)
                .get();

        System.out.println(maxInteger);
    }
}
