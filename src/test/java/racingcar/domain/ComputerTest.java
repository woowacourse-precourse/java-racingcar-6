package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Computer 도메인 테스트")
class ComputerTest {

    @DisplayName("사용자가 입력한 이름들로 자동차를 생성한다.")
    @Test
    void generateCars() throws Exception {
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