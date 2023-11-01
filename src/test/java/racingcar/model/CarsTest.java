package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

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
        for (Car car : carList) {
            car.go();
        }

        cars = new Cars(carList);
    }

    @Test
    void getCars_미리_세팅해놓은_Cars의_값과_같은지_확인() {
        List<Car> carList = cars.getCars();

        List<String> carNames = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(carList).hasSize(3);
        assertThat(carNames).containsExactly("cho", "ho", "yeon");
    }

    @Test
    void getWinner_우승자가_여러명일경우_테스트() {
        List<String> winners = cars.getWinner();

        assertThat(winners).hasSize(3);
    }

    @Test
    void maxDistance_최대_거리가_잘나오는지테스트() {
        int maxDistance = cars.maxDistance();

        assertThat(maxDistance).isOne();
    }

    @Test
    void playOneGame_한_라운드의_게임을_진행하면_거리가_2또는_1이여야함() {
        cars.playOneGame();

        List<Integer> distances = cars.getCars().stream()
                .map(Car::getDistance)
                .collect(Collectors.toList());

        assertThat(distances).allMatch(d -> d == 2 || d == 1);
    }
}
