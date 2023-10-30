package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Strings;
import racingcar.code.ErrorMessage;
import racingcar.code.Message;
import racingcar.utils.PrintUtils;

import java.util.Arrays;

public class Application {

    public static final int MAX_CAR_NAME_SIZE = 5;
    public static void main(String[] args) {
        PrintUtils.print(Message.GAME_START);
        String carNameListInput = Console.readLine();
        validCarName(carNameListInput);
    }

    private static void validCarName(String input) {
        if (Strings.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EMPTY.getDescription());
        }

        // 자동차 이름 예외 처리
        String[] carNameArr = input.split(",");

        // 자동차 이름 정상 입력 체크
        int size = input.length() - input.replace(",", "").length() + 1;
        if (size != carNameArr.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME.getDescription());
        }

        // 자동차 이름 빈값 또는 최대 사이즈 체크
        long invalidCount = Arrays.stream(carNameArr).filter(i -> i.length() > MAX_CAR_NAME_SIZE || i.length() == 0).count();
        if (invalidCount > 0) {
            throw new IllegalArgumentException(ErrorMessage.MAX_CAR_NAME_SIZE_EXCEEDED.getDescription() + MAX_CAR_NAME_SIZE);
        }
    }
}
