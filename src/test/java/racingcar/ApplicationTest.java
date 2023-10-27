package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validate.CountValidator;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값 구분 후 데이터 초기화")
    void splitStringAndDataInit() {
        RacingList racingList = new RacingList();
        racingList.createData("aaa,bbb,ccc");
        LinkedHashMap<String, Integer> compareValue = new LinkedHashMap<>();
        compareValue.put("aaa", 0);
        compareValue.put("bbb", 0);
        compareValue.put("ccc", 0);
        assertThat(racingList.getCarList()).isEqualTo(compareValue);
    }

    @Test
    @DisplayName("자동차 입력 값 길이 제한 초과")
    void inputSizeValidate() {
        RacingList racingList = new RacingList();
        assertThrows(IllegalArgumentException.class, () -> racingList.createData("aaa,bbb,cccccc"));
    }

    @Test
    @DisplayName("자동차 이름 중복 입력")
    void inputDuplicateValidate() {
        RacingList racingList = new RacingList();
        assertThrows(IllegalArgumentException.class, () -> racingList.createData("aaa,bbb,aaa"));
    }

    @Test
    @DisplayName("시도 횟수 : 양의 정수가 아닌 정수 입력")
    void notPositiveNumber() {
        CountValidator validator = new CountValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.numberValidate("-1"));
    }

    @Test
    @DisplayName("시도 횟수 : 숫자가 아닌 값 입력")
    void notNumberValidate() {
        CountValidator validator = new CountValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.numberValidate("aaaa"));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
