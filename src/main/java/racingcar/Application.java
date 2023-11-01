package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        while(true){
            racingCar.startRacingCar();
        }
    }
}

class RacingCar {
    private String[] carNames;
    private Integer numberOfTry;
    private Integer randomNum;
    public RacingCar(){
        getCarNames();
        getNumberOfMove();
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

    private Boolean checkRandomNumber(){
        randomNum = Randoms.pickNumberInRange(0,9);
        if(randomNum>=4){
            return true;
        }
        return false;
    }

    private void printWinner(){

    }

    private void printMove(int move){

    }

    public void startRacingCar(){

    }


}