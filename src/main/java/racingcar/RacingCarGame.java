package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> cars = new ArrayList<RacingCar>();
    private InputValidator inputValidator = new InputValidator();

    public void setRacingCarsByConsole() {
        String line = readLine();
        inputValidator.setRacingCars(line);
        String[] split = line.split(",");
        for (int i = 0; i < split.length; i++) {
            cars.add(new RacingCar(split[i]));
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}
