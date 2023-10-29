package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void init() {
        gameService = new GameService();
    }

    @Test
    @DisplayName("시도할 회수 생성 성공")
    void givenInput_whenCreateTrialCount_thenSuccess() {
        // given
        String input = "2147483647";

        // when
        int result = gameService.createTrialCount(input);

        // then
        assertThat(result).isEqualTo(2147483647);
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"0", "-1", "2147483648"})
    @DisplayName("시도할 회수 생성 실패")
    void givenInput_whenCreateTrialCount_thenThrowException(String input) {
        assertThatThrownBy(() -> gameService.createTrialCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
