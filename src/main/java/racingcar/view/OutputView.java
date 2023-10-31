package racingcar.view;

import racingcar.domain.RaceResultDTO;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String NAME_POSITION_SEPARATOR_MESSAGE = " : ";
    private static final String ONE_STEP_MESSAGE = "-";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_SEPARATOR_MESSAGE = ", ";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void printRaceResult(RaceResultDTO raceResultDTO) {
        var names = raceResultDTO.names();
        var positions = raceResultDTO.positions();
        IntStream.range(0, names.size())
                .forEach(index -> printNameAndPosition(names.get(index), positions.get(index)));
        System.out.println();
    }

    private void printNameAndPosition(String name, int position) {
        printName(name);
        System.out.print(NAME_POSITION_SEPARATOR_MESSAGE);
        printPosition(position);
    }

    private void printName(String name) {
        System.out.print(name);
    }

    private void printPosition(int position) {
        while (position-- > 0) {
            System.out.print(ONE_STEP_MESSAGE);
        }
        System.out.println();
    }

    public void printWinners(List<String> names) {
        System.out.print(FINAL_WINNER_MESSAGE);
        String winners = String.join(WINNER_SEPARATOR_MESSAGE, names);
        System.out.println(winners);
    }
}