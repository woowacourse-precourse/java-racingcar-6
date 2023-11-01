package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest extends NsTest {

    @Test
    public void 자동차의_이름은_중복될_수_없다() {
        // given
        String[] carNames = {"pobi, pobi"};

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = "3:4", delimiterString = ":")
    public void 단독_우승(int randomNumber1, int randomNumber2) {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("jun");
                },
                randomNumber1, randomNumber2
        );
    }

    @ParameterizedTest
    @CsvSource(value = "4:4", delimiterString = ":")
    public void 공동_우승(int randomNumber1, int randomNumber2) {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("pobi, jun");
                },
                randomNumber1, randomNumber2
        );
    }

    @Override
    public void runMain() {
        String[] carNames = {"pobi", "jun"};
        Cars cars = new Cars(carNames);
        cars.progressAllCars();
        List<String> winnerNames = cars.getWinners().stream()
                .map(w -> w.getName())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", winnerNames));
    }
}