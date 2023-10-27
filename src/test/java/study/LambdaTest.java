package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class LambdaTest {

    @Test
    void map테스트() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .map(integer -> integer += 1)
                .collect(Collectors.toList())
                .forEach((integer) -> System.out.println(integer));
    }
}
