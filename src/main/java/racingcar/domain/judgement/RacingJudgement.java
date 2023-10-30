package racingcar.domain.judgement;

import static java.util.stream.Collectors.joining;

import java.util.Comparator;
import java.util.List;
import racingcar.domain.car.Car;

public class RacingJudgement implements Judgement {
        @Override
        public void announcementWinner(List<Car> carList) {
                System.out.println("최종 우승자 : " + getWinner(carList));
        }

        private String getWinner(List<Car> carList) {
                Car winner = carList.stream()
                        .max(Comparator.comparingLong(Car::getDrivenDistance))
                        .orElseThrow();

                return carList.stream()
                        .filter(car -> car.getDrivenDistance() == winner.getDrivenDistance())
                        .map(Car::getName)
                        .collect(joining(","));
        }
}
