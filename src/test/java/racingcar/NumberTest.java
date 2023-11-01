package racingcar;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NumberTest extends NsTest {
    @Test
    public void generateRandomNumberShouldReturnNumberInRange() {
        Number number = new Number();

        int randomNumber = number.generateRandomNumber();

        assertThat(randomNumber).isBetween(0,9);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
