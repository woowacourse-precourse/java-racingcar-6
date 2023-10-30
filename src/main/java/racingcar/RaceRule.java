package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RaceRule {

    public static final int MOVABLE_LIMIT = 3;

    public static boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return MOVABLE_LIMIT < randomNumber;
    }

    public static void phase(CarRegistration raceParticipants) {
//        List<Car> participantList = raceParticipants.getRaceParticipants();
//        for (Car car : participantList) {
//            if (isMovable()) {
//                car.moveForward();
//            }
//        }
    }
}
