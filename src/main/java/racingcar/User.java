package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class User {
    private String input(){
        return Console.readLine();
    }
    private String[] splitInput(String input){
        return input.split(",");
    }
    private int stringToInteger(String input){
        return Integer.parseInt(input);
    }
    public LinkedHashMap<String, Integer> carReset(){
        LinkedHashMap<String, Integer> racingCar = new LinkedHashMap<>();
        String[] input = splitInput(input());
        for (String car : input){
            racingCar.put(car, 0);
        }
        return racingCar;
    }
}
