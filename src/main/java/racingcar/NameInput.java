package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInput {

//    static String[] nameArr;
    static List<String> nameArr;

    static void getNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        nameArr = Arrays.asList(input.split(","));
    }

    static void checkNameInput() throws IllegalArgumentException {
        for (String name: nameArr) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    static List<Car> setNameInput() {
        int n = nameArr.size();
        List<Car> carArr = new ArrayList<Car>();
        for (int idx = 0; idx < n; idx++) {
            carArr.add(new Car(nameArr.get(idx), 0));
        }
        return carArr;
    }

    public static List<String> getNameArr() {
        return nameArr;
    }

    public static void setNameArr(List<String> nameArr) {
        NameInput.nameArr = nameArr;
    }
}
