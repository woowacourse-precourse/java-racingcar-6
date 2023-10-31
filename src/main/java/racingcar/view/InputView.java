package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.TryNumber;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final String NAME_REGEX = "^([\\w]{1,5})+(,([\\w]{1,5})){0,}";

    public static List<String> takeCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Pattern pattern = Pattern.compile(NAME_REGEX);
        String value = Console.readLine();
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        String[] values = value.trim().split(",");
        List<String> carNames = Arrays.stream(values).collect(Collectors.toList());
        return carNames;
    }

    public static TryNumber takeTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new TryNumber(Integer.parseInt(Console.readLine()));
    }
}
