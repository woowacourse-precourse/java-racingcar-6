package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDTO;

public class EndScreen {
    private static final String WINNER_IS = "최종 우승자 : ";
    private static final String WINNER_SEPARATOR = ", ";
    public static void printWinner(List<CarDTO> winners){
        String winnerNames = winners.stream()
                .map(CarDTO::getName)
                .collect(Collectors.joining(WINNER_SEPARATOR));
        System.out.println(WINNER_IS + winnerNames);
    }
}
