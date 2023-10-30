package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import jdk.jshell.execution.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest extends NsTest {

    @Test
    void 최대값_가져오기() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(5);

        int result = Utils.getMax(test);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 문자열_배열_저장() {
        String str = "pobi,woni,jun";
        ArrayList<String> names = Utils.toArrayList(str);

        assertThat(names).contains("woni", "pobi");
        assertThat(names).containsExactly("pobi", "woni", "jun");

    }

    @RepeatedTest(100)
    void 랜덤_숫자_생성(RepetitionInfo repetitionInfo) {
        // RepetitionInfo : 현재 반복 정보를 제공
        int num = Utils.getRandomNumber();
        System.out.println("RANDOM NUMBER in repetition " + repetitionInfo.getCurrentRepetition() + ": " + num);
        // 예상 범위(ex. 0 ~ 9사이)에 해당하는 지 확인
        assertThat(num).isBetween(0, 9);
    }


    @Override
    protected void runMain() {

    }
}
