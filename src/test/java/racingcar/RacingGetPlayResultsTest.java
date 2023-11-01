package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGetPlayResultsTest {

    private static Racing racing;

    @BeforeEach
    void init() {
        racing = new Racing();
    }

    @Test
    @DisplayName("getPlayResults 검증 테스트")
    void getPlayResults_validate() {

        String[] carNames = {"디", "레옹", "마틸다", "로즈", "고든"};
        int playCount = 5;

        racing.initParticipants(carNames);
        racing.initPlayCount(playCount);

        String result = String.join(
                "\n",
                racing.getPlayResults()
        );

        assertThat(result).contains("디 : ", "레옹 : ", "마틸다 : ", "로즈 : ", "고든 : ", "-");
    }
}
