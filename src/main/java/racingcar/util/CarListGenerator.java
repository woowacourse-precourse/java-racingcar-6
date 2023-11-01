package racingcar.util;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.view.InputView;

public class CarListGenerator {
    InputView inputview = new InputView();
    ArrayList<String> carNameList = new ArrayList<>();
    public ArrayList<String> generateCarNameList() {
        String carNames = inputview.readCarName();
        for (String s : carNames.split(",")) {
            carNameList.add(s);
        }
        return carNameList;
    }

    public ArrayList<Car> generateCarsList(ArrayList<String> carNameList) {
        ArrayList<Car> carsList = new ArrayList<>();
        for (String carName : carNameList) {
            Car car = new Car(carName , 0);
            carsList.add(car);
        }
        return carsList;
    }
}
