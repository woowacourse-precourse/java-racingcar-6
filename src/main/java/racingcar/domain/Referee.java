package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Referee {

    public static void simulate(RacingCars racingcars) {

        for (int i = 0; i < racingcars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                racingcars.get(i).move();
            }
        }

    }

    public static RacingCars calculateWinner(RacingCars racingcars) {
        int farthest = racingcars.farthestDistance();
        RacingCars result = new RacingCars();
        for (int i = 0; i < racingcars.size(); i++) {
            if (racingcars.get(i).getDistance() == farthest) {
                result.add(racingcars.get(i));
            }
        }
        return result;
    }
}
