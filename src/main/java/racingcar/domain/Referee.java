package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Referee {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int PROBABILITY = 4;

    public static void simulate(RacingCars racingcars) {

        for (int i = 0; i < racingcars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (randomNumber >= PROBABILITY) {
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
