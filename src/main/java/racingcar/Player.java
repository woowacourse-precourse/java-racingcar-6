package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Player {

    private HashMap<String,Integer> cars;
    private String[] inputCarNames;

    public void setCarName(){
        inputCarNames = Console.readLine().split(",");
        for(int i = 0; i < inputCarNames.length; i++){
            cars.put(inputCarNames[i], 0);
        }
    }

    public HashMap<String, Integer> getCarName(){
        return cars;
    }
}
