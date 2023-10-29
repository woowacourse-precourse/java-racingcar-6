package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {

    private List<String> cars;
    private int raceCount;
    public Racing(List<String> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void racingProcess(){
        Map<String,Integer> racingResultMap = new HashMap<>();
        for(int j = 0 ; j < raceCount ; j ++){
            for(int i = 0 ;  i < cars.size() ; i ++){
                int location = 0;

                if(racingResultMap.containsKey(cars.get(i))){
                    location = racingResultMap.get(cars.get(i));
                }

                int number = Randoms.pickNumberInRange(0,9);
                System.out.println(number);

                if(moveForward(number)){
                    location++;
                    racingResultMap.put(cars.get(i), location);
                }
                System.out.println(location);
            }
            printResult(racingResultMap);
        }
    }

    private boolean moveForward(int number){
        if(number > 3){
            return true;
        }
        return false;
    }

    private void printResult(Map<String, Integer> racingResultMap){
        for (String car : racingResultMap.keySet()) {
            int location = racingResultMap.get(car);
            System.out.println( car + " : " + "-".repeat(location) );
        }
    }
}
