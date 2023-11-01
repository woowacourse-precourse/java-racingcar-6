package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class User {
    public static String[] inputCarName() {
        String input = Console.readLine();

        return input.split(",");
    }
    public static int inputAttempts(){
        String input = Console.readLine();
        checkNumber(input);

        return Integer.parseInt(input);
    }
    private static void checkNumber(String number){
        if (number.matches("[^0-9]+")){
            throw new IllegalArgumentException("숫자 이외의 값 입력");
        }
    }
    private static void checkParticipants(int participants){
        if (participants < 2){
            throw new IllegalArgumentException("참가자 수 부족 게임 종료");
        }
    }
    public static Car[] registerCars(String[] names){
        int i = 0;
        Car[] cars = new Car[names.length];

        checkParticipants(names.length);
        for(String name : names){
            cars[i] = new Car(name);
            i++;
        }

        return cars;
    }
}
