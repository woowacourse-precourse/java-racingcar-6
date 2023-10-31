package racingcar.model.validators;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Exceptions.CarNameDuplicationException;
import racingcar.Exceptions.CarNameMaxLengthException;
import racingcar.Exceptions.CarNameMinLengthException;
import racingcar.Exceptions.CarNameSpecialCharacterException;

class CarNameValidatorTest {

    private final Validator<String> validator = new CarNameValidator();

    @Test
    @DisplayName("자동차 이름이 중복되어서는 안된다.")
    void validateDuplication() {
        String stringWithDuplication1 = "pobi,pobi,woni";
        String stringWithDuplication2 = "pobi,woni,pobi";
        String stringWithDuplication3 = "woni,pobi,pobi";

        Assertions.assertThatThrownBy(() -> validator.validate(stringWithDuplication1)).isInstanceOf(CarNameDuplicationException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringWithDuplication2)).isInstanceOf(CarNameDuplicationException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringWithDuplication3)).isInstanceOf(CarNameDuplicationException.class);
    }

    @Test
    @DisplayName("자동차 이름의 길이는 5 이하의 값이어야 한다.")
    void validateMaxLength() {
        String stringOverMaxLength1 = "pooobi,woni,jun";
        String stringOverMaxLength2 = "pobi,woooni,jun";
        String stringOverMaxLength3 = "pobi,woni,juuuun";

        Assertions.assertThatThrownBy(() -> validator.validate(stringOverMaxLength1)).isInstanceOf(CarNameMaxLengthException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringOverMaxLength2)).isInstanceOf(CarNameMaxLengthException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringOverMaxLength3)).isInstanceOf(CarNameMaxLengthException.class);
    }

    @Test
    @DisplayName("자동차 이름의 길이는 1 이상의 값이어야 한다.")
    void validateMinLength() {
        String stringUnderMinLength1 = ",woni,jun";
        String stringUnderMinLength2 = "pobi,,jun";
        String stringUnderMinLength3 = "pobi,woni,";

        Assertions.assertThatThrownBy(() -> validator.validate(stringUnderMinLength1)).isInstanceOf(CarNameMinLengthException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringUnderMinLength2)).isInstanceOf(CarNameMinLengthException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringUnderMinLength3)).isInstanceOf(CarNameMinLengthException.class);
    }

    @Test
    @DisplayName("자동차 이름들을 구분하기 하기 위한 특수문자는 쉼표(,)만 가능하다.")
    void validateSpecialCharacter() {
        String stringWithSpecialCharacter1 = "pobi&woni&jun";
        String stringWithSpecialCharacter2 = "pobi/woni/jun";
        String stringWithSpecialCharacter3 = "pobi|woni|jun";
        String stringWithSpecialCharacter4 = "pobi woni jun";

        Assertions.assertThatThrownBy(() -> validator.validate(stringWithSpecialCharacter1)).isInstanceOf(CarNameSpecialCharacterException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringWithSpecialCharacter2)).isInstanceOf(CarNameSpecialCharacterException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringWithSpecialCharacter3)).isInstanceOf(CarNameSpecialCharacterException.class);
        Assertions.assertThatThrownBy(() -> validator.validate(stringWithSpecialCharacter4)).isInstanceOf(CarNameSpecialCharacterException.class);
    }
}