package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.Application.inputCarNames;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void testInputCarNamesWithValidInput() {
        // Arrange
        String input = "Car1,Car2,Car3";
        provideInput(input);

        // Act
        List<Car> cars = inputCarNames();

        // Assert
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting(Car::getName)
                .containsExactly("Car1", "Car2", "Car3");
    }

    @Test
    void testInputCarNamesWithEmptyName() {
        // Arrange
        String input = "Car1,,Car3"; // Include an empty car name
        provideInput(input);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> inputCarNames());
    }

    @Test
    void testInputCarNamesWithTooLongName() {
        // Arrange
        String input = "Car1,VeryLongCarNameThatExceedsTheLimit,Car3";
        provideInput(input);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> inputCarNames());
    }

    @Test
    void testInputCarNamesWithDuplicateNames() {
        // Arrange
        String input = "Car1,Car2,Car2"; // Include duplicate car names
        provideInput(input);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> inputCarNames());
    }

    private void provideInput(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        System.setIn(stdin);
    }
    @Test
    void testValidateCarNameFromEmptyWithEmptyName() {
        // Arrange
        String emptyCarName = "   ";

        // Act & Assert
        assertThatThrownBy(() -> Application.validateCarNameFromEmpty(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    void testValidateCarNameFromEmptyWithNonEmptyName() {
        // Arrange
        String nonEmptyCarName = "Car1";

        // Act (No exception should be thrown)
        Application.validateCarNameFromEmpty(nonEmptyCarName);

        // Assert (No exception)
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
