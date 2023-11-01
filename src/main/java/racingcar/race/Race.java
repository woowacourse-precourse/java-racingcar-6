package racingcar.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.model.Car;
import racingcar.race.rule.RaceRule;
import racingcar.car.CarRegistration;

public class Race {
    private final CarRegistration raceParticipants;
    private final RoundCount roundCount;
    private final RaceRule raceRule;

    public Race(CarRegistration raceParticipants, RoundCount roundCount, RaceRule raceRule) {
        this.raceParticipants = raceParticipants;
        this.roundCount = roundCount;
        this.raceRule = raceRule;
    }

    private void roundProceed() {
        for (Car car : raceParticipants.getList()) {
            if (raceRule.isMovable()) {
                car.moveForward();
            }
        }
    }

    private int getWinnersPosition(List<Car> participantList) {
        Collections.sort(participantList, (o1, o2) -> o2.getPosition() - o1.getPosition());

        int winnerPosition = participantList.get(0).getPosition();
        return winnerPosition;
    }

    private List<String> getWinner(List<Car> participantList) {
        int winnerPosition = getWinnersPosition(
                participantList);

        List<String> winnerList = new ArrayList<>();
        for (Car car : participantList) {
            if (car.getPosition() == winnerPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private void roundResultPrint(List<Car> raceParticipants) {
        for (Car car : raceParticipants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void winnerPrint(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winnerList));
    }

    public void start() {
        while (roundCount.isRemained()) {
            roundProceed();
            roundResultPrint(raceParticipants.getList());
            roundCount.decreaseCount();
        }
        winnerPrint(getWinner(raceParticipants.getList()));
    }


    @Override
    public String toString() {
        return "Race{" +
                "raceParticipants=" + raceParticipants +
                ", roundCount=" + roundCount +
                '}';
    }
}
