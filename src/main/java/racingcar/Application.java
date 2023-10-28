package racingcar;

import racingcar.input.Name;
import racingcar.input.Count;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Name name = new Name();
        Count count = new Count();
        List<String> names = name.carName(name.inputName());
        int num = count.raceCount(count.inputCount());
        System.out.println(names.toString() + num);
    }
}
