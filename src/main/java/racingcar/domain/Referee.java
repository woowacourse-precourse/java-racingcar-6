package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.message.ErrorMessage;

public class Referee {
    private List<String> winners;
    public static final String WINNER_FORMAT = "최종 우승자 : %s";

    void findWinner(List<Car> racingCars){
        int max = racingCars.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.EMPTY_CAR_LIST.getMessage()));

        winners = racingCars.stream()
                .filter(car -> car.getMoveCnt() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String getResult(){
        return String.format(WINNER_FORMAT,String.join(", ", winners));
    }

}
