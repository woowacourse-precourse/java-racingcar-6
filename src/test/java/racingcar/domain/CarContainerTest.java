package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarContainerTest {
    private MockRandomPicker mockRandomPicker;
    private CarContainer carContainer;

    @BeforeEach
    void practice() {
        mockRandomPicker = new MockRandomPicker(List.of(4, 2, 4, 4, 2, 4, 4, 2, 4, 4, 2, 4, 4, 2, 4));
        carContainer = new CarContainer("pobi,junu,hana", mockRandomPicker);
    }

    @Test
    void move_함수를_호출했을때_진행이_되는_것을_확인() {
        carContainer.moveRacingCars();

        List<CarPositionDto> carPositionDtos = carContainer.toDto();
        assertThat(carPositionDtos.get(0).getStatus()).isEqualTo(1);
        assertThat(carPositionDtos.get(0).getCarName()).isEqualTo("pobi");

        assertThat(carPositionDtos.get(1).getStatus()).isZero();
        assertThat(carPositionDtos.get(1).getCarName()).isEqualTo("junu");

        assertThat(carPositionDtos.get(2).getStatus()).isEqualTo(1);
        assertThat(carPositionDtos.get(2).getCarName()).isEqualTo("hana");

    }

    @Test
    void findWinner_함수_우승자들이_반환() {
        carContainer.moveRacingCars();
        assertThat(carContainer.findWinner()).containsExactly("pobi", "hana");

        carContainer.moveRacingCars();
        assertThat(carContainer.findWinner()).containsExactly("pobi", "junu", "hana");

    }

}