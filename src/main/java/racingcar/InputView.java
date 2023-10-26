package racingcar;

import static java.util.Arrays.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<String> inputCarName() {
        String[] carNamesSplit;
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();
            carNamesSplit = carNames.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        List<String> collect = stream(carNamesSplit).collect(Collectors.toList());
        return collect;

    }

    public static int inputNum() {
        System.out.println("시도할 회수는 몇회인가요?");

        int num;
        try {
            String number = Console.readLine();
            num = Integer.parseInt(number);
        } catch (Exception e1) {
            throw new IllegalArgumentException();
        }

        return num;

    }
}
