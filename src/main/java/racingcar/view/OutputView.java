package racingcar.view;

import racingcar.domain.dto.RunningCarDto;
import racingcar.domain.dto.WinnerDto;
import racingcar.util.StringManipulator;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INTRODUCE_WINNER = "최종 우승자 : ";
    private static final String RACING_RESULT = "\n실행 결과";

    public void notifyResultRotate() {
        System.out.println(RACING_RESULT);
    }

    public void notifyCarRunning(List<RunningCarDto> runningCarDtos) {
        runningCarDtos.stream()
                .map(runningCarDto -> runningCarDto.name() + " : " + "-".repeat(runningCarDto.location()))
                .forEach(System.out::println);

        System.out.println();
    }

    public void notifyWinner(List<WinnerDto> winners) {
        System.out.print(INTRODUCE_WINNER);

        List<String> resultWinner = winners.stream()
                .map(WinnerDto::name)
                .collect(Collectors.toList());

        System.out.println(StringManipulator.join(resultWinner));
    }
}