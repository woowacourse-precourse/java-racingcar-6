package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.input.InputCarInfo;
import racingcar.input.InputTryNumber;

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
        printWinner();

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
        } else {
            return false;
        }
    }

    public void printResultOfRounds(){
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public void printWinner(){
        Winner winner = new Winner();
        List<String> winners = winner.findWinners(cars);

        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}