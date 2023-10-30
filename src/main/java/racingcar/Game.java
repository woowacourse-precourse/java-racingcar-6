package racingcar;

import java.util.List;

public class Game {
    private List<Car> cars;
    public void initialize() {
        PromptHandler.promptOutput(GameMessage.ASK_CARS_NAME.getMessage());
        String[] carsName = PromptHandler.promptInputCarsName();
    }

}
