package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.DTO.CarDTO;
import racingcar.model.Car;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    private final static int TOTAL_ROUND_COUNT = 5;
    private final static InputView INPUT_VIEW = new InputView();
    private final static OutputView OUTPUT_VIEW = new OutputView();

    @BeforeEach
    public void cleanupRound() {
        Round.resetCurrentRoundCount();
    }

    @Test
    @DisplayName("입력받은 이름 개수 만큼 자동차 객체 생성 확인")
    public void 이름_개수_만큼_자동차_생성() {
        // given
        GameController gameController = new GameController(INPUT_VIEW, OUTPUT_VIEW);
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

    @Test
    @DisplayName("전체 라운드 수만큼 라운드의 결과들을 확인")
    public void 게임_플레이_결과_확인_테스트() {
        // given
        GameController gameController = new GameController(INPUT_VIEW, OUTPUT_VIEW);
        List<String> carNames = Arrays.asList("kim", "lee");
        List<Car> cars = gameController.createCars(carNames);
        gameController.setTotalRoundCount(TOTAL_ROUND_COUNT);
        gameController.setCars(cars);

        // when
        List<List<CarDTO>> EachRoundResult = gameController.play();

        // then
        assertAll(
                () -> assertThat(EachRoundResult).size().isEqualTo(TOTAL_ROUND_COUNT),
                () -> assertThat(EachRoundResult.stream().findFirst().get())
                        .extracting("name")
                        .containsExactly("kim", "lee")
        );
    }
}