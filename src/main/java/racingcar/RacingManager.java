package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private List<RacingCar> racingCars;
    private int moveCount;

    public void initRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        racingCars = createRacingCars(carNamesInput);

        System.out.println("시도할 회수는 몇 회인가요?");
        String moveCountInput = Console.readLine();
        moveCount = parseMoveCountInput(moveCountInput);
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            for (RacingCar racingCar : racingCars) {
                int moveWeight = Randoms.pickNumberInRange(1, 9);
                racingCar.move(moveWeight);
            }
            printCarMoveResult();
        }
    }

    private void printCarMoveResult() {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getForwardCount()));
        }
    }

    public List<RacingCar> createRacingCars(String carNamesInput) {
        validateCarNames(carNamesInput);

        String[] carNames = carNamesInput.split(",");
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    private void validateCarNames(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름들을 입력해주세요.");
        }
    }

    public int parseMoveCountInput(String moveCountInput) {
        validateMoveCount(moveCountInput);
        return Integer.parseInt(moveCountInput);
    }

    private void validateMoveCount(String moveCount) {
        if (moveCount.isEmpty()) {
            throw new IllegalArgumentException("시도할 회수를 입력해주세요.");
        }

        try {
            int count = Integer.parseInt(moveCount);
            if (count <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}
