package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static List<String> nameCut(String name) {
        String[] carArray = name.split(",");
        return List.of(carArray);
    }

    public static void nameLength(String check) {
        if (check.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하로 작성해주세요");
        }
    }

    public static void nameNull(String check) {
        if (check.isEmpty()) {
            throw new IllegalArgumentException("공백은 이름이 될 수 없습니다");
        }
    }



    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        List<String> carName = nameCut(inputName);

    }
}
