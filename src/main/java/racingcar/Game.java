package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Game {
    User user = new User();
    LinkedHashMap<String, Integer> racingCar = user.carReset();
    public void racingGame(){
        int iterationNumber = user.stringToInteger();

        for (int i = 0; i < iterationNumber; i++) {
            printRacing(updateCarStats(racingCar));
        }
        printWinner(findWinner(racingCar));

    }
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
    private static void printWinner(List<String> winner){
        System.out.print("최종 우승자 : ");
        if (!winner.isEmpty()) {
            for (int i = 0; i < winner.size(); i++) {
                System.out.print(winner.get(i));
                if (i < winner.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
}