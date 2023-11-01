package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private List<String> winners;
    public static final String WINNER_FORMAT = "최종 우승자 : %s";

    void findWinner(List<Car> racingCars){
        int max = racingCars.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElseThrow(() -> new IllegalStateException("자동차 목록이 비어 있습니다."));

        winners = racingCars.stream()
                .filter(car -> car.getMoveCnt() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String getResult(){
        return String.format(WINNER_FORMAT,String.join(", ", winners));
    }

}
