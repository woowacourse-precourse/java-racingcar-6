package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.enums.Common;

import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void getWinnersNames() {
        Cars cars = new Cars("isaac,pobi,woni,jun,so");
        Attempts attempts = new Attempts(1);
        assertRandomNumberInRangeTest(() -> {
                    cars.everyCarMoveForward();
                    Winners winners = new Winners(cars, attempts);
                    assertThat(winners.getWinnersNames().stream().collect(Collectors.joining(", "))).isEqualTo("isaac");
                }, Common.STANDARD_NUMBER.getIntValue(),
                Common.STANDARD_NUMBER.getIntValue() - 1,
                Common.STANDARD_NUMBER.getIntValue() - 1,
                Common.STANDARD_NUMBER.getIntValue() - 1,
                Common.STANDARD_NUMBER.getIntValue() - 1);
    }

}