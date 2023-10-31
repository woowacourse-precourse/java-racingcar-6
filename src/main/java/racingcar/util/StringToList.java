package racingcar.util;

import static racingcar.util.Verify.inputVerify;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;

public class StringToList {

    public static List<Car> stringToList(String input){
        String[] names = inputVerify(input);
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<names.length;i++){
            carList.add(new Car(names[i]));
        }
        return carList;
    }
}
