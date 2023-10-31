package racingcar.v3;

import racingcar.v2.CreateCarV2;

import java.util.Map;

public class RacingGameV3 {
    private final CreateCar createCar;
    private final ForwardV3 forward;
    private final RacingV3 racing;

    public RacingGameV3() {
        this.createCar = new CreateCar();
        this.forward = new ForwardV3();
        this.racing = new RacingV3();
    }
    // TODO : 들여쓰기 depth 줄이기 현재 3
    public void start() {
        try {
            String input = createCar.input();
            String[] carNames = createCar.splitCarNames(input);
            String[] validatedCarNames = createCar.validateCarNames(carNames);
            Map<String, Integer> stateMap = createCar.stateMap(validatedCarNames);
            int round = racing.Round();
            for (int i = 0; i < round; i++) {
                for (String carName : stateMap.keySet()) {
                    forward.updatePosition(stateMap, carName);
                }
                racing.printState(stateMap);
            }
            String winner = racing.findWinner(stateMap);
            racing.printWinner(winner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}




