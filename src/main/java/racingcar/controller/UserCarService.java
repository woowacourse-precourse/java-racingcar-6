package racingcar.controller;

import java.util.Map;

public class UserCarService {
    public boolean checkCorrectName(Map<String, Integer> car){
        int count=0;
        for (String key : car.keySet()){
            count+=checkLength(key);
        }
        if(count>=1){
            throw new IllegalArgumentException("5자 이하로 입력하시오");
        }
        return true;
    }
    public int checkLength(String key){
        if(key.length()>5){
            return 1;
        }
        return 0;
    }
}
