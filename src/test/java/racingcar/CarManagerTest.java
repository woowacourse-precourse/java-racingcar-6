package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarManager;

public class CarManagerTest {
    private static List<Car> cars;

    @BeforeAll
    static void beforeAll() {
        cars = List.of(new Car("pobi"), new Car("joon"), new Car("min"));
    }

    @Test
    void getAttempts_메서드_사용시_객체_생성_직후인_경우_빈_리스트_반환() {
        CarManager carManager = new CarManager(cars);

        assertThat(carManager.getAttempts().size()).isEqualTo(0);
    }

    @Test
    void getAttempts_메서드_사용시_시도_횟수와_사이즈가_같은_리스트_반환() {
        CarManager carManager = new CarManager(cars);
        int numberOfAttempts = 3;
        IntStream.range(0, numberOfAttempts).forEach(i -> carManager.attempt());

        assertThat(carManager.getAttempts().size()).isEqualTo(numberOfAttempts);
    }

    @Test
    void getWinners_메서드_사용시_한_대_이상의_승자를_반환() {
        CarManager carManager = new CarManager(cars);
        int numberOfAttempts = 3;
        IntStream.range(0, numberOfAttempts).forEach(i -> carManager.attempt());

        List<Car> winners = carManager.getWinners();
        assertThat(winners.size()).isGreaterThan(0);
    }

    @Test
    void getWinners_메서드_사용시_같은_누적_거리_차들을_반환() {
        CarManager carManager = new CarManager(cars);
        int numberOfAttempts = 3;
        IntStream.range(0, numberOfAttempts).forEach(i -> carManager.attempt());

        List<Car> winners = carManager.getWinners();
        int winnerTotalDistance = winners.get(0).getTotalDistance();
        List<Car> filtered = winners.stream()
                .filter(car -> car.getTotalDistance() == winnerTotalDistance)
                .toList();

        assertThat(filtered.size()).isEqualTo(winners.size());
    }
}
