package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ProgressTest {
    private Progress progress;

    @BeforeEach
    void setUp() {
        progress = new Progress();
    }

    @Test
    void onAir_레이싱결과_하이픈으로_표기() {
        List<String> cars = Arrays.asList("andy", "pobi", "woni", "joy");
        List<Integer> racingResult = Arrays.asList(1, 3, 2, 5);
        progress.onAir(cars, racingResult);

        assertThat(progress.racingResultHyphen).isInstanceOf(List.class);
        assertThat(progress.racingResultHyphen).containsExactly("-", "---", "--", "-----");
    }

}