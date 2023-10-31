package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;

public class Game {
    User user = new User();
    LinkedHashMap<String, Integer> racingCar = user.carReset();
    private int randomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
    private boolean checkNumber(Integer randomNumber){
        return randomNumber >= 4;
    }
     private LinkedHashMap<String, Integer> updateCarStats(LinkedHashMap<String, Integer> racingCar) {
         for (String car : racingCar.keySet()) {
             if (checkNumber(randomNumber())) {
                 int count = racingCar.get(car);
                 racingCar.put(car, count + 1);
             }
         }
         return racingCar;
     }
}
