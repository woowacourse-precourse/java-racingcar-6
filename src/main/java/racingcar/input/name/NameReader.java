package racingcar.input.name;

import camp.nextstep.edu.missionutils.Console;

public class NameReader {
    public static String[] read() {
        String[] names = Console.readLine().split(",");

        for(String name : names) {
            NameValidator.isValid(name);
        }

        return names;
    }
}
