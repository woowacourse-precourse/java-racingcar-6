package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimulateTest {
    @Test
    void GO_GO_GO_goSimulate_상황에_따라_트랙에_기록() {
        int[] inputRandNum = {6, 6, 6};
        List<Integer> inputTrack = Arrays.asList(0, 0, 0);

        CarSimulate carSimulate = new CarSimulate();
        for (int i = 0; i < inputTrack.size(); i++) {
            carSimulate.goSimulate(inputRandNum[i], i, inputTrack);
        }

        assertThat(inputTrack).containsExactly(1, 1, 1);

    }

    @Test
    void GO_GO_Stop_goSimulate_상황에_따라_트랙에_기록() {
        int[] inputRandNum = {6, 6, 2};
        List<Integer> inputTrack = Arrays.asList(0, 0, 0);

        CarSimulate carSimulate = new CarSimulate();
        for (int i = 0; i < inputTrack.size(); i++) {
            carSimulate.goSimulate(inputRandNum[i], i, inputTrack);
        }

        assertThat(inputTrack).containsExactly(1, 1, 0);
    }

    @Test
    void GO_Stop_Stop_goSimulate_상황에_따라_트랙에_기록() {
        int[] inputRandNum = {6, 2, 1};
        List<Integer> inputTrack = Arrays.asList(0, 0, 0);

        CarSimulate carSimulate = new CarSimulate();
        for (int i = 0; i < inputTrack.size(); i++) {
            carSimulate.goSimulate(inputRandNum[i], i, inputTrack);
        }

        assertThat(inputTrack).containsExactly(1, 0, 0);
    }

    @Test
    void STOP_STOP_STOP_goSimulate_상황에_따라_트랙에_기록() {
        int[] inputRandNum = {0, 0, 0};
        List<Integer> inputTrack = Arrays.asList(0, 0, 0);

        CarSimulate carSimulate = new CarSimulate();
        for (int i = 0; i < inputTrack.size(); i++) {
            carSimulate.goSimulate(inputRandNum[i], i, inputTrack);
        }

        assertThat(inputTrack).containsExactly(0, 0, 0);
    }
}
