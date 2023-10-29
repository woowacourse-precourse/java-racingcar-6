package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import racingcar.view.View;

public class Model {
    public List<Car> makeCarList(String[] namesOfCars){
        List<Car> carList = new ArrayList<>();

        for (String nameOfCar : namesOfCars) {
            Car newCar = new Car(nameOfCar);
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

    public void racing(List<Car> carList, int times){
        View view = new View();

        for(int i = 0 ; i < times ; i++) {
            racingForOneTurn(carList);
            view.printResult(carList);
        }

        List<String> winnerList = getWinnerList(carList);
        view.printWinner(winnerList);
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
