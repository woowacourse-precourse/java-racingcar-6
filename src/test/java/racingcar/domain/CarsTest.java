package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("유효한 이름 배열로 인스턴스 생성")
    void constructor_유효한_이름_배열() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);
    }

    @Test
    @DisplayName("유효하지 않은 이름 배열로 인스턴스 생성 시 예외 발생")
    void constructor_유효하지_않은_이름_배열() {
        List<String> names = Arrays.asList("pobi", "  wi", "jun");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Cars(names);
        });
    }

    @Test
    @DisplayName("중복 이름이 있는 배열로 인스턴스 생성 시 예외 발생")
    void constructor_중복_이름_있는_배열() {
        List<String> names = Arrays.asList("pobi", "pobi", "jun");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Cars(names);
        });
    }
}