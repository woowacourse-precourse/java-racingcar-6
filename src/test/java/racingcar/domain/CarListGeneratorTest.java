package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarListGeneratorTest {

    @Test
    void getCarList_입력순서_유지하며_객체를_생성하는지_테스트() {
        // given
        List<String> carStrings = Arrays.asList("pobi", "woni", "jun", "zzz", "cba", "abc");
        // when
        List<Car> carList = CarListGenerator.getCarList(carStrings);
        List<String> carNames = carList.stream()
                .map(Car::getName)
                .toList();
        // then
        assertThat(carNames).isEqualTo(carStrings);
    }
}