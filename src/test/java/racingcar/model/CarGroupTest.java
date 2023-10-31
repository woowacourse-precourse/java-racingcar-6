package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarDto;
import racingcar.dto.CarGroupDto;
import racingcar.utils.Movement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGroupTest {

    private CarGroup carGroup;

    @BeforeEach
    void setInit() {
        carGroup = new CarGroup(List.of("자동차1", "자동차2", "자동차3"));
    }

    @Test
    void CarGroup_생성자는_이름의_개수만큼_Car_를_생성한다() {
        assertThat(carGroup.getCars().size()).isEqualTo(3);
    }

    @Test
    void toDto_메서드는_CarGroupDto_객체를_생성한다() {
        CarGroupDto carGroupDto = carGroup.toDto();
        assertThat(carGroupDto.getCars().size()).isEqualTo(3);
    }

    @Test
    void race_메서드는_자동차들의_움직임을_호출한다() {
        // 자동차 움직임 여부 true, false, false
        carGroup.race(new TestMovement(List.of(true, false, false)));
        List<CarDto> cars = carGroup.toDto().getCars();

        Assertions.assertThat(cars.get(0).getPosition()).isEqualTo(1);
        Assertions.assertThat(cars.get(1).getPosition()).isEqualTo(0);
        Assertions.assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("provideFindWinnersInformation")
    void findWinnerNames_는_우승_자동차_이름을_반환한다(List<Boolean> moves, List<String> results) {
        carGroup.race(new TestMovement(moves));
        List<String> winners = carGroup.findWinnerNames();
        assertThat(winners).isEqualTo(results);
    }

    static List<Arguments> provideFindWinnersInformation() {
        // 자동차 움직임에 따른 결과 예상
        return Arrays.asList(
                Arguments.of(List.of(true, true, true), List.of("자동차1", "자동차2", "자동차3")),
                Arguments.of(List.of(false, false, true), List.of("자동차3")),
                Arguments.of(List.of(false, true, true), List.of("자동차2", "자동차3"))
        );
    }

    class TestMovement implements Movement {
        List<Boolean> values;

        TestMovement(List<Boolean> values) {
            this.values = new ArrayList<>(values);
        }

        @Override
        public boolean canMove() {
            return values.remove(0);
        }
    }

}
