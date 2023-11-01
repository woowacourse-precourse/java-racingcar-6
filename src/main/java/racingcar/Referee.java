package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {

    private boolean existWinner = true;

    public List<Integer> saveAllDistances(List<Car> racingCars) {
        List<Integer> distances = new ArrayList<>();
        for (Car car : racingCars) {
            distances.add(car.changeDistanceToInt());
        }
        return distances;
    }

    public int findMaxDistance(List<Integer> distances) {
        return Collections.max(distances);
    }

    public List<String> findWinner(List<Car> racingCars) {
        List<Integer> distances = saveAllDistances(racingCars);
        int maxDistance = findMaxDistance(distances);
        if (maxDistance == 0) {
            existWinner = false;
        }

        List<String> winnerCarNames = new ArrayList<>();
        for (int i = 0; i < racingCars.size(); i++) {
            Car car = racingCars.get(i);
            if (car.changeDistanceToInt() == maxDistance) {
                winnerCarNames.add(car.getName());
            }
        }
        return winnerCarNames;
    }

    public void printWinner(List<String> winnerCarNames) {
        if (existWinner) {
            System.out.print("최종 우승자 : ");
            System.out.println(String.join(", ", winnerCarNames));
        }
        if (!existWinner) {
            System.out.println("아무도 출발하지 않았습니다.");
        }
    }

}