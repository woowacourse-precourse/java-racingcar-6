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
    @DisplayName("우승자가 여러명일 때에 대한 테스트")
    void winners_Test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,min,je", "1");
                    assertThat(output()).contains("kim : -", "min : -", "je : -", "최종 우승자 : kim, min, je");
                },
                4, 4, 4
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
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }

    @Test
    @DisplayName("자동차의 이름이 중복으로 들어올 경우 유효성 검사 테스트")
    void duplicationCheck_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,kim,min,je", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("전체 게임 진행에 대한 테스트")
    void game_Test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,min,je", "2");
                    assertThat(output()).contains(
                            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                            "시도할 회수는 몇회인가요?",
                            "실행 결과",
                            "kim : -", "min : -", "je : -",
                            "kim : -", "min : -", "je : --",
                            "최종 우승자 : je");
                },
                4, 4, 4, 1, 2, 4
        );
    }

    @Test
    @DisplayName("자동차 이름이 비었을 때 유효성 검사")
    void emptyName_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 비었을 때 유효성 검사2")
    void emptyName_Test2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 비었을 때 유효성 검사3")
    void emptyName_Test3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",kim", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 비었을 때 유효성 검사4")
    void emptyName_Test4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,,min", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백일 때 유효성 검사")
    void spaceName_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백일 때 유효성 검사2")
    void spaceName_Test2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,kim", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백일 때 유효성 검사3")
    void spaceName_Test3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,  ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
