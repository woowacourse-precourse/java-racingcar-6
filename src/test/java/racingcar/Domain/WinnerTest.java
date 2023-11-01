package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class WinnerTest {
    @Test
    void testGetWinnersWithEmptyList() {
        List<Car> emptyCars = new ArrayList<>();
        List<Car> winners = Winner.getWinners(emptyCars);
        assertThat(winners).isEmpty();
    }

    @Test
    void testGetWinnersWithSingleWinner() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("CarA"));
        cars.add(new Car("CarB"));
        cars.add(new Car("CarC"));

        cars.get(0).CarMove(5);
        cars.get(1).CarMove(2);
        cars.get(2).CarMove(2);

        // Act
        List<Car> winners = Winner.getWinners(cars);

        // Assert
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactlyInAnyOrder(cars.get(0));
    }

    @Test
    void testGetWinnersWithMultipleWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("CarA"));
        cars.add(new Car("CarB"));
        cars.add(new Car("CarC"));

        cars.get(0).CarMove(5);
        cars.get(1).CarMove(5);
        cars.get(2).CarMove(2);

        // Act
        List<Car> winners = Winner.getWinners(cars);

        // Assert
        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder(cars.get(0),cars.get(1));
    }

    @Test
    void testGetWinnersWithNullList() {
        List<Car> cars = null;
        assertThatThrownBy(() -> Winner.getWinners(cars))
                .isInstanceOf(NullPointerException.class);
    }
}