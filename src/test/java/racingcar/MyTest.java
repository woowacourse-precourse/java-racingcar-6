package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest extends NsTest {
    private User user = new User();
    @Test
    void setMoves_Test() {
        final User user = new User();
        final String input = "5";
        assertThat(Integer.parseInt(input)).isEqualTo(5);
    }

    @Test
    void randomNumber_Test() {
        final int n = 5;
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumber(n);
        assertThat(randomNumbers).hasSize(n);

        for (int number : randomNumbers) {
            assertThat(number).isGreaterThanOrEqualTo(0);
            assertThat(number).isLessThanOrEqualTo(9);
        }
    }

    @Test
    void move_Test() {
        Car car = new Car("mycar", 3);
        car.addMove();
        assertThat(car.getDistance()).isEqualTo(4);
    }

    @Test
    void printResult_Test() {
        Car car = new Car("mycar", 5);
        user.printResult(car);
        assertThat(output()).isEqualTo("mycar : -----");
    }

    @Test
    void printWinners_Test() {
        List<String> names = List.of("car1", "car2", "car3");
        user.printWinners(names);
        assertThat(output()).isEqualTo("최종 우승자 : car1, car2, car3");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
