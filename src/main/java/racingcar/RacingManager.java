package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private List<RacingCar> racingCars;

    public void initRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        racingCars = createRacingCars(carNamesInput);
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
}
