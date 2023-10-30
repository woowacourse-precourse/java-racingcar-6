package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    private static boolean firstWinner = true;

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCars = Console.readLine();
        List<Car> cars = new RacingGame().inputCarName(racingCars);
        int attemptsNum = new RacingGame().inputForwardCar();

        System.out.println("\n실행결과");
        while(attemptsNum > 0){

            for(Car car : cars){
                car.forward();
            }
            
            RacingGame.printRaceState(cars);
            System.out.println("");
            attemptsNum--;

        } // while

        RacingGame.printFinalWinner(cars);
    } // main


} // end class
