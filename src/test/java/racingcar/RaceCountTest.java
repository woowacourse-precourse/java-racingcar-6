package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RaceCountValidationService;

import static org.junit.jupiter.api.Assertions.*;

public class RaceCountTest {

    @DisplayName("게임 횟수 유효성 체크 확인")
    @Test
    void raceCountValidationTest() {
        RaceCountValidationService raceCountValidationService = new RaceCountValidationService();

        String[] finalRaceCount = {"-34234", "12312312312311", "2147483648", "한글", "English"};

        for (String count : finalRaceCount) {
            assertThrows(IllegalArgumentException.class, () -> {
                raceCountValidationService.raceCountValidation(count);
            });
        }
    }
}
