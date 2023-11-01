package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame implements Game{

    List<Car> cars;
    int playCnt;

    public void startGame(){
        cars = InputCarInfo.inputCarName();
        playCnt = InputTryNumber.inputTryNumber();

        System.out.println();
        System.out.println("실행 결과");

        for(int i = 0; i < playCnt; i++){
            playGame();
            printResultOfRounds();
            System.out.println();
        }
    }

    public void playGame(){
        for (Car car : cars){
            boolean shouldMove = determineMove();
            if (shouldMove){
                car.goForward();
            }
        }
    }

    private boolean determineMove(){
        int check = Randoms.pickNumberInRange(0, 9);

        if (check >= 4){
            return true;
        }
        else {
            return false;
        }
    }

    public void printResultOfRounds(){
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}