package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ApplicationTest {

    @Test
    void 플레이어_입력값_유효_확인() {
        String[] validInput = {"car1", "car2", "car3"};
        assertThat(Application.isValidInput(validInput)).isTrue();
        //6글자 이상 false
        String[] invalidInput = {"car1", "car2", "car3456789"};
        assertThat(Application.isValidInput(invalidInput)).isFalse();
        //빈값일 때 false
        String[] invalidInput2 = {"", "car2"};
        assertThat(Application.isValidInput(invalidInput2)).isFalse();
    }

    @Test
    void 차의_전진_멈춤_여부_확인() {
        // 결과가 0 또는 1이어야 함
        assertThat(Application.moveCar()).isIn(0, 1);
    }

    @Test
    void 차의_최대_이동거리_확인() {
        String[] players = {"car1", "car2", "car3"};
        int[] distances = {2, 3, 2}; // 임의의 거리 설정

        List<String> winners = Application.determineWinners(players, distances);
        assertThat(winners).containsExactly("car2"); // car2가 제일 멀리간 경우
    }

    @Test
    void 공동_우승자_확인() {
        String[] players = {"car1", "car2", "car3"};
        int[] distances = {2, 3, 3}; // 임의의 거리 설정 (car2와 car3가 공동 우승)

        List<String> winners = Application.determineWinners(players, distances);
        assertThat(winners).containsExactly("car2", "car3"); // car2와 car3가 공동 우승해야 함
    }


}