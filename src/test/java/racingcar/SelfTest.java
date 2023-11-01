package racingcar;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class SelfTest {
    @Test
    void 자동차_이름_입력_중복_예외_테스트() {
        assertThatThrownBy(() -> {
            Application.getCarNamesFromUser("Geon,Geon,Kong");
            Application.changeCarNameToList();
            Application.validateCarNames();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_5글자_이상_예외_테스트() {
        assertThatThrownBy(() -> {
            Application.getCarNamesFromUser("KimGeon,Geon,Kong");
            Application.changeCarNameToList();
            Application.validateCarNames();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_입력_0_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            Application.inputTryNum = "0";
            Application.validateTryNum();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_입력_숫자가_아닌_값_예외_테스트() {
        assertThatThrownBy(() -> {
            Application.inputTryNum = "a34";
            Application.validateTryNum();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 각_차의_전진회수가_게임진행_후_증가_또는_0으로_유지() {
        Application.getCarNamesFromUser("Geon,Kong,GuGu");
        Application.changeCarNameToList();
        int carNameIndex = Randoms.pickNumberInRange(0, 2);
        Application.inputTryNum = "2";
        Application.determineForwardMovementCount();
        int afterNum = Application.forwardCountsList.get(carNameIndex);

        assertTrue(0 <= afterNum);
    }

    @Test
    void 랜덤값이_4이상인_경우에만_전진하는_지() {
        Application.getCarNamesFromUser("Geon,Kong,GuGu");
        Application.changeCarNameToList();
        Application.inputTryNum = "5";
        Application.RandomNum = Randoms.pickNumberInRange(0, 3);
        Application.initializeForwardCountsList();
        Application.carNameListIndex = 2;
        Application.determineForwardFromRandomNum();

        assertTrue(Application.forwardCountsList.get(Application.carNameListIndex) == 0);
        }

    @Test
    void 전진회수가_많은_사람이_우승자가_맞는_지() {
        Application.getCarNamesFromUser("Geon,Kong,GuGu");
        Application.changeCarNameToList();
        Application.inputTryNum = "5";
        Application.forwardCountsList.set(0, 1);
        Application.forwardCountsList.set(1, 3);
        Application.forwardCountsList.set(2, 5);
        Application.getWinnerForwardNum();
        Application.getWinnerList();
        Application.printWinnerMessage();

        assertThat(Application.winnerMessage).contains("GuGu");
    }

    @Test
    void 우승자가_여러명일_경우_콤마를_이용해_구분되는_지() {
        Application.winnerList.add("Kong");
        Application.winnerList.add("GuGu");
        Application.printWinnerMessage();

        assertThat(Application.winnerMessage).contains("Kong, GuGu");
    }
}
