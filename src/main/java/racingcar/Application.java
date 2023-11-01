package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
    }
}

class RacingCar {
    private String[] carNames;
    private Integer numberOfTry;
    private Integer randomNum;
    public RacingCar(){
        getCarNames();
    }

    private void getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String names = Console.readLine();
        carNames = names.split(",");
    }

    private void getNumberOfMove(){
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfTry = Integer.parseInt(Console.readLine());
    }

    private void generateRandomNumber(){
        randomNum = Randoms.pickNumberInRange(0,9);
    }

    private void printWinner(){

    }

    private void startRacingCar(){

    }


}