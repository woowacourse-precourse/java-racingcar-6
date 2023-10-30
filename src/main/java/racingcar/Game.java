package racingcar;

import java.util.List;

public class Game {
    private List<Car> cars;
    private int maxRoundCount;

    public void initialize() {
        settingCar();
        settingRound();
    }

    private void settingRound() {
        PromptHandler.promptOutput(GameMessage.ASK_ROUND_COUNT.getMessage());
        maxRoundCount = PromptHandler.promptInputRoundCount();
    }

    private void settingCar() {
        PromptHandler.promptOutput(GameMessage.ASK_CARS_NAME.getMessage());
        String[] carsName = PromptHandler.promptInputCarsName();
    }

    private String[] askCarsName() {
        PromptHandler.promptOutput(GameMessage.ASK_CARS_NAME.getMessage());

        return PromptHandler.promptInputCarsName();
    }
}
