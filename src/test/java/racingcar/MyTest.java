package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void 구분자_명확하게_분리하는지_확인_테스트(){
        RacingCarGame testToInputSplit = new RacingCarGame();
        String testInput = "t1, t2,t3,t4, t5,";
        testToInputSplit.splitCarNamesTest(testInput);

        assertThat(testToInputSplit.getCarNames()).contains("t1", "t2", "t3", "t4", "t5");
    }

    @Test
    void 자동차_이름_예외처리_테스트() {
        assertThatThrownBy(() -> {
            RacingCarGame testCheckCarName = new RacingCarGame();
            String[] inputTest = {"jung", "kim", "thisIsOverFive", "lee"};

            testCheckCarName.checkCarNameTest(inputTest);
        }).isInstanceOf(IllegalArgumentException.class);
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

    @Test
    void 우승자_결정을_위한_최대_전진_횟수_테스트() {
        RacingCarGame testMaximumMovement = new RacingCarGame();
        CarInfo[] testInput = new CarInfo[5];

        for(int i = 0; i < 4; i++) {
            testInput[i] = new CarInfo("T" + (char) i, i * 2);
        }

        testInput[4] = new CarInfo("T4", 6);

        assertThat(testMaximumMovement.testGetMaximumMovement(testInput)).isEqualTo(6);
    }
}
