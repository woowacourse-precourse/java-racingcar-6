package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.CarValidator;

public class CarFactory {

    private final CarValidator carValidator;

    public CarFactory(){
        this.carValidator = new CarValidator();
    }

    public List<Car> generateCarListWithName(List<String> carNameList){
        carValidator.validateCarNamesInput(carNameList);
        List<Car> CarList = new ArrayList<>();
        for (String carName : carNameList) {
            CarList.add(new Car(carName));
        }
        return CarList;
    }
}
