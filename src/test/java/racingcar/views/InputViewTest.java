package racingcar.views;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.CarNameIncorrectException;
import racingcar.exception.CarNameSizeLimitExceededException;
import racingcar.utils.InputValidate;

class InputViewTest {

    @AfterEach
    void setUp() {
        Console.close();
    }

    @Test
    @DisplayName("Console readLine 테스트")
    void consoleReadLineTest() {
        String input = "입력 값 테스트";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = Console.readLine();

        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("자동차 이름 입력 시 빈값, null 입력 시 예외 발생")
    void nullAndEmptyCheckTest() {

        String inputNull = null;
        String inputEmpty = "";
        String inputBlank = "  ";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateCarNames(inputNull);
        });
        assertThrows(CarNameIncorrectException.class, () -> {
            InputValidate.validateCarNames(inputNull);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateCarNames(inputEmpty);
        });
        assertThrows(CarNameIncorrectException.class, () -> {
            InputValidate.validateCarNames(inputEmpty);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateCarNames(inputBlank);
        });
        assertThrows(CarNameIncorrectException.class, () -> {
            InputValidate.validateCarNames(inputBlank);
        });

    }

    @Test
    @DisplayName("자동차 이름 입력 시 정상처리 테스트")
    void carNameInputSuccess() {

        String normal = "1,12,123,1234,12345";

        // console.readLine() 에 테스트 입력 값 등록
        System.setIn(new ByteArrayInputStream(normal.getBytes()));

        RacingCars racingCars = InputView.getRacingCars();
        List<Car> carNameList = racingCars.getRacingCars();

        assertThat(carNameList.size()).isEqualTo(5);
        assertThat(carNameList).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름 입력 시 공백이 포함되어 있는 경우 공백 제거")
    void carnameSplitAndNameSizeLimitTest() {

        String emptyNormal = "12  3,1234 ,12345, ,";

        // console.readLine() 에 테스트 입력 값 등록
        System.setIn(new ByteArrayInputStream(emptyNormal.getBytes()));

        RacingCars racingCars = InputView.getRacingCars();
        List<Car> carNameList = racingCars.getRacingCars();
        
        assertThat(carNameList.size()).isEqualTo(3);
        assertThat(carNameList).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름 입력 시 5글자 이상인 경우 예외 테스트")
    void carNameOverSizeLimitTest() {

        String error = "12  3,1234 ,12345122, ,";

        // console.readLine() 에 테스트 입력 값 등록
        System.setIn(new ByteArrayInputStream(error.getBytes()));
        assertThrows(CarNameSizeLimitExceededException.class, InputView::getRacingCars);
    }

    @Test
    @DisplayName("도전 횟수 입력 받기 숫자 타입 체크")
    void tryCountInputAndNumberTypeCheckTest() {
        // 정상의 경우
        assertDoesNotThrow(() -> InputValidate.validateMovingCount("123"));
        // 비정상의 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateMovingCount(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateMovingCount("1 3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateMovingCount(" a");
        });
        // 0 이하의 값 입려 시 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateMovingCount("0");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateMovingCount("-1");
        });
        // Integer Max 값 이상의 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidate.validateMovingCount("2147483648");
        });
    }

    @Test
    @DisplayName("자동차 이름 중복 입력 시 예외 발생 테스트")
    void carNameDuplicateTest() {

        String error = "1,12,12345,1";

        // console.readLine() 에 테스트 입력 값 등록
        System.setIn(new ByteArrayInputStream(error.getBytes()));
        assertThrows(CarNameDuplicateException.class, InputView::getRacingCars);
    }

}