package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Application {
public static void main(String[] args) {

    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    System.out.println("시도할 회수는 몇회인가요?");
    String trynumber = Console.readLine();

    Map map = splitCars(input);

    for (int i = 0; i < Integer.valueOf(trynumber); i++) {
        resultEachOrder(racingCar(map));
    }
    System.out.println(winners(map));

}

static Integer generateNumber() {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
//    System.out.println(randomNumber);
    return randomNumber;
}

static void inputFormatValidation(String input) {
    // 쉼표로 구분, 5자이하

    //
}

static void trynumberFormatValidation(String trynumber) {
    // 숫자가 아닌값은 예외발생
}


static Map splitCars(String input) {
    List<String> cars = Arrays.asList(input.split(","));
    Map map = new HashMap();
    for (String car : cars) {
        map.put(car, 0);
    }
//    System.out.println(map);

    return map;
}


static Map racingCar(Map map) {
    // for문이든, it
    Set set = map.entrySet();
    Iterator it = set.iterator();
    while (it.hasNext()) {
        Map.Entry entry = (Entry) it.next();
        if (generateNumber() >= 4) {
            int value = (int) map.get(entry.getKey());
            map.put(entry.getKey(), value + 1);
        }

    }
    return map;
}


static void resultEachOrder(Map map) {
    Iterator it = map.entrySet().iterator();

    while (it.hasNext()) {
        Map.Entry entry = (Entry) it.next();
        int value = (int) entry.getValue();
        System.out.println(entry.getKey() + " : " + printBar('-', value) + " ");
    }
}

static String printBar(char ch, int value) {
    char[] bar = new char[value];

    for (int i = 0; i < bar.length; i++) {
        bar[i] = ch;
    }
    return new String(bar);
}


static String winners(Map map) {

    Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), comparator);
    String msg = "최종 우승자 : " + maxEntry.getKey();
//    msg += " : " + maxEntry.getValue();
    int bestscore = maxEntry.getValue();
    map.remove(maxEntry.getKey());
    maxEntry = Collections.max(map.entrySet(), comparator);
    while (true) {

        if (bestscore != maxEntry.getValue()) {
            break;
        } else {
            msg += ", " + maxEntry.getKey();
//            msg += " : " + maxEntry.getValue();
            break;

        }

    }

    return msg;
}

// 비교 재정의
static Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
};


}
