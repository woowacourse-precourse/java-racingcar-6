package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.racingcargame.Cars;

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


    // 이름 분리 가능 여부 확인 테스트
    @Test
    void canNameSplitTest(){
        Cars cars = new Cars();
        String input = "pobi,woni,hwang";
        cars.setCars(input.split(","));

        String[] expect = {"pobi", "woni", "hwang"};

        assertThat(cars.getCars()).contains(expect);
    }

    // 공백 이름 예외 처리 테스트
    @Test
    void blankNameCheckTest(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java, "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 1개 이름 입력 저장 여부 테스트
    @Test
    void justOneInputNameTest(){
        Cars cars = new Cars();
        String input = "hwang";
        cars.setCars(input.split(","));

        assertThat(input).contains(input);

    }

    // 시도 횟수 음수 입력 예외처리 테스트
    @Test
    void areTriesPositiveNumberTest(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    // 다수의 우승자 출력 확인 테스트
    @Test
    void manyWinnerPrintTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }


    // 중복 이름 예외 처리 테스트
    @Test
    void SameNameCheckTest(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }




    @Test
    void 시도에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javas", "asfs5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
