package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.view.CarRaceGameView;

class CarRaceGameTest {
    @ParameterizedTest
    @ValueSource(strings = {",,",  "abcdef,abc", "ab,cd,,ef", "abc,de,f,"})
    void 자동차이름테스트(String carNames) {
        CarRaceGame carRaceGame = new CarRaceGame();
        Assertions.assertThatThrownBy(
                () -> carRaceGame.carNameSetting(carNames)
        ).isInstanceOf(IllegalArgumentException.class);
    }


}