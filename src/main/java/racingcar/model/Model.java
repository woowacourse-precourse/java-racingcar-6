package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

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

    public void racing(List<Car> carList, int times){
        for(int i = 0 ; i < times ; i++) {
            racingForOneTurn(carList);


        }
    }
}
