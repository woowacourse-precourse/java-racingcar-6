package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Map;
import java.util.stream.Collectors;

public class Game {

    private static final int FORWARD_NUM = 1;
    private static final int FORWARD_LIMIT = 4;

    public void game(){
        // 초기 데이터 설정
        // cars / gameCount
        String inputCarName = InputView.inputCarName();
        Map<String, Integer> cars = Converter.stringToMap(inputCarName);
        InputValidator inputValidator = new InputValidator();
        inputValidator.carNameValidator(cars);

        String inputGameCount = InputView.inputGameCount();
        int gameCount = inputValidator.gameCountValidator(inputGameCount);

        OutputView.gameResultStart();
        while(gameCount>0){
            cars.replaceAll((name, distance) -> forward(RandomNumberGenerator.generateRandomNumber(), distance));
            OutputView.gameResult(cars);
            gameCount--;
        }
        String winner = findWinner(cars);
        OutputView.winnerView(winner);
    }

    private boolean isForwardAllowed(int number){
        return number >= FORWARD_LIMIT;
    }

    public int forward(int randomNumber, int distance){
        if(isForwardAllowed(randomNumber)) return distance + FORWARD_NUM;
        return distance;
    }

    private String findWinner(Map<String, Integer> cars){
        int max = cars.values()
                    .stream()
                    .max(Integer::compareTo).get();

        return cars.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(entry -> entry.getKey())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
