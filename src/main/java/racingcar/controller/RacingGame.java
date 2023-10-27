package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class RacingGame {
    Game game;
    int repetitions=0;
    List<Car> carList;

    public void startGame(){
        game = new Game();

        StringTokenizer st = new StringTokenizer(InputView.inputCalNames());
        while (st.hasMoreTokens()){
            String carName = st.nextToken(",");
            Validator.validateCarLength(carName);
            game.addCar(new Car(carName, ""));
        }
        carList=game.getCar();
        String inputRepetitions = InputView.inputRepetitions();
        Validator.validateIsNumber(inputRepetitions);
        repetitions = Integer.parseInt(inputRepetitions);

        OutputView.printResultText();
        for(int i=0;i<repetitions;i++){
            playGame();
            OutputView.printResult(carList);
        }
        calcAndPrintWinner();
    }

    public void playGame(){
        carList.forEach(this::movePosition);
    }

    public void movePosition(Car car){
        if (Randoms.pickNumberInRange(0, 9) > 4) {
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
