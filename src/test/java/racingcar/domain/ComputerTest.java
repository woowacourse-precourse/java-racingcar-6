package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Computer 도메인 테스트")
class ComputerTest {

    @Test
    void 사용자가_입력한_이름으로_자동차_생성() throws Exception {
        // given
        Computer computer = new Computer();

        // when
        List<String> carsName = List.of("car A", "car B");
        computer.generateCars(carsName);

        // then
        List<Car> cars = computer.getCars();
        Assertions.assertAll(
                () -> assertThat(cars).isNotNull(),
                () -> assertThat(cars).hasSize(carsName.size()),
                () -> assertThat(cars.get(0).getName()).isEqualTo(carsName.get(0))
        );
    }
}