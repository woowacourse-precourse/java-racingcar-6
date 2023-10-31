package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("공동 우승자 출력 확인")
    void testSeveralWinner(){
        //given
        String testCarName = "a,b,c";
        String testMovingCount = "3";

        //when
        List<Integer> moving = Arrays.asList(MOVING_FORWARD, STOP, MOVING_FORWARD);

        //then
        List<String> firstMovingResult = Arrays.asList("a : -", "b : ", "c : -");
        List<String> secondMovingResult = Arrays.asList("a : --", "b : ", "c : --");
        List<String> thirdMovingResult = Arrays.asList("a : ---", "b : ", "c : ---");

        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "3");
                    assertThat(
                            output()).
                            contains(firstMovingResult.get(0), firstMovingResult.get(1), firstMovingResult.get(2),
                                    secondMovingResult.get(0), secondMovingResult.get(1), secondMovingResult.get(2),
                                    thirdMovingResult.get(0), thirdMovingResult.get(1), thirdMovingResult.get(2),
                                    "최종 우승자 : a, c"
                    );
                },
                moving.get(0),moving.get(1),moving.get(2),
                moving.get(0),moving.get(1),moving.get(2),
                moving.get(0),moving.get(1),moving.get(2)
        );
    }

    @Test
    @DisplayName("자동차 이름 길이 확인")
    void testValidateLength(){
        //given
        Validate validate = new Validate();
        String testStr = "123456";

        //when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(testStr))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 중복 확인")
    void testValidateDuplicate(){
        //given
        Validate validate = new Validate();
        String testStr = "123,123";

        //when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(testStr))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름이 공백 만으로 이루어져 있는지 확인")
    void testValidateEmptySpace(){
        //given
        Validate validate = new Validate();
        String testStr = "   ";

        //when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(testStr))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력한 시도 횟수가 정수형인지 확인")
    void testValidateDataType(){
        //given
        Validate validate = new Validate();
        String testStrFirst = "abc,def";
        String testStrSecond = "a";

        //when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(testStrFirst, testStrSecond))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
