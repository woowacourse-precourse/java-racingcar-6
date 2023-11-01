package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCode {
    ExceptionChecker exceptionChecker;
    RacingCar racingCar;

    @BeforeEach
    @DisplayName("예외처리 및 racingCar 클래스 객체 생성")
    void setUp() {
        exceptionChecker = new ExceptionChecker();
        racingCar = new RacingCar();
    }

    @Test
    @DisplayName("자동차 이름 한개 입력시 리스트 반환")
    void 자동차_이름_한개_입력시_리스트() {
        assertThat(InputView.stringToList("pobi")).containsExactly("pobi");
    }

    @Test
    @DisplayName("자동차 이름 여러개 입력시 리스트 반환")
    void 자동차_이름_여러개_입력시_리스트() {
        assertThat(InputView.stringToList("pobi,woni,jun")).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름 한개 입력시 예외처리(다섯 글자 초과)")
    void 자동차_이름에_대한_예외_처리_다섯글자초과1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionChecker.nameLongerThanFiveWithoutComma("pooobiii"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력한 이름이 5자를 넘겼으므로 프로그램을 종료합니다."));
    }

    @Test
    @DisplayName("자동차 이름 여러개 입력시 예외처리(다섯 글자 초과)")
    void 자동차_이름에_대한_예외_처리_다섯글자초과2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionChecker.nameLongerThanFiveWithComma("pobi,wonniii"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력한 이름이 5자를 넘겼으므로 프로그램을 종료합니다."));
    }

    @Test
    @DisplayName("자동차 이름 여러개 입력시 예외처리(이름 중복)")
    void 자동차_이름에_대한_예외_처리_이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionChecker.isNameDuplicated("pobi,pobi,woni"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력한 이름이 중복되었으므로 프로그램을 종료합니다."));
    }

    @Test
    @DisplayName("회수 입력시 예외처리(정수가 아닐 때)")
    void 회수에_대한_예외처리_정수가_아닐_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionChecker.isNotInteger("pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력한 회수가 정수가 아니므로 프로그램을 종료합니다.")
        );
    }

    @Test
    @DisplayName("회수 입력시 예외처리(음수일 때)")
    void 회수에_대한_예외처리_음수일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionChecker.lessThanZero("-10"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력한 회수가 음수이므로 프로그램을 종료합니다.")
        );
    }

    @Test
    @DisplayName("최종 우승자 출력")
    void 최종_우승자_출력() {
        List<String> carNameList = Arrays.asList("pobi,woni,jun".split(",")); // "pobi" "woni" "jun" 세 가지 자동차 이름
        List<Integer> endMovement = Arrays.asList("1", "3", "3") // 모든 회수 종료 후 pobi : 1칸, woni : 3칸, jun : 3칸 --> woni와 jun이 우승
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        racingCar.movementSoFar = endMovement;
        assertThat("최종 우승자 : woni, jun").isEqualTo(racingCar.printFinalWinner(endMovement, carNameList));
    }
}