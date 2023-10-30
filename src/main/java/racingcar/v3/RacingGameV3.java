package racingcar.v3;

import racingcar.v2.CreateCarV2;

import java.util.Map;

public class RacingGameV3 {
    private final CreateCarV2 createCar;
    private final ForwardV3 forward;
    private final RacingV3 racing;

    public RacingGameV3() {
        this.createCar = new CreateCarV2();
        this.forward = new ForwardV3();
        this.racing = new RacingV3();
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
