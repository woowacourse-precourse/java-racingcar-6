package racingcar.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.Entity.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParsingTest {

    private static Parsing parsing;

    @BeforeAll()
    static void Parsing_객체_생성() {
        parsing = new Parsing();
    }

    @Test()
    void 문자열_컴마기준_분리_컴마있음() {
        String testString = "a,b,c";
        List<Car> test = parsing.StringToCarList(testString);

        assertThat(test).extracting(Car::getName).containsExactly("a","b","c");
    }

    @Test()
    void 문자열_컴마기준_분리_컴마없음() {
        String testString = "abc";
        List<Car> test = parsing.StringToCarList(testString);

        assertThat(test).extracting(Car::getName).containsExactly("abc");
    }

    @Test()
    void 문자열_컴마기준_분리_띄어쓰기_포함해서_잘림() {
        String testString = "a, b,c";
        List<Car> test = parsing.StringToCarList(testString);

        assertThat(test).extracting(Car::getName).containsExactly("a"," b","c");
    }

    @Test()
    void 문자열_숫자변환() {
        String testString = "12";
        assertThat(parsing.stringToInt(testString)).isEqualTo(12);
    }
}