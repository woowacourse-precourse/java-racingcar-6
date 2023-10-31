package racingcar.view.core;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class InputView extends ConsoleWriter {

    public List<String> readParticipantCarNames() {
        this.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        final var input = Console.readLine();

        return Arrays.stream(input.split(",")).toList();
    }

    public int readExtractLapCount() {
        this.println("시도할 회수는 몇회인가요?");

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
