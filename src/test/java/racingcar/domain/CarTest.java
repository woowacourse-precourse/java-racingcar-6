package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("0에서 9 사이에서 무작위 값 반환 테스트")
    void generateThreeRandomNumbers() {
        int randomNumber = car.getRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}