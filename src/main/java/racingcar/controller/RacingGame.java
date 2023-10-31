package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    Game game;
    List<Car> carList;

    public void startGame(){
        game = new Game(InputView.inputCalNames(), InputView.inputRepetitions());

        carList=game.getCar();

        OutputView.printResultText();

        for(int i=0;i< game.getRepetitions();i++){
            playGame();
            OutputView.printResult(carList);
        }
        OutputView.printWinner(calcWinner());
    }

    public void playGame(){
        carList.forEach(Car::movePosition);
    }

    public List<String> calcWinner(){
        int maxScore = getWinnerScore();
        return carList.stream()
                .filter(car -> car.getScore().length()==maxScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getWinnerScore() {
        int max=0;
        for(Car c:carList){
            max=Math.max(c.getScore().length(), max);
        }
        return max;
    }
}