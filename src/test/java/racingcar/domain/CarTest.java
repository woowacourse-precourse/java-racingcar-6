package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 입력한_이름_쉼표_기준_분리() {
        Car carsName = new Car();
        String[] nameArr = carsName.splitCarName("pobi,woni");
        assertThat(nameArr).contains("pobi", "woni");
    }
}