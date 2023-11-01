package racingcar.carRacing.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class CarRacingInputServiceTest {

    private final CarRacingInputService carRacingInputService = new CarRacingInputService();

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @Test
    void 자동차_이름_목록_입력() {
        String input = "a,b,c,d,e,f,g,h,i,j,k";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> carNames = carRacingInputService.inputCarNameList();

        assertThat(carNames).contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");
    }

    @Test
    void 레이싱_진행_횟수_입력() {
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Integer attemptCount = carRacingInputService.inputAttemptCount();

        assertThat(attemptCount).isEqualTo(10);
    }

}
