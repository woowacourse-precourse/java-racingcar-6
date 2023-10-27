package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
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

    @Test
    void 시도_횟수_입력_파트_테스트() {
        RacingCarGame testToInputMovementAmount = new RacingCarGame();
        String testInput = "five";

        assertThatThrownBy(() -> {
            testToInputMovementAmount.checkMovementAmountTest(testInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 무작위값_발생_파트_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    RacingCarGame testRandomNumber = new RacingCarGame();
                    boolean[] testOutput = new boolean[5];

                    for(int i = 0; i < 5; i++) {
                        testOutput[i] = testRandomNumber.testDecideMoveOrNot();
                    }

                    assertThat(testOutput).containsExactly(true, false, false, true, false);
                },
                4, 1, 1, 9, 0
        );
    }
}
