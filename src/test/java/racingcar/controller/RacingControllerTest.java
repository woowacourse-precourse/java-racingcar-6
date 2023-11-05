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
import racingcar.utils.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class RacingControllerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private RacingController racingController;

    @BeforeEach
    public void beforeEach() {
        RacingService racingService = new RacingService();
        racingController = new RacingController(racingService);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void closeConsole() {
        Console.close();
        System.setOut(standardOut);
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
    @DisplayName("기능8. 테스트: registerPlayer 메서드는 유저의 입력값을 검증 후 carList로 변환하여 반환한다.")
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
    @DisplayName("기능8. 테스트: registerPlayer 메서드는 유저의 입력값을 검증 후 이상이 있으면 IllegalArgument Exception을 발생시킨다.")
    void registerPlayerShouldThrowIllegalArgumentExceptionWhenValidationFail() {
        // given
        System.setIn(createUserInput("A,B,CDEFGH"));

        // when, then
        assertThatThrownBy(() -> racingController.registerPlayer())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("기능14 테스트: userInputToInt 메서드가 유저의 입력값을 숫자로 변환한다.")
    void userInputToIntShouldTransformUserInputToIntegerNumber() {
        // given
        String userInput = "1";
        // when
        int result = racingController.userInputToInt(userInput);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("기능15 테스트: 유저가 입력한 값이 숫자가 아니면 userInputToInt 메서드가 IllegalArgument Exception을 발생시킨다.")
    void userInputToIntShouldThrowIllegalArgumentExceptionWhenUserInputIsNotANumber() {
        // given
        String userInput = "A";

        // when, then
        assertThatThrownBy(() -> racingController.userInputToInt(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_A_INTEGER_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("기능13 테스트 : registerTotalRound 메서드가 유저가 입력한 값을 검증후 숫자로 반환한다.")
    void registerTotalRoundShouldReturnIntegerNumberAfterValidation() {
        System.setIn(createUserInput("1"));

        int result = racingController.registerTotalRound();

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("기능13 테스트 : registerTotalRound 메서드는 숫자가 아닌 입력값을 받았을 때 IllegalArgument Exception을 발생시킨다.")
    void registerTotalRoundShouldThrowIllegalArgumentExceptionWhenUserInputIsNotANumber() {
        // given
        System.setIn(createUserInput("A"));

        // when, then
        assertThatThrownBy(() -> racingController.registerTotalRound())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_A_INTEGER_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("기능16 테스트: playRacing 메서드가 전체 경주를 진행하고 결과를 출력해주는 지 확인한다.")
    void playRacing() {
        // given
        Car car1 = new Car("A",0);
        Car car2 = new Car("B",0);
        Car car3 = new Car("C",0);

        List<Car> carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        int totalRound = 3;

        // when
        racingController.playRacing(carList, totalRound);

        String result = outputStreamCaptor.toString();
        int count = StringUtils.countOccurrences(result, "A");

        // then
        assertThat(result).contains("실행 결과");
        assertThat(count).isEqualTo(totalRound);
    }


    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }


}