package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.Input;

public class InputTest {
    Input input = new Input();

    @AfterEach
    private void consoleClose() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi,woni,jun")
    @DisplayName("경주 게임에 참여할 자동차 이름 입력 테스트")
    void getCarNameList_test(String carNames) {
        command(carNames);
        List<String> carNameListForTest = input.getCarNameList();

        assertEquals(3, carNameListForTest.size());
        assertThat(carNameListForTest).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(ints = 4)
    @DisplayName("시도할 횟수 입력 테스트")
    void getTryCount_test(int inputTryCount) {
        command(String.valueOf(inputTryCount));
        int tryCountForTest = input.getTryCount();

        assertThat(tryCountForTest).isEqualTo(4);
    }

    @Test
    @DisplayName("시도할 횟수 입력 시 0 입력 예외 발생 테스트")
    void validateTryCountIfZero_test() {
        assertThatThrownBy(() -> getTryCount_test(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 잘못되었습니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 시 길이가 5 초과이면 IllegalArgumentException 예외 발생 테스트")
    void validateCarNameLength_test() {
        assertThatThrownBy(() -> getCarNameList_test("pobi,javaji,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 잘못되었습니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 시 공백이 존재하면 IllegalArgumentException 예외 발생 테스트")
    void validateCarNameForSpace_test() {
        assertThatThrownBy(() -> getCarNameList_test("pobi, jun,woni "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 존재해선 안됩니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 시 중복된 이름을 입력하면 IllegalArgumentException 예외 발생 테스트")
    void validateDuplicateCarName_test(){
        assertThatThrownBy(() -> getCarNameList_test("pobi,pobi,woni "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 사용하였습니다.");
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
