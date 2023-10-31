package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Computer.getInput;
import static racingcar.Message.INPUT_CAR_NAMES;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarInputTest {

    @Test
    void 예시_입력_테스트() {

        // given
        String userInput = "pobi,woni,jun";

        // when
        List<String> carNames = CarManager.createNames(userInput);

        // then
        assertThat(carNames).isEqualTo(Arrays.asList("pobi", "woni", "jun"));

    }

    @Test
    void 자동차_수가_1대_이하일_때_예외_처리() {

        // given
        String userInputOne = "";
        String userInputTwo = "pobi";

        List<String> carNamesOne = CarManager.createNames(userInputOne);
        List<String> carNamesTwo = CarManager.createNames(userInputTwo);

        // when, then
        assertThatThrownBy(() -> Validator.checkCount(carNamesOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2대 이상의 자동차 이름을 입력해 주세요.");

        assertThatThrownBy(() -> Validator.checkCount(carNamesTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2대 이상의 자동차 이름을 입력해 주세요.");
    }

    @Test
    void 자동차_이름_6자_이상일_때_예외_처리() {

        // given
        String userInput = "123456";

        List<String> carNames = CarManager.createNames(userInput);

        // when, then
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

        List<String> carNamesOne = CarManager.createNames(userInputOne);
        List<String> carNamesTwo = CarManager.createNames(userInputTwo);
        List<String> carNamesThree = CarManager.createNames(userInputThree);

        // when, then
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

        List<String> carNames = CarManager.createNames(userInput);

        // when
        CarManager.trimNames(carNames);

        // then
        assertThat(carNames).isEqualTo(Arrays.asList("jun", "pobi"));

    }

    @Test
    void 이름_중복_시_예외_처리() {

        // given
        String userInputOne = "pobi,pobi";
        String userInputTwo = "jun, jun ";

        List<String> carNamesOne = CarManager.createNames(userInputOne);
        List<String> carNamesTwo = CarManager.createNames(userInputTwo);

        // when, then
        assertThatThrownBy(() -> Validator.checkDuplication(carNamesOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해 주세요.");

        assertThatThrownBy(() -> Validator.checkDuplication(carNamesTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해 주세요.");

    }

    @Test
    void 이름_입력_출력문() {

        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Car car = new Car(CarManager.createNames(getInput(INPUT_CAR_NAMES.getMessage())));

        // then
        assertThat(out.toString())
                .contains(INPUT_CAR_NAMES.getMessage());

        Console.close();
    }
}