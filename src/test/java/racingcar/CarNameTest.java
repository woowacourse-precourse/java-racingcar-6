package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputCarNameTest {
    @Test
    void 입력_값이_공백인_경우_예외_처리_테스트() {
        String input = "";

        //예외가 발생하는지 확인하고 예외가 발생할 경우 테스트 성공
        assertThatThrownBy(() -> {
            isNullDigits(input);
        }).isInstanceOf(IllegalArgumentException.class) //isNullDigits 메서드가 IllegalArgumentException을 던지는지 확인
                .hasMessage("입력한 값은 공백일 수 없습니다!");    //예외 메세지가 hasMessage와 동일한지 확인
    }

    private void isNullDigits(String input) {
        //입력 값이 조건에 해당할 경우 예외 처리
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력한 값은 공백일 수 없습니다!");
        }
    }
}
