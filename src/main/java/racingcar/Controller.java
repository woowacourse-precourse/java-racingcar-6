package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

public class Controller {
    public List<String> getStringList() throws IllegalArgumentException {
        return getStringList(",");
    }

    public List<String> getStringList(final String delimiter) throws IllegalArgumentException {
        try {
            return Stream.of(Console.readLine().split(delimiter)).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getInteger() throws IllegalArgumentException{
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
