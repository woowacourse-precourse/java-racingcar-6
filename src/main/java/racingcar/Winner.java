package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private static List<String> winnerList = new ArrayList<>();


    public Winner() {
    }

    //count 제일 많은 사람 찾아
    public static String whoIsTheWinner(List<Car> cars) {
        int max = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCount() >= max) {
                max = cars.get(i).getCount();
            }
        }

        String winner = makeWinnerList(cars, max);
        return winner;
    }

    private static String makeWinnerList(List<Car> cars, int max) {
        for (int i = 0; i < cars.size(); i++) {
            if (max == cars.get(i).getCount()) {
                winnerList.add(cars.get(i).getName());
            }
        }
        return String.join(", ", winnerList);
    }
}
