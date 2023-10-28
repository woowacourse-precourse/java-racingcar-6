package racingcar.view;

import java.util.List;
import racingcar.domain.dto.CarDTO;

public class EndScreen {
    private static final String WINNER_IS = "최종 우승자 : ";
    private static final String WINNER_SEPARATOR = ", ";
    public static void printWinner(List<CarDTO> winners){
        System.out.print(WINNER_IS);
        winners.forEach(winner -> {
            System.out.print(winner.getName() + WINNER_SEPARATOR);
        });
    }
}
