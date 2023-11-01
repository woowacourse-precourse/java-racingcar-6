package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void Cars_미리_만들어_놓기() {
        List<Car> carList = new ArrayList<>();
        carList.add(Car.makeCarByName("cho"));
        carList.add(Car.makeCarByName("ho"));
        carList.add(Car.makeCarByName("yeon"));

        cars = new Cars(carList);
    }

    @Test
    void getCars_미리_세팅해놓은_Cars의_값과_같은지_확인() {
        List<Car> carList = cars.getCars();

        List<String> carNames = carList.stream().map(Car::getName).collect(Collectors.toList());

        assertEquals(3, carList.size());
        assertEquals(List.of("cho", "ho", "yeon"), carNames);
    }

    @Test
    void getWinner_바로_우승자를_뽑으면_거리가_0이기_때문에_무승부() {
        List<String> winners = cars.getWinner();

        assertEquals(3, winners.size());
    }

    @Test
    void maxDistance_현재_거리가_0이므로_최대거리는_0() {
        int maxDistance = cars.maxDistance();

        assertEquals(0, maxDistance);
    }

    @Test
    void playOneGame_한_라운드의_게임을_진행하면_거리가_1또는_0이여야함() {
        cars.playOneGame();

        List<Integer> distances = cars.getCars().stream()
                .map(Car::getDistance)
                .collect(Collectors.toList());

        boolean isOneOrZero = distances.stream().allMatch(d -> d == 1 || d == 0);

        assertEquals(true, isOneOrZero);
    }
}
