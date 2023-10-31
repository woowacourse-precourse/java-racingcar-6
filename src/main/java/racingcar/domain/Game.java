package racingcar.domain;

import racingcar.common.Converter;
import racingcar.common.InputValidator;
import racingcar.common.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private static final int FORWARD_NUM = 1;
    private static final int FORWARD_LIMIT = 4;

    private InputValidator inputValidator = new InputValidator();
    private static Map<String, Integer> cars;
    private static int gameCount;

    public void gameStart(){

        gameInput();
        gameResult();

        String winner = findWinner(cars);
        OutputView.winnerView(winner);
    }

    private void gameInput(){
        cars = Converter.stringToMap(InputView.inputCarName());
        inputValidator.carNameValidator(cars);
        String inputGameCount = InputView.inputGameCount();
        gameCount = inputValidator.gameCountValidator(inputGameCount);
    }

    private void gameResult(){
        OutputView.gameResultStart();
        while(gameCount>0){
            cars.replaceAll((name, distance) -> forward(RandomNumberGenerator.generateRandomNumber(), distance));
            OutputView.gameResult(cars);
            gameCount--;
        }
    }


    private boolean isForwardAllowed(int number){
        return number >= FORWARD_LIMIT;
    }

    private int forward(int randomNumber, int distance){
        if(isForwardAllowed(randomNumber)) return distance + FORWARD_NUM;
        return distance;
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
