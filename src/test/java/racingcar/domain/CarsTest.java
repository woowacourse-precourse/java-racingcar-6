package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.InputView;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @ParameterizedTest
    @CsvSource(value = {"글자수제한", "자동차1,자동차20"}, delimiter = '/')
    public void 자동차_이름_부여(String namesFromUser) {
        String[] names = InputView.validateNames(namesFromUser);
        cars.addCarsFromNames(names);
        List<Car> list = cars.getCars();

        StringJoiner actual = new StringJoiner(",");
        list.forEach(car -> {
            actual.add(car.getName());
        });

        assertThat(actual.toString()).isEqualTo(namesFromUser);
    }

    @ParameterizedTest
    @CsvSource(value = {"하이브리드/2/전기차/3/트럭/1/전기차", "자동차1/1/자동차2/1/자동차3/0/자동차1, 자동차2"}, delimiter = '/')
    public void 우승자_선정(String name1, int distance1, String name2, int distance2, String name3, int distance3,
                       String expected) {
        cars = new Cars(Arrays.asList(new Car(name1, distance1),
                new Car(name2, distance2),
                new Car(name3, distance3)));

        String actual = cars.findWinners();
        assertThat(actual).isEqualTo(expected);
    }
}