package racingcar.util;

import static racingcar.util.Verify.inputVerify;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.CarModel;

public class StringToList {

    public static List<CarModel> stringToList(String input){
        String[] names = inputVerify(input);
        List<CarModel> carList = new ArrayList<>();
        for(int i=0; i<names.length;i++){
            carList.add(new CarModel(names[i]));
        }
        return carList;
    }
}
