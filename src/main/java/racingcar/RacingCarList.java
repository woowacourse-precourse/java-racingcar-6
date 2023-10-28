package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private List<RacingCar> racingCarsList = new ArrayList<>();
    private final User user;
    private final RacingCar racingCar;

    public RacingCarList(User user, RacingCar racingCar) {
        this.user = user;
        this.racingCar = racingCar;
    }

    public List<RacingCar> getRacingCarList() {
        enrollNewRacingCar();
        return racingCarsList;
    }

    private void enrollNewRacingCar() {
        createNewRacingCar();
    }

    private void createNewRacingCar() {
        String[] carNames = getCarNamesFromUser();
        for (String carName : carNames) {
            racingCarsList.add(racingCar.createNewCar(carName));
        }
    }

    private String[] getCarNamesFromUser() {
        return user.inputCarNames();
    }
}
