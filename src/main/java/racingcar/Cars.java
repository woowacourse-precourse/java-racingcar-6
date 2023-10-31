package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Cars {
    public List<String> Cars() {
        String console = Console.readLine();
        List<String> list = List.of(console.split(","));
        return list;
    }
}
