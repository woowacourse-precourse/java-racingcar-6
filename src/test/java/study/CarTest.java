package study;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

@DisplayName("자동차 객체 기능 테스트")
public class CarTest {
    @DisplayName("실패 : 자동차의 이름의 글자수가 1~5글자를 벗어나는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "여섯글자입력"})
    void test1(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("성공 : 자동차의 이름의 글자수가 1~5글자 이내인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"한", "다섯글자임"})
    void test2(String name) {
        assertThatCode(() -> new Car(name));
    }

    @Test
    void Car_이동메서드_체크() {
        Integer moveCount = 5;
        Car car = new Car("name");
        for (int i = 0; i < moveCount; i++) {
            car.processTurn();
        }
    }
}
