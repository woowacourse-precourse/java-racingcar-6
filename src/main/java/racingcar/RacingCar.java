package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCar {

    //입력 분할
    public String[] splitCarsName(String input){

        return input.split(",");
    }

    public void initPlayer(String input){
        String [] cars = splitCarsName(input);

    }

    public void run(){
        System.out.println(Notification.inputCarsName);
        initPlayer(Console.readLine());

        System.out.println(Notification.inputNumOfRounds);

        System.out.println(Notification.result);

    }
}
