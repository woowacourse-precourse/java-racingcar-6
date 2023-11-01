package racingcar;

import racingcar.domain.StartCondition;
import racingcar.domain.JudgeMovement;
import racingcar.domain.Result;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StartCondition startCondition = new StartCondition();

        String[] carNames = startCondition.inputCarName();
        int tryCount = startCondition.inputAttemptNumber();

        int carCount = carNames.length;
        int[] positions = new int[carCount];

        JudgeMovement judgeMovement = new JudgeMovement();
        Result result = new Result();

        for (int i = 0; i < tryCount; i++) {
            int[] randomNumbers = judgeMovement.createRandomNumbers(carCount);
            judgeMovement.moveForward(positions, randomNumbers);
            result.printRapResult(carNames, positions);
        }

        result.printWinner(carNames, positions);
    }
}
