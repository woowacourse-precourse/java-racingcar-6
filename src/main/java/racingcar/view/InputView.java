package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public Integer playCount() {
        return  Integer.parseInt(Console.readLine());
    }

    public List<String> carNameList() {
        String name = Console.readLine();
        return Arrays.asList(name.split(","));
    }
}
