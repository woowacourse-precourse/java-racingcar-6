package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitAnnotationTest {

    @ParameterizedTest
    @CsvSource({"jiwoo, Jiwoo", "woowa, Woowa"})
    void csvSourceTest(String lower, String upper) {
        System.out.println("lower = " + lower);
        System.out.println("upper = " + upper);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "jiwoo"})
    void valueSourceTest(String names) {
        System.out.println("names = " + names);
    }
}
