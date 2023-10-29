package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.view.CarRaceGameView;

class CarNameTest extends NsTest {

    static CarRaceGame carRaceGame;

    @BeforeAll
    static void beforeEach() {
        carRaceGame = new CarRaceGame();
    }


    @ParameterizedTest
    @ValueSource(strings = {"abcdef,abc",",,",  "ab,cd,,ef", "abc,de,f,", "a, ,b"})
    void 자동차이름테스트1(String carNames) {
        Assertions.assertThatThrownBy(
                () -> runException(carNames)
        ).isInstanceOf(IllegalArgumentException.class);
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}