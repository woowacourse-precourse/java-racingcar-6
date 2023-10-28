package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Refree {

    public static void simulate(RacingCars racingcars) {

        for (int i = 0; i < racingcars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            racingcars.get(i).move();
        }

    }

    public static RacingCars calculateWinner(RacingCars racingcars) {
        return new RacingCars();
    }
}
