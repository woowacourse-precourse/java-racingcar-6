package racingcar.domain;

import racingcar.common.Converter;
import racingcar.common.InputValidator;
import racingcar.common.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Map;
import java.util.stream.Collectors;

public class Game {

    private static Map<String, Integer> cars;
    private static int gameCount;

    public void gameStart(){
        gameInput();
        gameResult();

        String winner = findWinner(cars);
        OutputView.winnerView(winner);
    }

    private void gameInput(){
        User user = new User();
        cars = user.getCars(InputView.inputCarName());
        gameCount = user.getGameCount(InputView.inputGameCount());
    }

    private void gameResult(){
        OutputView.gameResultStart();

        Car car = new Car();
        while(gameCount>0){
            cars.replaceAll((name, distance) -> car.forward(RandomNumberGenerator.generateRandomNumber(), distance));
            OutputView.gameResult(cars);
            gameCount--;
        }
    }

    private String findWinner(Map<String, Integer> cars){
        int max = cars.values().stream().max(Integer::compareTo).get();

        return cars.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(entry -> entry.getKey())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
