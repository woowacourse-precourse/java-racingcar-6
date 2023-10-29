package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static racingcar.constant.Constant.COMMA_REGEX_DELIMITER;

public class CarCarNameValidatorTest {

    @Test
    void 입력받은_차_이름_공백인_경우_예외() {
        String input = " ";
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백을 허용하지 않습니다.");
    }

    /**
     * 구분자가 쉼표가 아닌 경우 + 이름이 5글자 이상인 경우 한번에 처리 된다.
     * pobi.,sola.. -> ["pobi.", "sola.."] "sola.." 6글자 이므로 (예외 O)
     * pobi.,sola. -> ["pobi.", "sola."] 닉네임에 .이 붙은 것이므로 (예외 X)
     */
    @Test
    void 입력받은_차_이름_쉼표로_구분해_이름이_5글자_이상인_경우_예외() {
        String input = "pobi,woni,jun,sola.love"; // [pobi,woni,jun,sola.love]
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 최대 5글자 입니다.");
    }

    @Test
    void 입력받은_차_이름_쉼표로_시작한_경우_예외() {
        String input = ",pobi,woni,jun"; // 결과 = ["","pobi","jun"]
        List<String> splitCarNames = splitCarNames(input);
        Assertions.assertThatThrownBy(() -> splitCarNames.stream()
                .forEach(CarNameValidator::validate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백을 허용하지 않습니다.");
    }

    @Test
    void 입력받은_차_이름_쉼표로_끝나는_경우() {
        /**
         * ',' 로 끝나는 경우, 예외를 발생 시키지 않음 ','은 단순히 구분자 이므로 ,이후에 문자가 없으면 아무도 없는걸로 간주
         * 하지만 ','로 시작하는 경우는 다름.
         * Assertions.assertDoesNotThrow() - junit.jupiter 함수, 예외가 발생하지 않는 테스트용
         */
        String input = "pobi,woni,jun,"; // 결과 = ["pobi","woni","jun"]
        List<String> splitCarNames = splitCarNames(input);
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> splitCarNames.stream()
                .forEach(name -> CarNameValidator.validate(name)));
    }

    List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(COMMA_REGEX_DELIMITER));
    }

    @Test
    void 입력받은_차_이름_쉼표가_연속된_경우_예외() {
        String input = "pobi,,woni,jun";
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 연속된 콤마(',')을 허용하지 않습니다.");
    }
}
