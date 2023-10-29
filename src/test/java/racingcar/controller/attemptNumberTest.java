package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.view.CarRaceGameView;

public class attemptNumberTest extends NsTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1"})
    void 시도횟수테스트(String carNames) {
        CarRaceGame carRaceGame = new CarRaceGame();
        Assertions.assertThatThrownBy(
                () -> runException(carNames)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
