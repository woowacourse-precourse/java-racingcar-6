package racingcar.service;

import racingcar.domain.Players;
import racingcar.domain.RacingCar;
import racingcar.dto.RacingStatusDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCarService {

    private Players players;

    public int generateRacingCar(Set<String> carNameSet) {
        players = new Players(generate(carNameSet));
        return players.size();
    }

    private static List<RacingCar> generate(Set<String> carNameSet) {
        return carNameSet.stream().map(carName -> new RacingCar(carName))
                .collect(Collectors.toList());
    }

    public List<List<RacingStatusDTO>> racing(int cycle) {
        List<List<RacingStatusDTO>> allRacingStatus = new ArrayList<>();

        for (int i = 0; i < cycle; i++) {
            allRacingStatus.add(players.processRacing());
        }

        return allRacingStatus;
    }

    public List<String> judgeWinners() {
        return players.findWinners();
    }

}
