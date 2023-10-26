package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JunitAnnotationTest {

    @ParameterizedTest
    @CsvSource({"jiwoo, Jiwoo", "woowa, Woowa"})
    void csvSourceTest(String lower, String upper) {
        System.out.println("lower = " + lower);
        System.out.println("upper = " + upper);
    }
}
