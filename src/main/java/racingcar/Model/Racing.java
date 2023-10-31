package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

import racingcar.Model.Car;

public class Racing {
    static List<Car> cars = new ArrayList<>();
    private static int maxPosition = 0;

    public void UpdateCars(List<String> carNameList)
    {
        for(var carName : carNameList) {
            cars.add(new Car(carName));
        }
    }

    public void progressCarRacing() {
        for(var car : cars) {
            if(isMove())
                car.updatePosition();
        }
    }

    public List<Car> getRacingCar() {
        return cars;
    }

    public static List<String> getWinner() {
        getMaxPosition();
        List<String> winnerList = new ArrayList<>();
        for (var car : cars) {
            int carPosition = car.getPosition().length();
            if (carPosition == maxPosition)
                winnerList.add(car.getName());
        }
        return winnerList;
    }

    private static boolean isMove() {
        return getRandomMoveNumber() >= 4;
    }
    private static int getRandomMoveNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static void getMaxPosition() {
        for(var car : cars) {
            int carPosition = car.getPosition().length();
            if(carPosition > maxPosition)
                maxPosition = carPosition;
        }
    }
}
