package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {
    private static final List<String> NAMES = Arrays.asList("pobi", "woni", "jun");
    private static final List<Integer> SOLO_NUMBERS = Arrays.asList(1, 1, 3);
    private static final List<Integer> JOINT_NUMBERS = Arrays.asList(2, 2, 2);
    private Judgement judgement;

    @BeforeEach
    void setUP() {
        judgement = new Judgement();
    }

    @Test
    void 단독_우승() {
        List<String> result = judgement.selectWinner(NAMES, SOLO_NUMBERS);
        List<String> winner = Arrays.asList("jun");
        assertThat(result).isEqualTo(winner);
    }

    @Test
    void 공동_우승() {
        List<String> result = judgement.selectWinner(NAMES, JOINT_NUMBERS);
        List<String> winner = Arrays.asList("pobi", "woni", "jun");
        assertThat(result).isEqualTo(winner);
    }
}