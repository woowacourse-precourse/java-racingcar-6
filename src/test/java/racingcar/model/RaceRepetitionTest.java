package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RaceRepetitionTest {

    RaceRepetition generateRaceRepetition(String inputTestString) {
        return new RaceRepetition(inputTestString);
    }

    @Test
    void input_숫자가_아니거나_양수가_아니면_예외_발생() {
        String inputPlusOne = "1";
        String inputZero = "0";
        String inputMinusOne = "-1";
        String inputString = "string";

        // 양수 1 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> generateRaceRepetition(inputPlusOne));

        // 0 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> generateRaceRepetition(inputZero));

        // -1 입력했을 때 예외 발생
        assertThatThrownBy(()-> generateRaceRepetition(inputMinusOne))
                .isInstanceOf(IllegalArgumentException.class);

        // string 입력했을 때 예외 발생
        assertThatThrownBy(()-> generateRaceRepetition(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void end_1회_반복_후_완료_확인() {
        String inputPlusOne = "1";
        RaceRepetition raceRepetition = generateRaceRepetition(inputPlusOne);
        raceRepetition.addNowRepeat();

        assertThat(raceRepetition.isRepetitionEnd()).isEqualTo(true);

    }

}
