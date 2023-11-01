package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import java.io.InputStream;

public class carRaceInputServiceTest {

    @AfterEach
    void 콘솔_관리

    {
        Console.close();
    }

    @Test
    void 차_이름_입력받은대로_반환() {
        String carName = "car";
        InputStream readLine = new ByteArrayInputStream(carName.getBytes());
        System.setIn(readLine);

        String[] carResult = View.carRaceInputService.getInstance().askUserCarNames();
        assertThat(carResult).contains("car");
        assertThat(carResult).containsExactly("car");

    }

    @Test
    void 차_이름_리스트_형태로_반환() {
        String carName = "a,b,c,d,e";
        InputStream readLine = new ByteArrayInputStream(carName.getBytes());
        System.setIn(readLine);

        String[] carResult = View.carRaceInputService.getInstance().askUserCarNames();
        assertThat(carResult).contains("a", "b", "c", "d", "e");
        assertThat(carResult).containsExactly("a", "b", "c", "d", "e");
    }

    @Test
    void 게임_횟수_입력_후_검증_후_반환() {
        String gameRound = "5";
        InputStream readLine = new ByteArrayInputStream(gameRound.getBytes());
        System.setIn(readLine);

        int roundResult = View.carRaceInputService.getInstance().askUserGameRound();
        assertThat(roundResult).isEqualTo(5);
    }
}
