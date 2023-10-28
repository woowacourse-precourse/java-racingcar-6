package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<String> nameCut(String name) {
        String[] carArray = name.split(",");
        checkName(carArray);
        return List.of(carArray);
    }

    public static void checkName(String[] nameArray) {
        for (String check : nameArray) {
            nameLength(check);
            nameNull(check);
        }
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

    public static int integerTime(String time) {
        timeIsNumber(time);
        timeIsOver0(time);
        return Integer.parseInt(time);
    }

    public static void timeIsNumber(String time) {
        try {
            Integer.parseInt(time);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하십시오");
        }
    }

    public static void timeIsOver0(String time) {
        if (Integer.parseInt(time) < 1) {
            throw new IllegalArgumentException("1회 이상을 입력하십시오");
        }
    }

    public static int random() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void situationPrint(List<String> nameList, int[] goSituation, int i) {
        goSituation[i] = situationSave(goSituation[i], random());
        System.out.print(nameList.get(i) + " : ");
        bar(goSituation[i]);
    }

    public static int situationSave(int goSituation, int random) {
        if (random > 3) {
            goSituation++;
        }
        return goSituation;
    }

    public static void bar(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }


    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        List<String> carName = nameCut(inputName);

        System.out.println("시도할 회수는 몇회인가요?");
        String time = Console.readLine();
        int realTime = integerTime(time);
        Console.close();

        System.out.println("\n실행 결과");
        int[] goSituation = new int[carName.size()];






    }
}
