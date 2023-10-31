package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
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

    @ParameterizedTest
    @CsvSource(value = {"하이브리드/2/전기차/3/전기차", "자동차1/1/자동차2/1/자동차1, 자동차2"}, delimiter = '/')
    public void 우승자_출력(String name1, int distance1, String name2, int distance2, String expected) {
        cars = new Cars(Arrays.asList(new Car(name1, distance1),
                new Car(name2, distance2)));
        String actual = cars.findWinners();

        assertThat(actual).isEqualTo(expected);
    }
}