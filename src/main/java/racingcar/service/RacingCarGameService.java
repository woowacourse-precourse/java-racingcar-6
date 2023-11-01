package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;


public class RacingCarGameService {
    CarService carService = new CarService();

    public void displayGameProgress(int attemptNum, List<Car> carList) {
        for(int i = 0; i < attemptNum; i++) {
            carService.moveForwards(carList);
            carService.displayPositions(carList);
            System.out.println();
        }
    }

    public List<String> findWinnerCar(List<Car> carList) {
        int winCarPosition = -1;
        List<String> carNameList = new ArrayList<>();
        for (Car car : carList) {
            if(car.getPosition() > winCarPosition) {
                winCarPosition = car.getPosition();
                carNameList.clear();
                carNameList.add(car.getName());
                continue;
            }
            if (car.getPosition() == winCarPosition) {
                winCarPosition = car.getPosition();
                carNameList.add(car.getName());
            }
        }
        return carNameList;
    }

    public void displayWinnerCar(List<Car> carList) {
        List<String> carNameList = findWinnerCar(carList);
        String winCarName = carNameList.get(0);
        for (int i = 1; i < carNameList.size(); i++) {
            winCarName += ", " + carNameList.get(1);
        }
        System.out.println(winCarName);
    }


}
