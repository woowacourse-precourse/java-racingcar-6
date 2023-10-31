package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.domain.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void getCars_이름_입력_확인() {

        BDDMockito.given(Console.readLine()).willReturn("foo,bar");
        InputView inputView = new InputView();

        List<Car> cars = inputView.getCars();
        List<Car> expect = List.of(new Car("foo"), new Car("bar"));

        assertIterableEquals(cars, expect);

    }

}