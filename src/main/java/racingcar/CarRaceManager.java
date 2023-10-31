package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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