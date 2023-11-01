package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.domain.Attempt;
import racingcar.domain.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class InputViewTest {

    static MockedStatic<Console> console;

    @BeforeAll
    static void beforeAll() {
        console = Mockito.mockStatic(Console.class);
    }

    @AfterAll
    static void afterAll() {
        console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"foo,bar", "foo, bar", "       foo,bar       ", "foo       ,       bar"})
    void getCars_이름_입력_확인(String foobar) {

        given(Console.readLine()).willReturn(foobar);
        InputView inputView = new InputView();

        List<Car> cars = inputView.getCars();
        List<Car> expect = List.of(new Car("foo"), new Car("bar"));

        assertIterableEquals(cars, expect);

    }

    @Test
    void getAttempt_시도_횟수_0_입력_확인() {

        given(Console.readLine()).willReturn("0");
        InputView inputView = new InputView();

        Attempt attempt = inputView.getAttempt();

        assertFalse(attempt.isExist());

    }

    @Test
    void getAttempt_시도_횟수_1_입력_확인() {

        given(Console.readLine()).willReturn("1");
        InputView inputView = new InputView();

        Attempt attempt = inputView.getAttempt();

        assertTrue(attempt.isExist());

    }

}