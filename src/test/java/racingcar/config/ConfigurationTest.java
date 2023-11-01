package racingcar.config;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;

final class ConfigurationTest {

    @DisplayName("의존 관계 주입된 GameController를 생성할 수 있다")
    @Test
    void getDefaultGameController_shouldReturnGameController() {
        // given
        // when
        final GameController gameController = Configuration.getDefaultGameController();

        // then
        assertThat(gameController).isNotNull();
    }
}