package racingcar.model;

import model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static final int STANDARD_VALUE = 4;
    private static final int RANDOM_NUMBER = 5;

    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "lisalisa", "jinyjiny"})
    @DisplayName("5글자 이상 이름 입력시 Car객체 생성 예외 발생 테스트")
    public void Car_객체_이름_입력_예외_테스트(String input) {
        //given
        String name = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 미만");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("공백 혹은 빈 문자열 이름 입력시 Car객체 생성 예외 발생 테스트")
    public void Car_객체_이름_입력_예외_테스트_공백_빈문자열(String input) {
        //given
        String name = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 혹은 빈");
    }

    @Test
    @DisplayName("임의의 수가 기준 값보다 크면 movingCount 증가하는지 테스트")
    public void 기준_값_보다_큰_임의의_수_증가_테스트() {
        //given
        Car car = new Car("pobi");
        int movingCount = car.getMovingCount();

        //when
        car.increaseMovingCountIfGreater(STANDARD_VALUE, RANDOM_NUMBER);
        int expectedMovingCount = movingCount + 1;
        int currentMovingCount = car.getMovingCount();

        //then
        Assertions.assertThat(currentMovingCount).isEqualTo(expectedMovingCount);

    }

}
