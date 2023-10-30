package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void 예시_입력_테스트() {

        // given
        String userInput = "pobi,woni,jun";

        // when
        List<String> carNames = Computer.createCarNames(userInput);

        // then
        assertThat(carNames).isEqualTo(Arrays.asList("pobi", "woni", "jun"));

    }

    @Test
    void 자동차_수가_1대_이하일_때_예외_처리() {

        // given
        String userInputOne = "";
        String userInputTwo = "pobi";

        // when
        List<String> carNamesOne = Computer.createCarNames(userInputOne);
        List<String> carNamesTwo = Computer.createCarNames(userInputTwo);

        // then
        assertThatThrownBy(() -> Validator.checkCarCount(carNamesOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2대 이상의 자동차 이름을 입력해 주세요.");

        assertThatThrownBy(() -> Validator.checkCarCount(carNamesTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2대 이상의 자동차 이름을 입력해 주세요.");
    }

    @Test
    void 자동차_이름_6자_이상일_때_예외_처리() {

        // given
        String userInput = "123456";

        // when
        List<String> carNames = Computer.createCarNames(userInput);

        // then
        assertThatThrownBy(() -> Validator.checkLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 5자 이하로 입력해 주세요.");

    }

    @Test
    void 이름이_공백일_때_예외_처리() {

        // given
        String userInputOne = "  ";
        String userInputTwo = "";
        String userInputThree = "pobi, ";

        // when
        List<String> carNamesOne = Computer.createCarNames(userInputOne);
        List<String> carNamesTwo = Computer.createCarNames(userInputTwo);
        List<String> carNamesThree = Computer.createCarNames(userInputThree);

        // then
        assertThatThrownBy(() -> Validator.checkBlank(carNamesOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 공백으로 입력하지 마세요.");

        assertThatThrownBy(() -> Validator.checkBlank(carNamesTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 공백으로 입력하지 마세요.");

        assertThatThrownBy(() -> Validator.checkBlank(carNamesThree))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 공백으로 입력하지 마세요.");

    }

    @Test
    void 이름_양_끝의_공백_제거() {

        // given
        String userInput = " jun , pobi";

        // when
        List<String> carNames = Computer.createCarNames(userInput);
        Computer.trimCarNames(carNames);

        // then
        assertThat(carNames).isEqualTo(Arrays.asList("jun", "pobi"));

    }

}