package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = RacingUtil.getCarsList();
        int times = RacingUtil.getTimes();

        RacingUtil.raceStart(cars, times);

        List<String> winner = RacingJudge.raceJudge(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
