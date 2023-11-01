package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarGroupTest {

    private final int SUCCESS_MOVE_NUMBER = 4;

    @Test
    void 이름을_입력하면_자동차_그룹에_등록된다() {
        //given
        String carNames = "Ahri,Yasuo,Jinx";

        //when
        CarGroup carGroup = CarGroup.createNewCarGroupByNames(carNames);
        List<String> carNameList = carGroup.getList().stream()
                .map(Car::getName)
                .toList();

        //then
        assertThat(carGroup.size()).isEqualTo(3);
        assertThat(carNameList).containsExactly("Ahri", "Yasuo", "Jinx");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 자동차_생성시_빈값을_등록하면_예외_발생(String carNames) {
        assertThatThrownBy(() -> CarGroup.createNewCarGroupByNames((carNames)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_생성시_중복된_이름을_등록하면_예외_발생() {
        //given
        String duplicateCarNames = "Ahri,Yasuo,Ahra,Jinx,Jinx";

        //when&then
        assertThatThrownBy(() -> CarGroup.createNewCarGroupByNames(duplicateCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_한대가_가장_멀리갔을때_최종_우승자는_한명이다() {
        //given
        CarGroup carGroup = CarGroup.createNewCarGroupByNames("Ahri,Yasuo,Jinx");
        for (Car car : carGroup.getList()) {
            if ("Jinx".equals(car.getName())) {
                car.run(SUCCESS_MOVE_NUMBER);
            }
        }

        //when
        List<Car> winners = carGroup.getWinners();
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        //then
        assertThat(winners).hasSize(1);
        assertThat(winnerNames).containsExactly("Jinx");
    }

    @Test
    void 자동차_여러대가_가장_멀리갔을때_최종_우숭자는_여러명이다() {
        //given
        CarGroup carGroup = CarGroup.createNewCarGroupByNames("Ahri,Yasuo,Jinx,Yone,Ashe");
        for (Car car : carGroup.getList()) {
            if ("Ahri,Yone".contains(car.getName())) {
                car.run(SUCCESS_MOVE_NUMBER);
            }
        }

        //when
        List<Car> winners = carGroup.getWinners();
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        //then
        assertThat(winners).hasSize(2);
        assertThat(winnerNames).containsExactly("Ahri", "Yone");
    }
}