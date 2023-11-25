package racingcar.Util;

import java.util.HashSet;
import java.util.Set;

public class CheckNameException {

    public static void carsNameExceptionCheck(String input){
        carsNameLengthCheck(input);
        carsNameContainBlank(input);
        carsNameisEmpty(input);
        carNameEqualCheck(input);
    }

    public static void carsNameLengthCheck(String input){
        for (String name : input.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 길이를 초과하였습니다");
            }
        }
    }

    private static void carsNameContainBlank(String input){
        if(input.contains(" ")){
            throw new IllegalArgumentException("공백이 포함되어 있습니다");
        }
    }

    private static void carsNameisEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
    }

    public static void carNameEqualCheck(String input){
        Set<String> carName = new HashSet<>();
        for(String name : input.split(",")){
            if(!carName.add(name)){
                throw new IllegalArgumentException("중복된 이름 입니다.");
            }
        }
    }
}
