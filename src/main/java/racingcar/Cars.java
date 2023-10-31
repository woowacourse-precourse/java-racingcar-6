package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Cars {
    public List<String> Name() {
        String console = Console.readLine();
        List<String> list = List.of(console.split(","));

        for (String s : list) {
            NameLengthCheck(s);
        }
        return list;
    }

    private void NameLengthCheck(String name) {
        try {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
