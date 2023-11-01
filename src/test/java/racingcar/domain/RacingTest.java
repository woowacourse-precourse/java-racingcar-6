package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    void play_레이싱_1회_진행한_결과_1또는0_리스트로_반환() {
        List<String> input = Arrays.asList("andy", "pobi", "woni", "joy");
        List<Integer> result = racing.play(input);

        assertThat(result).contains(0, 1);
        assertThat(result.size()).isEqualTo(4);
    }

}