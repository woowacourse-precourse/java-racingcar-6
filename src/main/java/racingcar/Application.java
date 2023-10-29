package racingcar;

import racingcar.input.Name;
import racingcar.input.Count;
import racingcar.race.Compare;
import racingcar.race.Race;

import java.util.Arrays;
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
            race.printRace();
        }
        System.out.println(race.savePositionInList().toString());
        Compare compare = new Compare();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int max = compare.saveMaxPosition(list);
        System.out.println(list.contains(1));
        System.out.println(max);
    }
}
