package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class RacingCar {

    Map<String, String> playersMap = new HashMap<>();

    //입력 분할
    public String[] splitCarsName(String input){

        return input.split(",");
    }

    //자동차 이름 입력 예외
    public void checkCarsNameLength(String[] cars) {

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void saveCars(String[] cars) {

        for (String car : cars) {
            playersMap.put(car, "");
        }
    }

    public void initPlayer(String input){
        String [] cars = splitCarsName(input);
        checkCarsNameLength(cars);
        saveCars(cars);
    }

    public void run(){
        System.out.println(Notification.inputCarsName);
        initPlayer(Console.readLine());

        System.out.println(Notification.inputNumOfRounds);

        System.out.println(Notification.result);

    }
}
