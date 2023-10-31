package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
    private static List<String> findWinner(LinkedHashMap<String, Integer> racingCar){
        int max = 0;
        List<String> winner = new ArrayList<>();
        for (String car : racingCar.keySet()){
            int value = racingCar.get(car);
            if (value > max){
                max = value;
                winner.clear();
                winner.add(car);
            } else if (value == max) {
                winner.add(car);
            }
        }
        return winner;
    }

}

