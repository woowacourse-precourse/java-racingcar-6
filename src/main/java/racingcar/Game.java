package racingcar;

import racingcar.car.RacingCars;
import racingcar.view.Input;
import racingcar.view.Output;

public class Game {

    private static Output output = new Output();
    private static Input input = new Input();

    // 자동차 경기의 개최를 시작하는 함수
    public static void play(){
        RacingCars racingCars = new RacingCars(input.inputCarName());
        int gameOfNum = input.inputMovingNumber();

        start(gameOfNum,racingCars);

        output.printFinalWinner(racingCars.findLongestDistanceDriverOfNames());
    }

    //자동차 경기가 시작을 하는 함수
    private static void start(int gameOfNum,RacingCars racingCars) {
        for(int i = 0; i<gameOfNum; i++){
            racingCars.moveCars();
            output.printExecutionResult(i,racingCars.toString());
        }
    }
}
