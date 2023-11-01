package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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

    public Integer checkRoundsInput(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getRandomValue(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void play(){
        for(String car : playersMap.keySet()){
            int moveOrStop = getRandomValue();
        }
    }

    public void run(){
        System.out.println(Notification.inputCarsName);
        initPlayer(Console.readLine());

        System.out.println(Notification.inputNumOfRounds);
        int numOfRounds = checkRoundsInput(Console.readLine());

        System.out.println(Notification.result);
        for (int i = 0; i < numOfRounds; i++) {
            play();
        }
    }
}
