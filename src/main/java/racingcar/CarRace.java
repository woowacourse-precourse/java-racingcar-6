package racingcar;

import java.util.StringJoiner;

public class CarRace {

    public static int calculateMaxDistance(Car car) {
        int maxDistance = 0;

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance <= car.movedDistances.get(i).length()) {
                maxDistance = car.movedDistances.get(i).length();
            }

        }

        return maxDistance;
    }

    public static StringJoiner findWinner(Car car, int maxDistance) {
        System.out.print("최종 우승자 : ");
        StringJoiner winner = new StringJoiner(", ");

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance == car.movedDistances.get(i).length()) {
                winner.add(car.names.get(i));
            }

        }

        return winner;
    }

    public static void printWinner(StringJoiner winner) {
        System.out.println(winner);
    }
}
