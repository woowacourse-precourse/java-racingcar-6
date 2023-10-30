package racingcar.v2;

import java.util.Map;

public class RacingGame {
    private final CreateCar createCar;
    private final Forward forward;
    private final Racing racing;

    public RacingGame() {
        this.createCar = new CreateCar();
        this.forward = new Forward();
        this.racing = new Racing();
    }

    public void start() {
        String input = createCar.input();
        String[] carNames = createCar.carName(input);
        Map<String, Integer> stateMap = createCar.stateMap(carNames);
        int round = racing.Round();
        for (int i = 0; i < round; i++) {
            for (String carName : stateMap.keySet()) {
                forward.updatePosition(stateMap, carName);
            }
            racing.printState(stateMap);
        }
        String winner = racing.findWinner(stateMap);
        racing.printWinner(winner);
    }
}
