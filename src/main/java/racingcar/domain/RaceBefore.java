package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.LinkedHashMap;
import java.util.Map;

public class RaceBefore {
    public Map<String, Integer> carName(){
        //자동차 이름 입력
        Map<String, Integer> car = new LinkedHashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

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
