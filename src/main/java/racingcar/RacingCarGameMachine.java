package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGameMachine {
    private final RandomNumberGenerator randomNumberGenerator;

    private List<RacingCar> racingCarList = new ArrayList<>();
    private int roundCount;

    public RacingCarGameMachine(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
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
}
