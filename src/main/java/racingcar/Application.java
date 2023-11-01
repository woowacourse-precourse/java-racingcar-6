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
import java.util.stream.Collectors;

public class Application {
public static void main(String[] args) {

    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    System.out.println("시도할 회수는 몇회인가요?");
    String tryNumber = Console.readLine();

    inputFormatValidation(input);
    tryNumberFormatValidation(tryNumber);

    Map map = carsToMap(splitCars(input));
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
    List<String> cars = splitCars(input);
    if (cars.isEmpty()){
        throw new IllegalArgumentException("자동차 이름을 입력하시오");
    }

    for (String car : cars) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이내로 입력되어야 합니다");
//            System.out.println(car.length() + ":" + car);
        }
        if (car.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있으면 안됩니다");
        }
        if (car.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다");
        }
    }

}

static void tryNumberFormatValidation(String tryNumber) {
    try {
        int numberOfTries = Integer.parseInt(tryNumber);
        if (numberOfTries <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
        }
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("숫자를 입력하시오");
    }


}


static List splitCars(String input) {
    List<String> cars = Arrays.stream(input.split(",")).map(String::trim).filter(name -> !name.isEmpty()).collect(Collectors.toList());
    return cars;
}
static Map carsToMap(List cars){
    Map map = new HashMap();
    for (Object car : cars){
        map.put(car, 0);
    }
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
