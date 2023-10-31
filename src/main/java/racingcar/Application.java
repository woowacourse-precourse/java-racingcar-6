package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringJoiner;

public class Application {
public static void main(String[] args) {

    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    System.out.println("시도할 회수는 몇회인가요?");
    String tryNumber = Console.readLine();

    inputFormatValidation(input);
    tryNumberFormatValidation(tryNumber);

    Map map = splitCars(input);
    System.out.println("실행 결과");
    for (int i = 0; i < Integer.valueOf(tryNumber); i++) {
        resultEachOrder(racingCar(map));
        System.out.println();
    }
    System.out.println(winners(map));

}

static Integer generateNumber() {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
//    System.out.println(randomNumber);
    return randomNumber;
}

static void inputFormatValidation(String input) {
    List<String> cars = Arrays.asList(input.split(","));
//    System.out.println(cars);
    for (String car : cars) {
        if (car.trim().length() > 5) {
            throw new IllegalArgumentException("String index out of range: 5");
//            System.out.println(car.length() + ":" + car);
        }
    }

}

static void tryNumberFormatValidation(String tryNumber) {
    try {
        Integer.parseInt(tryNumber);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("숫자를 입력하시오");
    }


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


static String winners(Map<String, Integer> map) {
    int maxScore = Collections.max(map.values());

    StringJoiner winners = new StringJoiner(", ");

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue().equals(maxScore)) {
            winners.add(entry.getKey());
        }
    }
    String msg = "최종 우승자 : " + winners.toString();

    return msg;

}


}
