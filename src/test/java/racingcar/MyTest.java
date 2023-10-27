package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void 구분자_명확하게_분리하는지_확인(){
        RacingCarGame testToInputSplit = new RacingCarGame();
        String testInput = "t1, t2,t3,t4, t5,";
        testToInputSplit.splitCarNamesTest(testInput);

        assertThat(testToInputSplit.getCarNames()).contains("t1", "t2", "t3", "t4", "t5");
    }
}
