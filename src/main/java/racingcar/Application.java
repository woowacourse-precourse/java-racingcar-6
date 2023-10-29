package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racers = Console.readLine();
        String[] racersList = racers.split(",");

        RacingCar[] RacingCars = new RacingCar[racersList.length];

        for(int i = 0; i< racersList.length; i++){
            RacingCar car = new RacingCar(racersList[i],0);
            RacingCars[i] = car;
        }

    }
}
