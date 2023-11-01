package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Cars;
import racingcar.dto.RoundResultDto;

class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void init() {
        gameService = new GameService();
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"1", "2147483647"})
    @DisplayName("시도할 회수 생성 성공")
    void givenInput_whenCreateTrialCount_thenSuccess(String input) {
        int result = gameService.createTrialCount(input);

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"0", "-1", "2147483648"})
    @DisplayName("시도할 회수 생성 실패")
    void givenInput_whenCreateTrialCount_thenThrowException(String input) {
        assertThatThrownBy(() -> gameService.createTrialCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라운드를 실행하고 정상적인 결과를 알려주는지 확인")
    void givenCars_whenPlayRound_thenReturnCorrectResult() {
        Cars cars = new Cars("pobi,woni");

        gameService.moveCars(cars);
        RoundResultDto result = gameService.getRoundResult(cars);

        assertThat(result.roundResults().size()).isEqualTo(2);
        assertThat(result.roundResults().get(0)).extracting("name").isEqualTo("pobi");
        assertThat(result.roundResults().get(1)).extracting("name").isEqualTo("woni");
    }

}
