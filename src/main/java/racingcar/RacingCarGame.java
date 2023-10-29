package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public void play() {
        try {
            List<Car> cars = initializeGame();
            int tryCount = UserInput.getInputInt("시도할 회수는 몇회인가요?", 1, 9);
            CarManager gameManager = new CarManager(cars);

            List<List<String> > allResults = new ArrayList<>();
            for (int i = 0; i < tryCount; i++) {
                gameManager.race(1);
                List<String> roundResults = cars.stream()
                        .map(car -> car.getName() + " : " + car.getPositionString())
                        .collect(Collectors.toList());
                allResults.add(roundResults);
            }

            RacingResult.printAllResults(allResults);
            RacingResult.printWinners(cars);
        } catch (RacingGameException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Car> initializeGame() throws RacingGameException {
        String inputNames = UserInput.getInputString("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분) ");
        List<Car> cars = ParkingLot.createCars(inputNames);
        return cars;
    }
}
