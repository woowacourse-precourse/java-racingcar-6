package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Car> cars;
    private int maxRoundCount;

    public void initialize() {
        settingCar();
        settingRound();
    }

    public boolean isProcess(int currentRound) {
        return currentRound <= maxRoundCount;
    }

    public void play() {
        for (Car c : cars) {
            c.move(RandomUtil.getRandomNumber());
        }
    }

    public String getTotalExecuteResult() {
        StringBuilder totalExecuteResult = new StringBuilder();
        for (Car c : cars) {
            totalExecuteResult.append(c.getExecuteResult()).append("\n");
        }

        return totalExecuteResult.toString();
    }

    private void settingRound() {
        PromptHandler.promptOutput(GameMessage.ASK_ROUND_COUNT.getMessage());
        maxRoundCount = PromptHandler.promptInputRoundCount();
    }

    private void settingCar() {
        String[] carsName = askCarsName();
        cars = Arrays.stream(carsName).map(Car::new).collect(Collectors.toList());
    }

    private String[] askCarsName() {
        PromptHandler.promptOutput(GameMessage.ASK_CARS_NAME.getMessage());

        return PromptHandler.promptInputCarsName();
    }
}
