package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WinnerFinder {

    public void printWinner(List<String[]> cars) {
        int max = findMaxLength(cars);
        findWinners(cars, max);
    }

    private int findMaxLength(List<String[]> cars) {
        cars.sort(Comparator.comparingInt(car -> car[1].length()));
        return cars.get(cars.size() - 1)[1].length();
    }

    private void findWinners(List<String[]> cars, int max) {
        List<String> winners = new ArrayList<>();
        for (String[] car : cars) {
            if (car[1].length() == max) {
                winners.add(car[0]);
            }
        }

        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
