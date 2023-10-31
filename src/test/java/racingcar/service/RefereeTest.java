package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.enums.CarType;
import racingcar.enums.Common;
import racingcar.enums.GameSettingType;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {
    Map<GameSettingType, String> gameInfo = new EnumMap<>(GameSettingType.class);
    Referee referee;

    @BeforeEach
    void init() {
        gameInfo.put(GameSettingType.CAR_NAMES, "isaac,pobi");
        gameInfo.put(GameSettingType.ATTEMPTS, "2");
        referee = new Referee(gameInfo);
        assertRandomNumberInRangeTest(() -> {
            referee.getCars().everyCarMoveForward();
            referee.getCars().everyCarMoveForward();
        }, Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue() - 1, Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue() - 1);
    }

    @Test
    void anyCarReaches() {
        assertThat(referee.anyCarReaches()).isTrue();
    }

    @Test
    void getCars() {
        assertThat(referee.getCars().getCarList()
                .stream()
                .map(car -> car.getName() + " : " + car.getDistance())
                .collect(Collectors.joining("\n")))
                .isEqualTo("isaac : --\npobi : ");
    }

    @Test
    void getPlayResults() {
        assertThat(referee.getPlayResults().getResults()
                .stream()
                .map(result -> result.get(CarType.CAR_NAME) + " : " + result.get(CarType.DISTANCE))
                .collect(Collectors.joining("\n")))
                .isEqualTo("isaac : --\npobi : ");
    }

    @Test
    void getWinnerNames() {
        assertThat(referee.getWinnersNames().getWinnersNames()
                .stream()
                .collect(Collectors.joining(", ")))
                .isEqualTo("isaac");
    }

    @Test
    void getWinnersNames() {
        assertRandomNumberInRangeTest(
                () -> {
                    referee.getCars().getCar("pobi").moveForward();
                    referee.getCars().getCar("pobi").moveForward();
                }, Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue()
        );

        assertThat(referee.getWinnersNames().getWinnersNames()
                .stream()
                .collect(Collectors.joining(", ")))
                .isEqualTo("isaac, pobi");
    }
}