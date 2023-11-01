package racingcar.util;

import racingcar.Model.CarModel;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.Verify.inputVerify;

public class StringTo {
    public static List<CarModel> stringToCarModelList(String input){
        String[] names = inputVerify(input);
        List<CarModel> carList = new ArrayList<>();
        for (int i=0; i<names.length;i++) {
            carList.add(new CarModel(names[i]));
        }
        return carList;
    }

    public static Integer stringToCarCntInteger(String input){
        return Integer.parseInt(String.valueOf(input));
    }
}
