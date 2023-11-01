package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public Cars(){
    }
    public static List<Car> buildCar(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName: carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }
    public static List<String> createCarList(String[] carNames){
        List<String> carNameList = new ArrayList<>();
        for(String carName: carNames){
            if(carNameList.contains(carName)){
                throw new IllegalArgumentException("중복된 이름입니다.");
            }
            carNameList.add(carName);
        }
        return carNameList;
    }
}
