package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    List<Car> cars = new ArrayList<>();
    int maxDistance = 0;
    List<String> winners = new ArrayList<>();

    public void makeJudge(List<Car> cars) {
        this.cars = cars;
        findMaxDistance();
        judgeWinners();
        printWinners();
    }

    public void findMaxDistance() {
        for (int i = 0; i < cars.size(); i++) {
            int distance = (cars.get(i)).status.length();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
    }

    public void judgeWinners() {
        for (int i = 0; i < cars.size(); i++) {
            int distance = (cars.get(i)).status.length();
            if (distance == maxDistance) {
                String carName = (cars.get(i)).carName;
                winners.add(carName);
            }
        }
    }

    public void printWinners() {
        System.out.printf("최종 우승자 : ");
        String result = String.join(", ", winners);
        System.out.printf(result);
    }
}
