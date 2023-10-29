package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarsGameLogs;
import racingcar.domain.CarsPosition;
import racingcar.util.RandomNumberGeneratorForTest;

class CarsGameServiceTest {

    private CarsGameService carsGameService;
    private CarsPosition carsPosition;
    private CarsGameLogs carsGameLogs;

    @BeforeEach
    void setUp() {
        Map<String, Integer> carsMap = new LinkedHashMap<>(Map.of("A", 0, "B", 0, "C", 0));
        int carsGameCount = 3;

        this.carsPosition = new CarsPosition(carsMap, carsGameCount, new RandomNumberGeneratorForTest());
        this.carsGameLogs = new CarsGameLogs(carsMap);
        this.carsGameService = new CarsGameService();

    }

    @Test
    @DisplayName("위치 및 로그 업데이트 완료")
    void updatePositionAndLogs() throws Exception {
        //given
        int positionA = carsPosition.getPosition().get("A");
        int positionB = carsPosition.getPosition().get("B");
        int positionC = carsPosition.getPosition().get("C");
        //when
        Map<String, String> updatedLogs = carsGameService.getUpdatedLogs(carsPosition, carsGameLogs);

        //then
        assertAll(
                () -> assertEquals(positionA+1, carsPosition.getPosition().get("A")),
                () -> assertEquals(positionB+1, carsPosition.getPosition().get("B")),
                () -> assertEquals(positionC+1, carsPosition.getPosition().get("C"))
        );

        assertAll(
                () -> assertEquals("-", carsGameLogs.getLogs().get("A")),
                () -> assertEquals("-", carsGameLogs.getLogs().get("B")),
                () -> assertEquals("-", carsGameLogs.getLogs().get("C"))
        );


    }

    @Test
    @DisplayName("우승자 체크 완료")
    void checkWinner() throws Exception {
        //given
        Map<String, Integer> carsPosition = Map.of("A", 3, "B", 3, "C", 2, "D", 3);
        int count = 3;
        //when
        String winners = carsGameService.checkWinner(carsPosition, count);
        //then
        assertThat(winners).isEqualTo("A, B, D");
    }

}