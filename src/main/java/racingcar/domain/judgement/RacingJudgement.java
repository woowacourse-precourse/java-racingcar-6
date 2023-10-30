package racingcar.domain.judgement;

import static java.util.stream.Collectors.joining;

import java.util.Comparator;
import java.util.List;
import racingcar.domain.car.Car;

/**
 * 게임에 참여하는 심판의 개념 객체를 나타내는 클래스입니다.
 */
public class RacingJudgement implements Judgement {
        /**
         * getWinner 루 부터 반환받은 우승자 이름 문자열을 콘솔에 출력합니다.
         *
         * @param carList 자동차 리스트
         */
        @Override
        public void announcementWinner(List<Car> carList) {
                System.out.println("최종 우승자 : " + getWinner(carList));
        }

        /**
         * 경기의 우승자 이름을 문자열로 반환합니다.
         * 만약 우승자가 다수라면 ,를 구분자로 하여 문자열을 반환합니다.
         *
         * @param carList 자동차 리스트
         * @return 우승자 이름 문자열
         */
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
