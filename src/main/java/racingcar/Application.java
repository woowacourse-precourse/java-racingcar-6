package racingcar;

import racingcar.carRacingGame.GameResult;
import racingcar.input.Input;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = new Input();
        GameResult gameResult = new GameResult();
        List<String> carNameList = input.carNameList();

        gameResult.gameResult(carNameList, input.carNameMap(carNameList), input.tryNumber() );
    }
}
