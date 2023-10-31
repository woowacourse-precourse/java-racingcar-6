package racingcar;

import static racingcar.constant.OutputMessage.WINNER_RESULT;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.PerGameCarResultDto;

public class View {

    public void println(String input) {
        System.out.println(input);
    }

    public void printResult(List<PerGameCarResultDto> resultDtos) {
        for (PerGameCarResultDto resultDto : resultDtos) {
            String moveResult = new String(new char[resultDto.moveCnt()]).replace('\0', '-');
            System.out.println(resultDto.carName() + " : " + moveResult);
        }
        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));
        System.out.println(WINNER_RESULT + winnerNames);
    }

}
