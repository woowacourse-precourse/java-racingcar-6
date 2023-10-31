package racingcar;

import static racingcar.Validation.validateCarName;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRaceManager {
    private List<Car> racingCars = new ArrayList<>();
    private final List<String> winnerList = new ArrayList<>();
    private int carCount = 0;

    public CarRaceManager() {
    }

    public CarRaceManager(final List<Car> newRacingCars) {
        racingCars = newRacingCars;
        carCount = racingCars.size();
    }

    private List<String> inputCarName() {
        String input = Console.readLine().replaceAll(" ", "");
        String[] carNameArray = input.split(",");
        return Arrays.asList(carNameArray);
    }

    public void createCarList() {
        List<String> carNameList = inputCarName();
        Validation.validateCarName(carNameList);
        for (String carName : carNameList) {
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
        int max = 0;
        for (Car car : racingCars) {
            if (car.getMovingCount() < max) {
                continue;
            } else if (car.getMovingCount() > max) {
                winnerList.clear(); // 안에 뭐 있는지 확인  안해도 오류 안 나려나?
                max = car.getMovingCount();
            }
            winnerList.add(car.getCarName());
        }
    }

    public List<String> getWinnerList() {
        return winnerList;
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            if (i == winnerList.size() - 1) {
                System.out.println(winnerList.get(i));
            } else {
                System.out.print(winnerList.get(i) + ", ");
            }
        }
    }
}