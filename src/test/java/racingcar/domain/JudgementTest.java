package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgementTest {
    private Judgement judgement;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
    }

    @ParameterizedTest(name = "number = {0}, result = {1}")
    @CsvSource({"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true",
            "9,true",})
    void ifFourOrMoreTest(int number, boolean expected) {
        assertThat(judgement.isFourOrMore(4)).isTrue();
    }

    @Test
    void 자동차_이름_5글자_초과_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            judgement.validateCarNames(Arrays.asList("aaaaaaa", "bb", "cc"));
        });
    }

    @Test
    void 횟수_숫자_아니면_오류발생_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            judgement.tryConvertToInteger("aaaa");
        });
    }

}