package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printWinner(List<CarDto> winners) {
        String result = winners.stream()
                .map(c -> c.name())
                .collect(Collectors.joining(", ", "최종 우승자 : ", ""));
        System.out.println(result);
    }
}
