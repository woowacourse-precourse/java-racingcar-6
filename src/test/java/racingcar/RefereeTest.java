package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveCarType;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RefereeTest {

    private final Referee referee = new Referee();

    @Test
    @DisplayName("차 총 3개. 제일 멀리 간 차(woo, yong)의 위치 5")
    public void testPosition5WooAndYongIsWin() {
        List<Car> cars = makeCars(List.of("Yong", "Ha", "Woo"), List.of(5,2,5));
        Set<String> winnersName = new java.util.HashSet<>(Set.of("Yong", "Woo"));
        int winnerPosition = 5;

        List<Car> winners = referee.getWinnerCars(cars);

        Assertions.assertEquals(2, winners.size());

        for (int i = 0; i < winners.size(); i++) {
            Assertions.assertTrue(winnersName.contains(winners.get(i).getName()));
            Assertions.assertEquals(winnerPosition, winners.get(i).getPosition());
            winnersName.remove(winners.get(i).getName());
        }
    }

    @Test
    @DisplayName("차 총 2개. 제일 멀리 간 차(woo)의 위치 1")
    public void testPosition2WooIsWin() {
        List<Car> cars = makeCars(List.of("woo", "yong"), List.of(1,0));
        String winnerName = "woo";
        int winnerPosition = 1;

        List<Car> winners = referee.getWinnerCars(cars);

        Assertions.assertEquals(1, winners.size());
        Assertions.assertEquals(winnerName, winners.get(0).getName());
        Assertions.assertEquals(winnerPosition, winners.get(0).getPosition());
    }

    private List<Car> makeCars(List<String> carNames, List<Integer> carPositions) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            moveCar(car, carPositions.get(i));
            cars.add(car);
        }

        return cars;
    }

    private void moveCar(Car car, int position) {
        for (int i = 0; i < position; i++) {
            car.move(MoveCarType.FORWARD);
        }
    }

}
