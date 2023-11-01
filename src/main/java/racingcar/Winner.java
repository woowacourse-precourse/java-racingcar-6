package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private static final String EXCEPTION_MESSAGE = "최종 우승자: ";



    private void calculateFinalWinner(){
        // 각 자동차의 최대 거리를 비교해서 최대 우승자를 선정하는 메서드
    }
    private void onlyOneWinnerOrNot() {
        // 최종 우승자가 한명인지 다수인지 판단하는 기능 메서드
    }


    public List<String> decideWinners() {
        cars.sort(Comparator.comparing(Car::getPosition).reversed());
        final int winnerPosition = cars.get(0).getPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        System.out.println(GAME_WINNER_MESSAGE + String.join(", ", searchWinners()));
    }
}
