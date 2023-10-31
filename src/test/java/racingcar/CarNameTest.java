package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void 입력_값이_공백인_경우_예외_테스트() {
        String input = "";

        //예외가 발생하는지 확인하고 예외가 발생할 경우 테스트 성공
        assertThatThrownBy(() -> {
            isNullDigits(input);
        }).isInstanceOf(IllegalArgumentException.class) //isNullDigits 메서드가 IllegalArgumentException을 던지는지 확인
                .hasMessage("자동차 이름의 값은 공백일 수 없습니다!");    //예외 메세지가
    }

    private void isNullDigits(String input) {
        //입력 값이 조건에 해당할 경우 예외 처리
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름의 값은 공백일 수 없습니다!");
        }
    }

    @Test
    void 콤마가_존재하지_않아도_split_메서드로_주어진_값을_구분() {
        String input = "2";
        String[] result = input.split(",");

        assertThat(result).contains("2");
    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "2,5,3";
        String[] result = input.split(",");

        assertThat(result).contains("3", "2", "5");
        assertThat(result).containsExactly("2", "5", "3");
    }

    @Test
    void 여섯_이상의_입력_값이_들어올_경우_예외_처리_테스트() {
        String input = "우테코_이삭";
        //예외가 발생하는지 확인하고 예외가 발생할 경우 테스트 성공
        assertThatThrownBy(() -> {
            isSixDigits(input.length());
        }).isInstanceOf(IllegalArgumentException.class) //isNullDigits 메서드가 IllegalArgumentException을 던지는지 확인
                .hasMessage("자동차 이름의 다섯 자 이하여야 합니다!");    //예외 메세지가 hasMessage와 동일한지 확인
    }

    private void isSixDigits(int input) {
        //입력 값이 조건에 해당할 경우 예외 처리
        if (input > 5) {
            throw new IllegalArgumentException("자동차 이름의 다섯 자 이하여야 합니다!");
        }

    }
}
