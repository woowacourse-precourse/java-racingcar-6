package racingcar.model;

import racingcar.model.Car;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Model {
    public List<Car> MakeCarList(String[] namesOfCars){
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
}
