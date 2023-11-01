package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RunCountTest {

    @DisplayName("시도 횟수 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "99", "100"})
    public void create(String inputRunCount) {
        //when
        RunCount runCount = new RunCount(inputRunCount);

        //then
        assertThat(runCount).isNotNull();
    }

    @DisplayName("시도 횟수 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "1.99", "0", "string"})
    public void createFaile(String inputRunCount) {
        //then
        assertThatThrownBy(() -> new RunCount(inputRunCount)).isInstanceOf(IllegalArgumentException.class);
    }
}
