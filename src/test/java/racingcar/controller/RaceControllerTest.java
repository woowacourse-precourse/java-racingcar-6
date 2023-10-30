package racingcar.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceControllerTest {
    private RaceController raceController;
    @BeforeEach
    void setUp() {
        raceController = new RaceController();
    }

    @DisplayName("입력된 자동차 이름 갯수에 맞게 구분하였는지 테스트")
    @Test
    void divideCarNamesTest() {
        String inputNames = "test1,test2,test3";
        List<String> carNames = raceController.divideCarNames(inputNames);

        assertThat(carNames.size()).isEqualTo(3);
    }
}