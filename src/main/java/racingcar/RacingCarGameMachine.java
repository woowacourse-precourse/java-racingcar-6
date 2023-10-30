package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGameMachine {
    private final RandomNumberGenerator randomNumberGenerator;

    private List<RacingCar> racingCarList = new ArrayList<>();
    private int curRound = 0;
    private int roundCount;

    public RacingCarGameMachine(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void init(String nameInput, int roundCount) {
        initRacingCar(nameInput);
        this.roundCount = roundCount;
    }

    private void initRacingCar(String nameInput) {
        racingCarList = new ArrayList<>();

        List<String> nameList = parseNameInput(nameInput);
        for (String name : nameList) {
            racingCarList.add(new RacingCar(randomNumberGenerator, name));
        }
    }

    private List<String> parseNameInput(String nameInput) {
        String[] names = nameInput.split(",");
        return Arrays.stream(names).toList();
    }

    public boolean isGameInProgress() {
        return curRound < roundCount;
    }

    private void moveAllRacingCar() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.move();
        }
    }
}
