package racingcar.util;

import static racingcar.util.Verify.inputVerify;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.CarModel;

public class StringTo {

    public static List<CarModel> stringToCarModelList(String input){
        String[] names = inputVerify(input);
        List<CarModel> carList = new ArrayList<>();
        for(int i=0; i<names.length;i++){
            carList.add(new CarModel(names[i]));
        }
        return carList;
    }

    public static Integer stringToCarCntInteger(String input){
        return Integer.parseInt(String.valueOf(input));
    }
}
