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
        String[] carNames = user.inputCarNames();
        for (String carName : carNames) {
            racingCarsList.add(racingCarCreator.createNewCar(carName));
        }
        return racingCarsList;
    }
}
