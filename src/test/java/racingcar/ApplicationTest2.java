package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationTest2 extends NsTest {
    @Test
    @DisplayName("게임 횟수에 대한 잘못된 입력 테스트")
    void numberOfGame_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,min,je", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,min,je", "1");
                    assertThat(output()).contains("kim : -", "min : -", "je : -", "최종 우승자 : kim, min, je");
                },
                4,4,4
        );
    }

    @Test
    @DisplayName("수에 따른 자동차의 움직임 테스트")
    void car_move_Test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car0,car1,car2,car3,car4,car5,car6,car7,car8,car9", "1");
                    assertThat(output()).contains(
                            "car0 : ",
                            "car1 : ",
                            "car2 : ",
                            "car3 : ",
                            "car4 : -",
                            "car5 : -",
                            "car6 : -",
                            "car7 : -",
                            "car8 : -",
                            "car9 : -");
                },
                0, 1,2,3,4,5,6,7,8,9
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
