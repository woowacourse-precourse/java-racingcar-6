package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.dto.CarDto;

public class ConsoleOutputView implements OutputView{
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_GAME_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String ROUND_RESULT = "%s : %s";
    private static final String DISTANCE_SYMBOL = "-";
    private static final String NEW_LINE = "\n";
    private static ConsoleOutputView instance;

    private ConsoleOutputView() {}

    public static ConsoleOutputView getInstance() {
        if (instance == null) {
            instance = new ConsoleOutputView();
        }
        return instance;
    }

    @Override
    public void printRequestCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
    }

    @Override
    public void printRequestGameRound() {
        System.out.println(REQUEST_GAME_ROUND_MESSAGE);
    }

    @Override
    public void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    @Override
    public void printRoundResult(List<CarDto> result) {
        for (int i = 0; i < result.size(); i++) {
            CarDto car = result.get(i);
            String name = car.name();
            String position = generatePositionWithSymbol(car.position());
            System.out.printf(ROUND_RESULT + NEW_LINE, name, position);
        }
        System.out.println();
    }

    @Override
    public void printGameWinner(String winner) {
        System.out.print(FINAL_WINNER_MESSAGE + winner);
    }

    private String generatePositionWithSymbol(int position) {
        return Stream.generate(() -> DISTANCE_SYMBOL)
                .limit(position)
                .collect(Collectors.joining());
    }
}
