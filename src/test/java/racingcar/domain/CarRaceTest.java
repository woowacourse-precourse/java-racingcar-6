package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    @Test
    @DisplayName("\"-\" 또는 \"\" 중 하나가 반환되는지 확인하는 테스트")
    void computeTrack() {
        CarRace carRace = new CarRace();
        String track = carRace.computeTrack();

        assertThat(track).isIn("-", "");
    }

    @Test
    @DisplayName("\"-\" 또는 \"\"가 잘 추가되었는지 확인하는 테스트")
    void printTrack() {
        CarRace carRace = new CarRace();
        List<String> carNames = Arrays.asList("coco", "dodo", "mimi");
        List<String> tracks = new ArrayList<>(Arrays.asList("", "", ""));

        carRace.printTrack(carNames, tracks);

        for (String track : tracks) {
            assertThat(track).isIn("-", "");
        }
    }
}