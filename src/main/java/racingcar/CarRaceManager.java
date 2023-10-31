package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarRaceManager {
    private List<Car> racingCars = new ArrayList<>();
    private final List<String> winnerList= new ArrayList<>();
    private int carCount = 0;

    public CarRaceManager () {}
    public CarRaceManager (final List<Car> newRacingCars) {
        racingCars = newRacingCars;
        carCount = racingCars.size();
    }

    public void createCarList() {
        // 입력 받은 값 쉼표 기준으로 나눠서 리스트에 저장
        String[] carNameArray = Console.readLine().split(","); // array말고 바로 리스트에 저장 못 하나...
        for (String carName : carNameArray) {
            Car newCar = new Car(carName);
            racingCars.add(newCar);
            carCount++;
        }
    }

    public void nthAttemptRace() {
        for (Car car : racingCars) {
            int movingNumber = Utils.generateRandomNumber();
            if (Utils.isMove(movingNumber)) {
                car.moveForward();
            }
        }
    }

    public void printAttemptResult() {
        for (Car car : racingCars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void winnerJudgment() {
    }
    public List<String> getWinnerList() {
        return winnerList;
    }
    public void printWinner() {
    }
}