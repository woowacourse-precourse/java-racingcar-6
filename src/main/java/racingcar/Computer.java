package racingcar;

import java.util.HashMap;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    Validation validation = new Validation();
    public HashMap<String, Integer> splitCarName(String carNameString) {
        HashMap<String, Integer> carMap = new HashMap<>();

        String[] temp = carNameString.split(",");

        for (int i = 0; i < temp.length; i++) {
            validation.carNameValidation(temp[i]);
            carMap.put(temp[i], 0);
        }

        return carMap;
    }

    int makeRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }
    int decideToMoveForward(int randomNum){
        if(randomNum >= 4){
            return 1;
        }
        return 0;
    }

}
