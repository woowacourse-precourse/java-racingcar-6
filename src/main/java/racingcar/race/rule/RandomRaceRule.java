package racingcar.race.rule;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.model.Car;

public class RandomRaceRule implements RaceRule {

    private final int MOVABLE_LIMIT = 3;
    private final int MIN_RANDOM_RANGE_NUMBER = 0;
    private final int MAX_RANDOM_RANGE_NUMBER = 9;

    private boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_RANGE_NUMBER,
                MAX_RANDOM_RANGE_NUMBER);
        return MOVABLE_LIMIT < randomNumber;
    }

    public void round(List<Car> participantList) {
        for (Car car : participantList) {
            if (isMovable()) {
                car.moveForward();
            }
        }
    }

    private int getWinnersPosition(List<Car> participantList) {
        Collections.sort(participantList, (o1, o2) -> o2.getPosition() - o1.getPosition());

        int winnerPosition = participantList.get(0).getPosition();
        return winnerPosition;
    }

    public List<String> getWinner(List<Car> participantList) {
        int winnerPosition = getWinnersPosition(participantList);

        List<String> winnerList = new ArrayList<>();
        for (Car car : participantList) {
            if (car.getPosition() == winnerPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

}
