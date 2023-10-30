package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        validateCarsNumber(carList);
        this.carList = carList;
    }

    public void allCarsForward() {
        for (Car car : this.carList) {
            car.forwardCar();
        }
    }

    public void validateCarsNumber(List<Car> carList) {
        if (carList.size() == 0) {
            throw new IllegalArgumentException();
        }
    }
    public String toString() {
        String result = "";
        for(Car car : carList){
            result += car.toString();
            result += "\n";
        }
        return result;
    }
}
