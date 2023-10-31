package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarStatusDto;

public class Participant {
    private final List<Car> participant;

    private Participant(List<String> playersList) {
        this.participant = generateParticipant(playersList);
    }

    public static Participant from(List<String> playerList) {
        return new Participant(playerList);
    }

    public void tryProgress() {
        participant.forEach(Car::tryProgress);
    }

    public RacingResult generateResult() {
        return RacingResult.create(generatePlayerStatus());
    }

    private List<CarStatusDto> generatePlayerStatus() {
        return participant.stream()
                .map(Car::sendStatus)
                .toList();
    }

    private static List<Car> generateParticipant(List<String> playerList) {
        List<Car> participantList = new ArrayList<>();
        for (String eachPlayer : playerList) {
            participantList.add(Car.create(eachPlayer));
        }
        return participantList;
    }
}
