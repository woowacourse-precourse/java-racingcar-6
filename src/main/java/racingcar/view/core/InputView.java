package racingcar.view.core;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class InputView extends ConsoleWriter {

    public List<String> readParticipantCarNames() {
        PrintMessage.PRINT_GAME_START.invoke(this::println);

        final var input = Console.readLine();

        return Arrays.stream(input.split(",")).toList();
    }

    public int readExtractLapCount() {
        PrintMessage.PRINT_TRY_COUNT.invoke(this::println);

        return convertStringToInt(Console.readLine());
    }

    private Integer convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }
}
