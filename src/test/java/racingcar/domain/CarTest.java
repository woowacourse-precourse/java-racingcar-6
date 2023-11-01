package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름은 영어 소문자로만 구성되고, 1~5자의 길이여야한다.")
    void carNameFormatTest() {

        String tooShortName = "";
        Assertions.assertThatThrownBy(() -> new Name(tooShortName))
                .isInstanceOf(IllegalArgumentException.class);


        String tooLongName = "tooLong";
        Assertions.assertThatThrownBy(() -> new Name(tooLongName))
                .isInstanceOf(IllegalArgumentException.class);

        Name nameContainedNumber = new Name("poby1");
        Assertions.assertThatThrownBy(() -> new Car(nameContainedNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
