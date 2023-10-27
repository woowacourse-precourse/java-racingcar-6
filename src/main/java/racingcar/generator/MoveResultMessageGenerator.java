package racingcar.generator;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.MoveResult;

public class MoveResultMessageGenerator {

    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String MOVEMENT_BAR = "-";
    public static final String EMPTY_MESSAGE = "";


    // TODO: 의존성 끊기?
    public static String generateMoveResultsMessage(final List<MoveResult> moveResults) {
        return moveResults.stream()
                .map(MoveResultMessageGenerator::createSingleMessage)
                .reduce(EMPTY_MESSAGE, (firstName, secondName) -> firstName + secondName);
    }

    // TODO 리팩토링: 책임분리
    private static String createSingleMessage(final MoveResult moveResult) {
        StringBuilder movementBuilder = new StringBuilder();
        IntStream.range(0, moveResult.getPosition())
                .forEach(value -> movementBuilder.append(MOVEMENT_BAR));
        return String.format(RESULT_FORMAT, moveResult.getName(), movementBuilder);
    }
}
