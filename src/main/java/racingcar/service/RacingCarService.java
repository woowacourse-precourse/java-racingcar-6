package racingcar.service;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCarService {

    public int generateRandomNumber() {
        int randomNumber = pickNumberInRange(0, 9);
        return randomNumber;
    }
    public List<Integer> saveRandomNumber(List<Car> cars) {
        List<Integer> allRandomNumbers = new ArrayList<>();
        for(int i=0; i< cars.size(); i++) {
            allRandomNumbers.add(generateRandomNumber());
        }
        return allRandomNumbers;
    }

    public void move(Car car, int randomNumber) {
        int position = car.getPosition();
        if (randomNumber >= 4) {
            car.setPosition(position + 1);
        }
    }

    public int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> findWinner(List<Car> cars, int maxPosition) {
        List<String> winner = new ArrayList<>();
        for(Car car: cars) {
            if(car.getPosition()>=maxPosition) {
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
