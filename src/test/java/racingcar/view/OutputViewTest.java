package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Cars;

public class OutputViewTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun/5", "자동차1,자동차20/5"}, delimiter = '/')
    public void 결과_출력(String namesFromUser, int count) {
        String[] names = InputView.validateNames(namesFromUser);
        cars.addCarsFromNames(names);

        OutputView.printTryResult();
        while (count != 0) {
            cars.tryMovements();
            count--;
        }
    }
}