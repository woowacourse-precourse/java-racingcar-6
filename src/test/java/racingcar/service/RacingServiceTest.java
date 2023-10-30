package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.util.StatusEnum;

class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        this.racingService = new RacingService("pobi,woni,jun");
    }

    @DisplayName("4이상 전진")
    @Test
    void test() {
        // given
        StatusEnum statusEnum = racingService.getMoveOrStop(4);

        // then
        assertThat(statusEnum).isEqualTo(StatusEnum.MOVE);
    }

    @DisplayName("4미만 멈춤")
    @Test
    void test2() {
        // given
        StatusEnum statusEnum = racingService.getMoveOrStop(3);

        // then
        assertThat(statusEnum).isEqualTo(StatusEnum.STOP);

    }
}