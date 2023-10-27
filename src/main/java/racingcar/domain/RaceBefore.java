package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashMap;
import java.util.Map;

public class RaceBefore {
    public Map<String, Integer> carName(){
        Map<String, Integer> car = new HashMap<>();

        String[] str = readLine().split(",");
        for(String s : str){
            if(s.length() > 5){
                throw new IllegalArgumentException();
            }
            car.put(s, 0);
        }

        return car;
    }
}
