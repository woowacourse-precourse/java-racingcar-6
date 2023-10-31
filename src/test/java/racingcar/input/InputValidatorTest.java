package racingcar.input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.input.CarTest.Car;

public class InputValidatorTest {
    private static String 차이름;
    private static String 사용자_이동_횟수;
    private static List<Car> 차량들 = new ArrayList<>();

    public void 사용자_이동_횟수_예외를_입력하라() {
        this.사용자_이동_횟수 = "ㄱ%12ㅍㄴ";
    }

    private static void 공백을_입력하라() {
        차이름 = "";
    }

    private static void 중복된_차이름을_입력하라() {
        차량들.add(Car.inputCarname("pobi1"));
        차량들.add(Car.inputCarname("pobi2"));
        차량들.add(Car.inputCarname("pobi2"));
    }

    private static void 차이름을_6자리이상_입력하라() {
        차이름 = "pobido";
    }

    static class InputValidator {
        public static void validateRaceCount(String stringRaceCount) {
            validateOnlyNumber(stringRaceCount);
            validatePositiveNumber(stringRaceCount);
        }

        private static void validatePositiveNumber(String stringRaceCount) {
            if (isPositiveNumber(stringRaceCount)) {
                throw new IllegalArgumentException("입력하실 숫자는 0이상의 수가 아닙니다.");
            }
        }

        private static boolean isPositiveNumber(String stringRaceCount) {
            int raceCount = Integer.parseInt(stringRaceCount);
            return raceCount < 0;
        }

        private static void validateOnlyNumber(String stringRaceCount) {
            if (isOnlyNumber(stringRaceCount)) {
                throw new IllegalArgumentException("입력하신 내용엔 숫자외 값이 포함되었습니다.");
            }
        }

        private static boolean isOnlyNumber(String stringRaceCount) {
            return !stringRaceCount.matches("[0-9]+");
        }

        public static void validateCarList(List<Car> cars) {
            if (isDuplicateCarNames(cars)) {
                throw new IllegalArgumentException("입력하신 차량은 중복되었습니다.");
            }
        }

        private static boolean isDuplicateCarNames(List<Car> cars) {
            List<String> carNameList = cars.stream()
                    .map(Car::getCarName)
                    .collect(Collectors.toList());

            return carNameList.size() != carNameList.stream().distinct().count();
        }

        public static void validateCarname(String carName) {
            validateUnderFiveLength(carName);
            validateWhiteSpace(carName);
        }

        private static void validateUnderFiveLength(String carName) {
            if (isOverSixLength(carName)) {
                throw new IllegalArgumentException("입력하신 차량 이름이 6자를 넘었습니다.");
            }
        }

        private static void validateWhiteSpace(String carName) {
            if (isWhiteSpace(carName)) {
                throw new IllegalArgumentException("입력하신 차량은 공백입니다.");
            }
        }

        private static boolean isOverSixLength(String carName) {
            return carName.length() >= 6;
        }

        private static boolean isWhiteSpace(String carName) {
            return carName.isBlank();
        }
    }

    @Test
    void 사용자이동횟수_입력_예외() {
        사용자_이동_횟수_예외를_입력하라();

        assertSimpleTest(() ->
                Assertions.assertThatThrownBy(() -> InputValidator.validateRaceCount(사용자_이동_횟수))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_중복입력_예외처리() {
        중복된_차이름을_입력하라();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateCarList(차량들))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_6자리이상_입력_예외처리() {
        차이름을_6자리이상_입력하라();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateUnderFiveLength(차이름))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_공백입력_예외처리() {
        공백을_입력하라();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateWhiteSpace(차이름))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
