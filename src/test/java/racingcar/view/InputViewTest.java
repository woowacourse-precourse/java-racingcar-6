package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.TryCount;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputViewTest {

    private InputView inputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("사용자는 자동차를 두 대 이상 입력해서 Cars로 반환받을 수 있다.")
    void carsInputTest() {
        // given
        String input = "pobi,woni";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Cars cars = inputView.inputCarNames();

        // then
        assertAll(
                () -> assertThat(cars.value()).hasSize(2),
                () -> assertThat(cars.value()).containsExactly(new Car(new Name("pobi")), new Car(new Name("woni"))
                ));
    }

    @Test
    @DisplayName("사용자는 시도 회수 3을 입력해서 int 3을 반환받을 수 있다.")
    void tryCountInputTest() {
        // given
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        TryCount tryCount = inputView.inputTryCount();

        // then
        assertThat(tryCount).isEqualTo(new TryCount(3));
    }
}
