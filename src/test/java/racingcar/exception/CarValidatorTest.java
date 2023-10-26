package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CarValidatorTest {

    @Test
    void 입력받은_차_이름_공백인_경우_예외() {
        String input = " ";
        Assertions.assertThatThrownBy(() -> {
            if (input.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 구분자가 쉼표가 아닌 경우 + 이름이 5글자 이상인 경우 한번에 처리 된다.
     */
    @Test
    void 입력받은_차_이름_쉼표로_구분해_이름이_5글자_이상인_경우_예외() {
        String input = "pobi,woni,jun,sola.love"; // [pobi,woni,jun,sola.love]
        String[] splitList = input.split(",");

        Assertions.assertThatThrownBy(() -> {
            Arrays.stream(splitList)
                    .filter(s -> s.length() > 5)
                    .forEach(s -> {
                        throw new IllegalArgumentException("길이가 5 이상인 문자열 발견: " + s);
                    });
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_차_이름_쉼표로_시작한_경우_예외() {
        String input = ",pobi,woni,jun";
        Assertions.assertThatThrownBy(() -> {
            if (input.charAt(0) == ',') {
                throw new IllegalArgumentException("문자열이 쉼표로 시작합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_차_이름_쉼표로_끝나는_경우_예외() {
        String input = "pobi,woni,jun,";
        Assertions.assertThatThrownBy(() -> {
            if (input.charAt(input.length() - 1) == ',') {
                throw new IllegalArgumentException("문자열이 쉼표로 시작합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_차_이름_쉼표가_연속된_경우_예외() {
        String input = "pobi,,woni,jun";
        Assertions.assertThatThrownBy(() -> {
            for (int i = 0; i < input.length() - 1; i++) {
                if (input.charAt(i) == ',' && input.charAt(i + 1) == ',') {
                    throw new IllegalArgumentException();
                }
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
