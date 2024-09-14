package racingcar.util;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

public class InputUtil {
/*
1. 이름이 들어왔을 때
    1-1 빈 문자열로 들어온 경우
    1-2 이름들이 5글자 이하인지
    1-3 , , , 이렇게 들어온 경우 혹은 도형, 선목, , 유진 이런식으로 들어오는 경우

 2. 자동차 움직이는 횟수 들어올 때
    2-1 정수가 아닌 경우
    2-2 음수, 0인 경우
 */


    public static String validateName(String msg){
        check_blank(msg);

        List<String> cars = splitMsg(msg);
        moreThanFive(cars);
        blankName(cars);
        return msg;
    }

    public static int validateNumberOfMoves(String msg){
        checkInteger(msg);
        positiveInteger(msg);
        return Integer.parseInt(msg);
    }

    public static void check_blank(String cars){
        if(cars.isBlank()){
            throw new IllegalArgumentException();
        }
    }


    public static void moreThanFive(List<String> cars){
        for(String car : cars ){
            if(car.trim().length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void blankName(List<String> cars){
        for(String car : cars){
            if(car.trim().isBlank()){
                throw new IllegalArgumentException();
            }
        }
    }


    public static void checkInteger(String msg){
        try{
            Integer.parseInt(msg);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static void positiveInteger(String msg){
        if(Integer.parseInt(msg) <= 0){
            throw new IllegalArgumentException();
        }
    }

    public static List<String> splitMsg(String msg){
        return  Arrays.asList(msg.split(","));
    }
}
