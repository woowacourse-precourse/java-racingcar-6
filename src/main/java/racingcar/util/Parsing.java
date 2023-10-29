package racingcar.util;

import racingcar.Entity.Car;
import racingcar.constant.SymbolType;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parsing {

    public List<Car> StringToCarList(String input) {
        List<Car> carList = new ArrayList<>();
        StringTokenizer carTokenizer = new StringTokenizer(input, SymbolType.DELIMITER_SPLIT_CARS.getValue());

        while (carTokenizer.hasMoreTokens()){
            String carName = carTokenizer.nextToken();
            carList.add(new Car(carName,0));
        }
        return carList;
    }
    public int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
