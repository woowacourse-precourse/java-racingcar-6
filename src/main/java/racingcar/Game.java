package racingcar;

import java.util.List;

public class Game {
    private RacingCars cars;
    private int maxRoundCount;

    public void initialize() {
        settingCar();
        settingRound();
    }

    public boolean isProcess(int currentRound) {
        return currentRound <= maxRoundCount;
    }

    public void play() {
        cars.move();
    }

    public String getTotalExecuteResult() {
        return cars.getTotalExecuteResult();
    }

    public List<String> getWinner() {
        return cars.getWinner();
    }

    private void settingRound() {
        PromptHandler.promptOutput(GameMessage.ASK_ROUND_COUNT.getMessage());
        maxRoundCount = PromptHandler.promptInputRoundCount();
        validateRoundCount(maxRoundCount);
    }

    private void settingCar() {
        String[] carsName = askCarsName();
        cars = new RacingCars(carsName);
    }

    private String[] askCarsName() {
        PromptHandler.promptOutput(GameMessage.ASK_CARS_NAME.getMessage());

        return PromptHandler.promptInputCarsName();
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount < GameConfig.MIN_ROUND_COUNT.getValue()) {
            throw new IllegalArgumentException("잘못된 라운드 수입니다.");
        }
    }
}
