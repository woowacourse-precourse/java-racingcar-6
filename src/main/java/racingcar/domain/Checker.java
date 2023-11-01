package racingcar.domain;

import java.util.List;

public class Checker{
    public void checkNumber(String inputAttempts){
        try{
            Integer.parseInt(inputAttempts);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    public void checkMember(String carName){
        if(carName.length()>5 || carName.length()<1){
            throw new IllegalArgumentException();
        }
    }
}
