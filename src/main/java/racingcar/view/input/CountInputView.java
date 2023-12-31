package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CountRequestDto;

public class CountInputView {

    public static CountRequestDto readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return toDto(Console.readLine());
    }

    public static CountRequestDto toDto(String input) {
        CountRequestDto dto = new CountRequestDto();
        dto.setCount(validateNumberFormat(input));
        return dto;
    }

    private static int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
