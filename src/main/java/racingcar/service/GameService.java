package racingcar.service;

import racingcar.model.RaceCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;
    private final List<RaceCar> raceCars = new ArrayList<>();

    public void createRaceCarObject(List<String> names) {
        for(String name : names) {
            RaceCar raceCar = new RaceCar(name);
            raceCars.add(raceCar);
        }
    }

    public List<RaceCar> MoveForward() {
        for(RaceCar raceCar : raceCars) {
            int randomNumber = pickNumberInRange(MIN_NUM, MAX_NUM);

            if(randomNumber >= 4) {
                raceCar.updateMoveForward();
            }
        }
        return raceCars;
    }

    public List<String> gameWinner() {
        List<RaceCar> sortedRaceCars = raceCars.stream()
                .sorted((a, b) -> b.getMoveForwardCount() - a.getMoveForwardCount())
                .toList();

        return sortedRaceCars.stream()
                .filter(sortedRaceCar -> sortedRaceCar.getMoveForwardCount() == sortedRaceCars.get(0).getMoveForwardCount())
                .map(RaceCar::getName)
                .collect(Collectors.toList());
    }
}