package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    private final static InputView INPUT_VIEW = new InputView();

    @BeforeEach
    static void setUp() {
        GameController gameController = new GameController(INPUT_VIEW);
    }

    @Test
    @DisplayName("입력받은 이름 개수 만큼 자동차 객체 생성 확인")
    public void 이름_개수_만큼_자동차_생성() {
        // given
        GameController gameController = new GameController(INPUT_VIEW);
        List<String> carNames = Arrays.asList("kim", "lee", "cho");

        // when
        List<Car> cars = gameController.createCars(carNames);

        // then
        assertAll(
                () -> assertThat(cars).size().isEqualTo(3),
                () -> assertThat(cars)
                        .extracting("name", "position")
                        .contains(
                                tuple("kim", 0),
                                tuple("lee", 0),
                                tuple("cho", 0)
                        )
                );
    }
}