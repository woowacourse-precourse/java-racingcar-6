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
    private void printRacing(LinkedHashMap<String, Integer> racingCar){
        for (String car : racingCar.keySet()){
            String dashes = "-".repeat(racingCar.get(car));
            System.out.println(car + " : " + dashes);
        }
        System.out.println();
    }
}
