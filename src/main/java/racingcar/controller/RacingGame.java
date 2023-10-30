package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.util.Constant;
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
        calcAndPrintWinner();
    }

    public void playGame(){
        carList.forEach(this::movePosition);
    }

    public void movePosition(Car car){
        if (Randoms.pickNumberInRange(Constant.RANDOM_MINIMUM, Constant.RANDOM_MAXIMUM) > Constant.RANDOM_BOUNDARY) {
            car.addScore();
            updateWinnerPosition(car.getScore());
        }
    }

    public void updateWinnerPosition(String newPosition){
        if(game.getWinnerPosition().length()<newPosition.length()){
            game.setWinnerPosition(newPosition);
        }
    }

    public void calcAndPrintWinner(){
        List<String> winnerList = carList.stream()
                .filter(car -> isWinner(car, game))
                .map(Car::getName)
                .collect(Collectors.toList());
        OutputView.printWinner(winnerList);
    }

    public boolean isWinner(Car car, Game game) {
        return car.getScore().length() == game.getWinnerPosition().length();
    }

}