package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.Car;
import racingcar.model.Referee;
import racingcar.view.InputView;

public class Game {
    private final InputView inputView;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";


    public void play() {
        List<Car> cars = inputView.inputCarName();
        int count = inputView.inputCount();

        System.out.println(GAME_RESULT);
        for (int i = 0; i < count; i++) {
           cars.forEach(Car::forward);
           System.out.println();
        }

        List<Car> winners = Referee.getWinner(cars);
        System.out.print(WINNER);
        System.out.println(extractWinnerName(winners));
    }



    private String extractWinnerName(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
