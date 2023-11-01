package racingcar.model.race;

public class RaceResult {

    public static void printWinner(Car[] cars) {
        StringBuilder winner = new StringBuilder();

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCarRank() == rankFirst(cars)) {
                String carName = cars[i].getCarName();
                int endIndex = carName.length() - cars[i].getCarRank() - 3;
                winner.append(carName, 0, endIndex).append(", ");
            }
        }

        String winners = winner.substring(0, winner.length() - 2);
        System.out.println("최종 우승자 : " + winners);
    }

    private static int rankFirst(Car[] cars) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < cars.length; i++) {
            int rank = cars[i].getCarRank();
            if (rank > max) {
                max = rank;
            }
        }

        return max;
    }
}
