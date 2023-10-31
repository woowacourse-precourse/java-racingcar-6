package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarControllerTest {
    RacingCarController racingCarController = new RacingCarController();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("자동차 이름을 ','로 구분하여 입력하면 그 수만큼 List를 생성. 입력한 자동차 이름과 , 최초 움직임 횟수를 객체 List에 담아 반환하는지 테스트")
    @Test
    void testInputRacingCarName() {
        String input = "pobi,woni";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<RacingCar> result = racingCarController.inputRacingCarName();

        String firstMoveCount = "0";

        assertThat(result.get(0).getName()).contains("pobi");
        assertThat(Integer.toString(result.get(0).getMoveCount())).contains(firstMoveCount);
        assertThat(result.get(1).getName()).contains("woni");
        assertThat(Integer.toString(result.get(1).getMoveCount())).contains(firstMoveCount);
    }

    @DisplayName("시도할 횟수 입력 기능 테스트")
    @Test
    void testInputTotalTurn() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = racingCarController.inputTotalTurn();
        String resultToString = Integer.toString(result);

        assertThat(resultToString).contains("1");
    }
}
