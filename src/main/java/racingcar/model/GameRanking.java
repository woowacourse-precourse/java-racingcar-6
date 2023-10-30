package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class GameRanking {
    private final Map<RacingCar, String> participants;

    public GameRanking(Map<RacingCar, String> participants) {
        this.participants = participants;
    }

    public Map<RacingCar, String> progressRound() {
        for (RacingCar racingCar : participants.keySet()) {
            participants.replace(racingCar, participants.get(racingCar)
                    + racingCar.apply((Randoms.pickNumberInRange(0, 9))).getOutput());
        }
        return Collections.unmodifiableMap(participants);
    }

    public List<RacingCar> getWinner() {
        String winnerScore = participants.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .max(Comparator.comparing(String::length)).get();
        return participants.entrySet()
                .stream()
                .filter(entry -> winnerScore.length() == entry.getValue().length())
                .map(Map.Entry::getKey)
                .toList();
    }


}
