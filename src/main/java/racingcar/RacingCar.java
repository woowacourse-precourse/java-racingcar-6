package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCar {

    //입력 분할
    public String[] splitCarsName(String input){

        return input.split(",");
    }

    //자동차 이름 입력 예외
    public void checkCarsNameLength(String[] players) {

        for (String player : players) {
            if (player.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void initPlayer(String input){
        String [] cars = splitCarsName(input);
        checkCarsNameLength(cars);

    }

    public void run(){
        System.out.println(Notification.inputCarsName);
        initPlayer(Console.readLine());

        System.out.println(Notification.inputNumOfRounds);

        System.out.println(Notification.result);

    }
}
