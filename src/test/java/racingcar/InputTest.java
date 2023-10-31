package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.Input;

public class InputTest {
    Input input = new Input();

    @ParameterizedTest
    @ValueSource(strings = "pobi,woni,jun")
    @DisplayName("경주 게임에 참여할 자동차 이름 입력 테스트")
    void getCarNameList_test(String carNames) {
        List<String> carNameListForTest;

        try {
            command(carNames);
            carNameListForTest = input.getCarNameList();
        } finally {
            Console.close();
        }

        assertEquals(3, carNameListForTest.size());
        assertThat(carNameListForTest).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 0})
    @DisplayName("시도할 횟수 입력 테스트 및 '0' 입력 시 예외 발생 테스트")
    void getTryCount_test(int inputTryCount) {
        try {
            command(String.valueOf(inputTryCount));
            int tryCountForTest = input.getTryCount();

            assertThat(tryCountForTest).isEqualTo(4);
        } catch (IllegalArgumentException illegalArgumentException){
            assertThat(illegalArgumentException).hasMessageContaining("입력이 잘못되었습니다.");
        }
        finally {
            Console.close();
        }
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

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
