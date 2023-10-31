package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import generator.NumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

public class CarsTest {

    @Test
    @DisplayName("5가 나올경우 이동한다.")
    void move_test() {
        NumberGenerator generator = new NumberGenerator(5);
        Cars cars = new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(5)),
                new Car(new CarName("식빵맨"), new CarPosition(3)),
                new Car(new CarName("카레빵맨"), new CarPosition(4))
        ));

        Cars carsAfterRound = cars.simulateNextRound(generator);

        assertThat(carsAfterRound).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(6)),
                new Car(new CarName("식빵맨"), new CarPosition(4)),
                new Car(new CarName("카레빵맨"), new CarPosition(5))
        )));
    }

    @Test
    @DisplayName("3이 나올경우 이동하지 않는다.")
    void move_test2() {
        NumberGenerator generator = new NumberGenerator(3);
        Cars cars = new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(5)),
                new Car(new CarName("식빵맨"), new CarPosition(3)),
                new Car(new CarName("카레빵맨"), new CarPosition(4))
        ));

        Cars carsAfterRound = cars.simulateNextRound(generator);

        assertThat(carsAfterRound).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(5)),
                new Car(new CarName("식빵맨"), new CarPosition(3)),
                new Car(new CarName("카레빵맨"), new CarPosition(4))
        )));
    }

    @Test
    @DisplayName("우승자가 한명일 경우 한명이 담긴 리스트를 반환한다.")
    void single_winner_test() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("피카츄"), new CarPosition(24)),
                new Car(new CarName("꼬부기"), new CarPosition(41)),
                new Car(new CarName("파이리"), new CarPosition(37))
        ));

        List<String> winner = cars.getWinners();
        assertThat(winner.get(0)).isEqualTo("꼬부기");
    }

    @Test
    @DisplayName("우승자가 여러명일 경우 여러명이 담긴 리스트를 반환한다.")
    void multiple_winners_test() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("피카츄"), new CarPosition(44)),
                new Car(new CarName("꼬부기"), new CarPosition(32)),
                new Car(new CarName("파이리"), new CarPosition(44))
        ));

        List<String> winner = cars.getWinners();
        assertThat(winner.get(0)).isEqualTo("피카츄");
        assertThat(winner.get(1)).isEqualTo("파이리");
    }
}
