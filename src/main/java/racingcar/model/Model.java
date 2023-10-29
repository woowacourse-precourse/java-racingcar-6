package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import racingcar.view.View;

public class Model {
    public List<Car> makeCarList(String[] carNameArray){
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameArray) {
            Car newCar = new Car(carName);
            carList.add(newCar);
        }

        return carList;
    }

    public void racingForOneTurn(List<Car> carList) {
        for (Car currentCar : carList) {
            int randomNum = Randoms.pickNumberInRange(0,9);

            if(randomNum >= 4) {
                currentCar.increaseDistance();
            }
        }
    }

    public List<String> getWinnerList(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int maxDistance = 0;

        for (Car currentCar : carList) {
            int currentDistance = currentCar.getDistance();

            if(maxDistance < currentDistance) {
                maxDistance = currentDistance;

                winnerList.clear();

                String currentName = currentCar.getName();
                winnerList.add(currentName);
            }
            else if (maxDistance == currentDistance) {
                String currentName = currentCar.getName();
                winnerList.add(currentName);
            }
        }

        return winnerList;
    }
}
