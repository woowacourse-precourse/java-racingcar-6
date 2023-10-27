package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private List<RacingCarCreator> racingCarsList = new ArrayList<>();
    private final User user;
    private final RacingCarCreator racingCarCreator;

    public RacingCarList(User user, RacingCarCreator racingCarCreator) {
        this.user = user;
        this.racingCarCreator = racingCarCreator;
    }

    public List<RacingCarCreator> getRacingCarList() {
        enrollNewRacingCar();
        return racingCarsList;
    }

    private void enrollNewRacingCar() {
        createNewRacingCar();
    }

    private void createNewRacingCar() {
        String[] carNames = getCarNames();
        for (String carName : carNames) {
            racingCarsList.add(racingCarCreator.createNewCar(carName));
        }
    }

    private String[] getCarNames() {
        return user.inputCarNames();
    }
}
