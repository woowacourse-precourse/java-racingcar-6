package racingcar.domain;


import java.util.List;
import racingcar.domain.driver.Car;

public class Referee {

    public String announceRacingWinner(List<Car> cars) {
        int winnersMovementCount = cars.stream()
                .mapToInt(Car::getMovementCount)
                .max()
                .orElse(0);

        List<String> winnerCars = cars.stream()
                .filter(car -> car.getMovementCount() == winnersMovementCount)
                .map(Car::getName)
                .toList();

        return  generateResultMessage(winnerCars);
    }

    private String generateResultMessage(List<String> winnerCars) {
        StringBuilder racingWinnerResult = new StringBuilder("최종 우승자 : ");
        for (int winnerNumber = 0; winnerNumber < winnerCars.size(); winnerNumber++) {
            racingWinnerResult.append(winnerCars.get(winnerNumber));
            if (winnerNumber != winnerCars.size() - 1) {
                racingWinnerResult.append(", ");
            }
        }
        return racingWinnerResult.toString();
    }
}
