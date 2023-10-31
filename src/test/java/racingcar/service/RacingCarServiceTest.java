package racingcar.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarList;

public class RacingCarServiceTest {

    @Test
    @DisplayName("게임 진행 횟수를 입력받아 랜덤값이 4 이상일 경우 전진한다.")
    void racing_car_game_Test() {
        String input = "asd,fdg";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingCarService racingCarService = new RacingCarService();
        racingCarService.race(new CarList(input));
    }

}
