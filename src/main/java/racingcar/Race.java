package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    NumberGenerator numberGenerator = new NumberGenerator();

    public void racing(List<Car> cars, int moveCount) {
        while (moveCount > 0) {
            List<Integer> randomNumbers = createNumber(cars.size());
            int carCount = 0;
            for (Car car : cars) {
                car.move(randomNumbers.get(carCount));
                carCount++;
            }
            moveCount--;
        }
    }

    private List<Integer> createNumber(int carCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            int randomNumber = numberGenerator.createRandomNumber();
            randomNumbers.add(randomNumber);
        }
        System.out.println(randomNumbers);

        return randomNumbers;
    }
}