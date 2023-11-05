package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingService;

class RacingControllerTest {
    private RacingController racingController;
    private RacingService racingService;

    @BeforeEach
    public void beforeEach() {
        racingService = new RacingService();
        racingController = new RacingController(racingService);
    }

    @Test
    @DisplayName("기능9 테스트: 차량이 한대 일 때 userInputToCarArray가 carArray를 정확하게 반환한다.")
    void userInputToCarArrayReturnCarArrayWhenCarIsOne() {
        // given
        String userInput = "A";

        // when
        String[] carArray = racingController.userInputToStringCarArray(userInput);

        // then
        assertThat(carArray).isEqualTo(new String[]{"A"});
    }

    @Test
    @DisplayName("기능9 테스트: 차량이 두대 일 때 userInputToCarArray가 carArray를 정확하게 반환한다.")
    void userInputToCarArrayReturnCarArrayWhenCarIsTwo() {
        // given
        String userInput = "A,B";

        // when
        String[] carArray = racingController.userInputToStringCarArray(userInput);

        // then
        assertThat(carArray).isEqualTo(new String[]{"A", "B"});
    }

    @Test
    @DisplayName("기능10 테스트: 자동차 이름이 정상일 경우 validateCarName는 에러를 발생시키지 않는다.")
    public void validateCarNameDoesNotThrowIllegalArgumentExceptionWhenCarNameIsNormal() {
        // given
        String[] carList = new String[]{"A", "B", "CDEF"};

        // when, then
        assertThatCode(() -> racingController.validateCarNames(carList))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기능11 테스트: 자동차 이름이 6글자 이상인 경우 validateCarName 메서드는 IllegalArgument Exception을 발생킨다.")
    public void validateCarNameThrowIllegalArgumentExceptionWhenCarNameIsLongerThanSixWords() {
        // given
        String[] carList = new String[]{"A", "B", "CDEFGH"};

        // when, then
        assertThatThrownBy(() -> racingController.validateCarNames(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingController.WRONG_CAR_NAME_ERROR_MESSAGE);
    }
}