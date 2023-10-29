package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.RacingGameController.createRacingCars;

import racingcar.model.Cars;
import racingcar.view.RacingGameView;
public class RacingGame {
    private final RacingGameView racingGameView = new RacingGameView();
    public RacingGame(){

    }

    public void play(){
        Cars userCars = createCars();
        Integer repeat = repeatCount();
        racingGameView.printExecutionMessage();
        IntStream.range(0, repeat).forEach(j -> {
            IntStream.range(0, userCars.getCarsLength()).mapToObj(i ->
                    userCars.getCars().get(i)).forEach(RacingGameController::randomNumber);
            displayGameProcessing(userCars);
        });
        displayGameResult(userCars);
    }

    public Cars createCars(){
        racingGameView.printGameStartMessage();
        return createRacingCars();
    }

    public Integer repeatCount(){
        racingGameView.printRepeatCountMessage();
        return Integer.parseInt(Console.readLine().trim());
    }

    public void displayGameProcessing(Cars cars){
        racingGameView.printGameProcessingMessage(cars);
    }

    public void displayGameResult(Cars cars){
        List<String> winners = RacingGameController.getWinner(cars);
        racingGameView.printGameResultMessage();
        System.out.println(String.join(", ", winners));
    }
}
