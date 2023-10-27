package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private int carsNum;
    private int tryNum;

    public boolean judgeMoveOrStop(int num) {
        return num >= 4;
    }

    public List<String> judgeWinner(List<Car> cars) {

        List<Integer> totalMoveList = new ArrayList<>();
        cars.forEach(car -> {
            totalMoveList.add(car.getTotalMove());
        });

        // max 값 계산
        int max = totalMoveList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(-1);

        // 우승자 판단
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> {
            if (car.getTotalMove() == max)
                winners.add(car.getName());
        });

        return winners;
    }
}
