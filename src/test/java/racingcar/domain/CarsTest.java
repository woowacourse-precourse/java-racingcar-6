package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest extends NsTest {

    private static final String DELIMITER = ", ";
    private static final String POBI = "pobi";
    private static final String JUN = "jun";

    @Override
    public void runMain() {
        // given
        String[] carNames = {POBI, JUN};
        Cars cars = new Cars(carNames);

        // when
        cars.progressAllCars();
        List<String> winnerNames = cars.getWinners().stream()
                .map(w -> w.getName())
                .collect(Collectors.toList());

        // then
        System.out.println(String.join(DELIMITER, winnerNames));
    }

    @Test
    public void 자동차의_이름은_중복될_수_없다() {
        // given
        String[] carNames = {POBI, POBI};

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이름이_중복되지_않을_경우_Cars_객체를_생성할_수_있다() {
        // given
        String[] carNames = {POBI, JUN};

        // when
        Cars cars = new Cars(carNames);

        // then
        Assertions.assertThat(cars).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = "1:4", delimiterString = ":")
    public void 가장_전진해있는_자동차의_위치를_구할_수_있다(int randomNumber1, int randomNumber2) {
        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains(JUN);
                },
                randomNumber1, randomNumber2
        );
    }

    @ParameterizedTest
    @CsvSource(value = "3:4", delimiterString = ":")
    public void 단독_우승(int randomNumber1, int randomNumber2) {
        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains(JUN);
                },
                randomNumber1, randomNumber2
        );
    }

    @ParameterizedTest
    @CsvSource(value = "4:4", delimiterString = ":")
    public void 공동_우승(int randomNumber1, int randomNumber2) {
        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains(POBI + DELIMITER + JUN);
                },
                randomNumber1, randomNumber2
        );
    }

}