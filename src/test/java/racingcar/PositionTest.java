package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.RandomNumber;

public class PositionTest {
    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false", "0:false"}, delimiter = ':')
    void isMovable_성공(int number, boolean expected) {
        RandomNumber r = new RandomNumber(number);
        assertThat(r.isMovable()).isEqualTo(expected);
    }
}