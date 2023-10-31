package racingcar.service;

import racingcar.model.RaceCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    public List<RaceCar> createRaceCarObject(List<RaceCar> raceCars, List<String> names) {
        for(String name : names) {
            raceCars.add(new RaceCar(name));
        }
        return raceCars;
    }

    public int randomNumPick() {
        return pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public void MoveForward(RaceCar raceCar, int randomNumber) {
        if(randomNumber >= 4) {
            raceCar.updateMoveForward();
        }
    }
;
    public List<String> gameWinner(List<RaceCar> raceCars) {
        List<RaceCar> sortedRaceCars = raceCars.stream()
                .sorted((a, b) -> b.getMoveForwardCount() - a.getMoveForwardCount())
                .toList();

        return sortedRaceCars.stream()
                .filter(sortedRaceCar -> sortedRaceCar.getMoveForwardCount() == sortedRaceCars.get(0).getMoveForwardCount())
                .map(RaceCar::getName)
                .collect(Collectors.toList());
    }
}