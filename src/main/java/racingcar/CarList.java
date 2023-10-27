package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList;

    public CarList(String carsName)  throws IllegalArgumentException{
        this.carList = new ArrayList<>();
        String[] names = splitNamesByComma(carsName);
        if (!isValidNameLength(names)) {
            throw new IllegalArgumentException();
        }
    }

    private String[] splitNamesByComma(String name){
        return name.split(",");
    }

    private boolean isValidNameLength(String[] names){
        for (String name : names) {
            if (name.length() == 0 || name.length() >= 6) {
                return false;
            }
        }
        return true;
    }

}
