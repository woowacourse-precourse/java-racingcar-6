package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.car.CarDto;
import racingcar.utils.GameMessage;

public class ConsoleOutputView implements OutputView {
    private static ConsoleOutputView instance;

    private ConsoleOutputView() {
    }

    public static ConsoleOutputView getInstance() {
        if (instance == null) {
            instance = new ConsoleOutputView();
        }
        return instance;
    }

    @Override
    public void printRequestCarNames() {
        System.out.println(GameMessage.REQUEST_CAR_NAMES_MESSAGE.getMessage());
    }

    @Override
    public void printRequestGameRound() {
        System.out.println(GameMessage.REQUEST_GAME_ROUND_MESSAGE.getMessage());
    }

    @Override
    public void printResultMessage() {
        System.out.print(GameMessage.NEW_LINE.getMessage());
        System.out.println(GameMessage.RESULT_MESSAGE.getMessage());
    }

    @Override
    public void printRoundResult(List<CarDto> result) {
        for (int i = 0; i < result.size(); i++) {
            CarDto car = result.get(i);
            String name = car.name();
            String position = generatePositionWithSymbol(car.position());
            System.out.printf(GameMessage.ROUND_RESULT.getMessage(), name, position);
            System.out.print(GameMessage.NEW_LINE.getMessage());
        }
        System.out.print(GameMessage.NEW_LINE.getMessage());
    }

    @Override
    public void printGameWinner(String winner) {
        System.out.print(GameMessage.FINAL_WINNER_MESSAGE.getMessage() + winner);
    }

    private String generatePositionWithSymbol(int position) {
        return Stream.generate(() -> GameMessage.DISTANCE_SYMBOL.getMessage())
                .limit(position)
                .collect(Collectors.joining());
    }
}
