package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;

public class GameController {
    private static ArrayList<String> winners;
    private Integer gameRound;

    public void play() {
        Game game = readyGame();
        startGame();
        endGame();
    }

    public Game readyGame() {
        ArrayList<String> carNames = InputView.inputCarName();
        int gameRound = InputView.inputGameRound();

        return new Game(carNames, gameRound);
    }

    public void startGame() {
        OutputView.printResult();
        while (gameRound-->0) {
            for(Car car : cars) {
                car.move();
                car.showMove();
            }
            System.out.println();
        }
    }

    public void endGame() {
        findWinner();
        OutputView.printWinners();
    }


    public void findWinner(){
        winners = new ArrayList<>();
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car2.getDistance() - car1.getDistance();
            }
        });

        int longDistance = cars.get(0).getDistance();
        for(Car car : cars){
            if(car.getDistance() == longDistance) winners.add(car.getName());
            else break;
        }
    }
}
