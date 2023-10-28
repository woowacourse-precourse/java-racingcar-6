package racingcar;

import racingcar.input.Name;
import racingcar.input.Count;
import racingcar.race.Race;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Name name = new Name();
        Count count = new Count();
        Race race = new Race();
        List<String> names = name.carName(name.inputName());
        race.saveName(names);
        int num = count.raceCount(count.inputCount());
        for (int i = 0; i < num; i++) {
            race.goFoward();
        }
        System.out.println(names.toString() + num);
    }
}
