package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    @DisplayName("0부터 9까지의 숫자값을 넣었을 때, 차량의 전진 여부를 테스트합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentProvider")
    void moveForward_IsMoveCorrectByInput(String testName, int randomNumber, int expectedLocation) {
        String carName = "abcde";
        Car actual = new Car(carName);
        actual.moveForward(randomNumber);

        Car expected = new Car(carName, expectedLocation);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("0 입력 : 이동하지 않음", 0, 0),
                arguments("1 입력 : 이동하지 않음", 1, 0),
                arguments("2 입력 : 이동하지 않음", 2, 0),
                arguments("3 입력 : 이동하지 않음", 3, 0),
                arguments("4 입력 : 앞으로 1칸 이동", 4, 1),
                arguments("5 입력 : 앞으로 1칸 이동", 5, 1),
                arguments("6 입력 : 앞으로 1칸 이동", 6, 1),
                arguments("7 입력 : 앞으로 1칸 이동", 7, 1),
                arguments("8 입력 : 앞으로 1칸 이동", 8, 1),
                arguments("9 입력 : 앞으로 1칸 이동", 9, 1)
        );
    }
}