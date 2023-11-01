package racingcar.v2;

import java.util.Map;

public class RacingGameV2 {
    private final CreateCarV2 createCar;
    private final ForwardV2 forward;
    private final RacingV2 racing;

    public RacingGameV2() {
        this.createCar = new CreateCarV2();
        this.forward = new ForwardV2();
        this.racing = new RacingV2();
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
