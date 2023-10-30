package racingcar.exeption;

import java.util.List;

public class CustomizedException {
    public static void numberUpException(List<String> carList){
        for(int i = 0 ; i< carList.size();i++){
            if(carList.get(i).length()>5){
                throw new IllegalArgumentException();
            }

        }
    }
}
