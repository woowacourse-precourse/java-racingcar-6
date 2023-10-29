package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Logs;
import racingcar.domain.Position;
import racingcar.util.RandomNumberGeneratorForTest;

class RacingGameServiceTest {

    private RacingGameService racingGameService;
    private Position position;
    private Logs logs;

    @BeforeEach
    void setUp() {
        Map<String, Integer> carsMap = new LinkedHashMap<>(Map.of("A", 0, "B", 0, "C", 0));
        int carsGameCount = 3;

        this.position = new Position(carsMap, carsGameCount, new RandomNumberGeneratorForTest());
        this.logs = new Logs(carsMap);
        this.racingGameService = new RacingGameService();

    }

    @Test
    @DisplayName("위치 및 로그 업데이트 완료")
    void updatePositionAndLogs() throws Exception {
        //given
        int positionA = position.getPosition().get("A");
        int positionB = position.getPosition().get("B");
        int positionC = position.getPosition().get("C");
        //when
        Map<String, String> updatedLogs = racingGameService.getUpdatedLogs(position, logs);

        //then
        assertAll(
                () -> assertEquals(positionA+1, position.getPosition().get("A")),
                () -> assertEquals(positionB+1, position.getPosition().get("B")),
                () -> assertEquals(positionC+1, position.getPosition().get("C"))
        );

        assertAll(
                () -> assertEquals("-", logs.getLogs().get("A")),
                () -> assertEquals("-", logs.getLogs().get("B")),
                () -> assertEquals("-", logs.getLogs().get("C"))
        );


    }

    @Test
    @DisplayName("우승자 체크 완료")
    void checkWinner() throws Exception {
        //given
        Map<String, Integer> carsPosition = Map.of("A", 3, "B", 3, "C", 2, "D", 3);
        int count = 3;
        //when
        String winners = racingGameService.checkWinner(carsPosition, count);
        //then
        assertThat(winners).isEqualTo("A, B, D");
    }

}