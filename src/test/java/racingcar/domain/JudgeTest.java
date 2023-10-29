package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @Test
    @DisplayName("가장 멀리간 자동차의 트랙 길이 출력하는지 확인하는 테스트")
    void findMaxTrack() {
        Judge judge = new Judge();
        List<String> tracks = Arrays.asList("--", "----", "-", "--------");

        int maxTrack = judge.findMaxTrack(tracks);

        assertThat(maxTrack).isEqualTo(8);
    }

    @Test
    @DisplayName("우승자의 이름을 리턴하는지 확인하는 테스트")
    void findWinner() {
        Judge judge = new Judge();
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        List<String> tracks = Arrays.asList("----", "------", "--");
        int maxTrack = 6;

        List<String> winners = judge.findWinner(carNames, tracks, maxTrack);

        assertThat(winners).containsExactly("Car2");
    }

    @Test
    @DisplayName("공동 우승자들의 이름을 리턴하는지 확인하는 테스트")
    void findCoWinner() {
        Judge judge = new Judge();
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        List<String> tracks = Arrays.asList("----", "----", "--");
        int maxTrack = 4;

        List<String> winners = judge.findWinner(carNames, tracks, maxTrack);

        assertThat(winners).containsExactlyInAnyOrder("Car1", "Car2");
    }
}