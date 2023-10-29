package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}