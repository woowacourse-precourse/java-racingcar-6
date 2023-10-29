package featTest;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.RacingCar;

public class RacingGameManagerTest {
    List<RacingCar> racingCarsList = new ArrayList<RacingCar>();

    class User {
        String runRaceBasedOnInput() {
            return "7";
        }

        String[] inputCarNames() {
            return new String[]{"A", "B", "C", "D"};
        }
    }

    @Test
    void raceCarsTest() {
        // given
        User user = new User();
        String[] carName = user.inputCarNames();
        // when
        for (int i = 0; i < carName.length; i++) {
            racingCarsList.add(new RacingCar(carName[i]));
        }

        // then
        int RacingCount = Integer.parseInt(user.runRaceBasedOnInput());

        for (int i = 0; i < RacingCount; i++) {
            beReadyToForward();
            printCurrentPosition();
            System.out.println();
        }
    }

    void beReadyToForward() {
        for (int i = 0; i < racingCarsList.size(); i++) {
            int movingForwardNumber = Randoms.pickNumberInRange(0, 9);
            if (movingForwardNumber >= 4) {
                racingCarsList.get(i).move();
            }
        }
    }

    void printCurrentPosition() {
        for (RacingCar car : racingCarsList) {
            car.printCurrentPositionWithName();
        }
    }
}