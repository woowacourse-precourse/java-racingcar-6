package racingcar.utility;

import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class RankingComputer {

    private static int maxValue;
    private static Winners winners;

    public static Winners computeWinners(Cars cars) {
        maxValue = 0;

        for (int i = 0; i < cars.size(); i++) {
            maxValue = computeIfBiggerThanMaxValue(cars.get(i).getPosition());
        }

        winners = new Winners();

        for (int i = 0; i < cars.size(); i++) {
            addWinners(cars.get(i).getPosition(), cars.get(i).getName());
        }

        return winners;
    }

    private static int computeIfBiggerThanMaxValue(int position) {
        if (position > maxValue) {
            return position;
        }

        return maxValue;
    }

    private static void addWinners(int position, String name) {
        if (position == maxValue) {
            winners.addWinner(name);
        }
    }

}
