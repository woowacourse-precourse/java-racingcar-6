package racingcar.validation;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class InputValidation {

    private static final Integer MAX_LENGTH = 5;
    public static boolean validateInput(String carInput){
        String[] carList = carInput.split(",");

        for(int i=0; i<carList.length; i++){
            if(carList[i].length() > MAX_LENGTH){
                return false;
            }
        }
        return true;
    }
}
