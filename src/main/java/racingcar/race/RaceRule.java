package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.CarRegistration;
import racingcar.car.model.Car;

public class RaceRule {

    private static final int MOVABLE_LIMIT = 3;
    private static final int MIN_RANDOM_RANGE_NUMBER = 0;
    private static final int MAX_RANDOM_RANGE_NUMBER = 9;

    public static boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_RANGE_NUMBER,
                MAX_RANDOM_RANGE_NUMBER);
        return MOVABLE_LIMIT < randomNumber;
    }

    public static void phase(CarRegistration raceParticipants) {
        List<Car> participantList = raceParticipants.getRaceParticipants();
        for (Car car : participantList) {
            if (isMovable()) {
                car.moveForward();
            }
        }
    }

    private static int getWinnersPosition(List<Car> participantList) {
        Collections.sort(participantList, (o1, o2) -> o2.getPosition() - o1.getPosition());

        int winnerPosition = participantList.get(0).getPosition();
        return winnerPosition;
    }

    public static List<String> getWinner(CarRegistration raceParticipants) {
        List<Car> participantList = raceParticipants.getRaceParticipants();
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
