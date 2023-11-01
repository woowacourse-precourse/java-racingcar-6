package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Racing {
    private List<Car> cars;
    private Integer iterNum;
    private int threshold;
    private static NumberGenerator numberGenerator;

    public Racing(List<Car> cars, Integer iterNum, Integer threshold) {
        this.cars = cars;
        this.iterNum = iterNum;
        this.threshold = threshold;
        numberGenerator = NumberGenerator.getInstance();
    }
    public void run() {
        System.out.println("실행 결과");
        for (int i=0; i<iterNum; i++) {
            tick();
            printState();
        }
        printWinners();
    }

    private void tick() {
        for (Car car : cars) {
            if (numberGenerator.createRandomGenerator() >= threshold) {
                car.move();
            }
        }
    }

    private void printState() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i=0; i< car.getDist(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    private void printWinners() {
        List<Car> winners = getWinners();
        StringJoiner joiner = new StringJoiner(", ");
        for (Car winner : winners) {
            joiner.add(winner.getName());
        }
        String winnersToStr = "최종 우승자 : " + joiner.toString();
        System.out.println(winnersToStr);
    }

    private List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDist = getMaxDist();
        for (Car car : cars) {
            if (maxDist == car.getDist()) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxDist() {
        int max = 0;
        for (Car car : cars) {
            int dist = car.getDist();
            if (dist > max) {
                max = dist;
            }
        }
        return max;
    }
}
