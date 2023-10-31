package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Judgement {
    public List<String> selectWinners(List<Car> participants) {
        List<String> winners = new ArrayList<>();
        Collections.sort(participants);
        int maxV = participants.get(0).getPosition();
        for (Car participant : participants) {
            if (participant.getPosition() != maxV) {
                break;
            }
            winners.add(participant.getName());
        }
        return winners;
    }

}
