package racingcar.exception.validtaion;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;

class RacingCarGameValidationHandlerTest {

    @Test
    @DisplayName("시도할 횟수가 존재하면 예외가 발생하지 않는다.")
    void validationHasText() {
        // given
        String gameCount = "5";
        // when // then
        RacingCarGameValidationHandler.validationHasText(gameCount);
    }

    @Test
    @DisplayName("시도할 횟수가 공백이면 예외가 발생한다.")
    void validationHasTextExceptionIsBlank() {
        // given
        String gameCount = " ";
        // when // then
        assertThatThrownBy(() -> RacingCarGameValidationHandler.validationHasText(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.PROMPT_GAME_COUNT_INPUT);
    }

    @Test
    @DisplayName("시도할 횟수가 null이면 예외가 발생한다.")
    void validationHasTextExceptionIsNull() {
        // given
        String gameCount = null;
        // when // then
        assertThatThrownBy(() -> RacingCarGameValidationHandler.validationHasText(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.PROMPT_GAME_COUNT_INPUT);
    }

    @Test
    @DisplayName("시도할 횟수가 숫자 이면 예외가 발생하지 않는다.")
    void validationNumeric() {
        // given
        String gameCount = "5";
        // when // then
        RacingCarGameValidationHandler.validationNumeric(gameCount);
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아니면 예외가 발생한다.")
    void validationNumericException() {
        // given
        String gameCount = "다섯";
        // when // then
        assertThatThrownBy(() -> RacingCarGameValidationHandler.validationNumeric(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.GAME_COUNT_FORMAT_RESTRICTION);
    }

    @Test
    @DisplayName("시도할 횟수가 숫자 100 이하이면 예외가 발생하지 않는다.")
    void validationUnderOrEqual100() {
        // given
        String gameCount = "100";
        // when // then
        RacingCarGameValidationHandler.validationUnderOrEqual100(gameCount);
    }

    @Test
    @DisplayName("시도할 횟수가 100 보다 크면 예외가 발생한다.")
    void validationUnderOrEqual100Exception() {
        // given
        String gameCount = "101";
        // when // then
        assertThatThrownBy(() -> RacingCarGameValidationHandler.validationUnderOrEqual100(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.MAX_GAME_COUNT_RESTRICTION);
    }

    @Test
    @DisplayName("자동차가 있으면 예외가 발생하지 않는다.")
    void validationCarsEmpty() {
        // given
        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        List<Car> cars = List.of(car1, car2);

        // when // then
        RacingCarGameValidationHandler.validationCarsEmpty(cars);
    }

    @Test
    @DisplayName("자동차가 비어있으면 예외가 발생한다.")
    void validationCarsEmptyException() {
        // given
        List<Car> cars = new ArrayList<>();

        // when // then
        assertThatThrownBy(() -> RacingCarGameValidationHandler.validationCarsEmpty(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.CARS_IS_EMPTY);
    }
}