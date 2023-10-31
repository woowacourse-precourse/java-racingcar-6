package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class TrialCountTest {

    @DisplayName("시도횟수가 숫자로 이루어져있지 않다면 예외가 발생한다.")
    @Test
    void validateNumeric(){
        String input = "a";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TrialCount(input));
    }

    @DisplayName("시도횟수가 양수로 이루어져있지 않다면 예외가 발생한다.")
    @Test
    void validatePositiveNumber(){
        String input = "-1";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TrialCount(input));
    }

    @DisplayName("남은 시도횟수가 0인지 확인할 수 있다.")
    @Test
    void isNotZero(){
        TrialCount trialCount = new TrialCount("1");
        assertThat(trialCount.isNotZero()).isTrue();
    }

    @DisplayName("남은 시도횟수가 소비될 수 있다.")
    @Test
    void consumed(){
        TrialCount trialCount = new TrialCount("1");
        trialCount.consumed();
        assertThat(trialCount.isNotZero()).isFalse();
    }
}