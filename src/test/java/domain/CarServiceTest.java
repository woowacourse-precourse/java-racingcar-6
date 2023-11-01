package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    @Test
    void 최종_우승자를_판단할_수_있는가() {
        CarService carService = new CarService();
        List<String> names = List.of("pobi", "woni", "jun");

        List<Integer> positions = List.of(1, 2, 3);
        carService.setCars(new Cars(names, positions));
        List<String> winnersNames = carService.decideWinner().stream()
                .map(Car::getName)
                .toList();
        assertThat(winnersNames).isEqualTo(List.of("jun"));

        positions = List.of(2, 2, 1);
        carService.setCars(new Cars(names, positions));
        winnersNames = carService.decideWinner().stream()
                .map(Car::getName)
                .toList();
        assertThat(winnersNames).isEqualTo(List.of("pobi", "woni"));
    }
}
