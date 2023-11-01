package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import racingcar.model.RacingCarService;
import racingcar.model.car.RandomNumber;
import racingcar.model.car.RandomUtil;

public class InputTest {
    private final InputStream standardIn = System.in;
    private RandomUtil randomUtil = new RandomNumber();

    @Mock
    private RacingCarService service = new RacingCarService(randomUtil);

    @AfterEach
    void restoreStreams() {
        System.setIn(standardIn);
    }

    @Test
    void 사용자_입력에서_자동차_이름을_분리한다() {
        //given
        String userInput = "a,b,c";
        List<String> carNameList = List.of(userInput.split(","));

        //when
        List<String> splitedCarNameList = service.splitCarNames(userInput);

        //then
        assertThat(carNameList).isEqualTo(splitedCarNameList);
    }

    @Test
    void 자동차_이름이_중복되면_안된다() {
        String userInput = "ab,ab, c";

        assertThrows(IllegalArgumentException.class, () -> service.createCarList(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {" , ,,   ,", " ", ""})
    void 공백은_자동차_이름이_될수없다(String input) {
        assertThrows(IllegalArgumentException.class, () -> service.createCarList(input));
    }

    @Test
    void 자동차_이름은_5자_이하다() {
        String userInput = "ababab, c, d";

        assertThrows(IllegalArgumentException.class, () -> service.createCarList(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.23", "-2", "-1.23", "", " "})
    void 시도횟수는_양의_정수다(String userInputTryNumber) {
        assertThatThrownBy(() -> service.parsingTryNumber(userInputTryNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
