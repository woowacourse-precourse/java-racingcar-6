package racingcar.controller;

import static org.assertj.core.api.Assertions.*;
import static racingcar.controller.RacingController.*;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

class RacingControllerTest {
    private RacingController racingController;
    private RacingService racingService;

    @BeforeEach
    public void beforeEach() {
        racingService = new RacingService();
        racingController = new RacingController(racingService);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("기능9 테스트: 차량이 한대 일 때 userInputToCarArray가 carArray를 정확하게 반환한다.")
    void userInputToCarArrayReturnCarArrayWhenCarIsOne() {
        // given
        String userInput = "A";

        // when
        String[] stringCarArray = racingController.userInputToStringCarArray(userInput);

        // then
        assertThat(stringCarArray).contains("A");
    }

    @Test
    @DisplayName("기능9 테스트: 차량이 두대 일 때 userInputToCarArray가 carArray를 정확하게 반환한다.")
    void userInputToCarArrayReturnCarArrayWhenCarIsTwo() {
        // given
        String userInput = "A,B";

        // when
        String[] stringCarArray = racingController.userInputToStringCarArray(userInput);

        // then
        assertThat(stringCarArray)
                .hasSize(2)
                .containsExactly("A", "B");
    }

    @Test
    @DisplayName("기능10 테스트: 자동차 이름이 정상일 경우 validateCarName는 에러를 발생시키지 않는다.")
    public void validateCarNameDoesNotThrowIllegalArgumentExceptionWhenCarNameIsNormal() {
        // given
        String[] stringCarArray = new String[]{"A", "B", "CDEF"};

        // when, then
        assertThatCode(() -> racingController.validateCarNames(stringCarArray))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기능11 테스트: 자동차 이름이 6글자 이상인 경우 validateCarName 메서드는 IllegalArgument Exception을 발생킨다.")
    public void validateCarNameThrowIllegalArgumentExceptionWhenCarNameIsLongerThanSixWords() {
        // given
        String[] stringCarArray = new String[]{"A", "B", "CDEFGH"};

        // when, then
        assertThatThrownBy(() -> racingController.validateCarNames(stringCarArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("기능12 테스트: stringCarArrayToCarList 메서드가 문자열로 된 자동차 배열을 Car 객체로 이루어진 리스트로 변환한다.")
    void stringCarArrayToCarList() {
        // given
        String[] stringCarArray = new String[]{"A", "B", "C"};

        // when
        List<Car> carList = racingController.stringCarArrayToCarList(stringCarArray);

        // then
        assertThat(carList).hasSize(3);

        assertThat(carList.get(0).getName()).isEqualTo("A");
        assertThat(carList.get(1).getName()).isEqualTo("B");
        assertThat(carList.get(2).getName()).isEqualTo("C");
    }


    @Test
    @DisplayName("기능8. 테스트 : registerPlayer 메서드는 유저의 입력값을 검증 후 carList로 변환하여 반환한다.")
    void registerPlayerShouldReturnCarListAfterValidationPass() {
        // given
        System.setIn(createUserInput("A,B,C"));

        // when
        List<Car> result = racingController.registerPlayer();

        // then
        assertThat(result).hasSize(3);

        assertThat(result.get(0).getName()).isEqualTo("A");
        assertThat(result.get(1).getName()).isEqualTo("B");
        assertThat(result.get(2).getName()).isEqualTo("C");
    }

    @Test
    @DisplayName("기능8. 테스트 : registerPlayer 메서드는 유저의 입력값을 검증 후 이상이 있으면 IllegalArgument Exception을 발생시킨다.")
    void registerPlayerShouldThrowIllegalArgumentExceptionWhenValidationFail() {
        // given
        System.setIn(createUserInput("A,B,CDEFGH"));

        // when, then
        assertThatThrownBy(() -> racingController.registerPlayer())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}