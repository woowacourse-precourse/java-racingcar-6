package racingcar.name;

import java.util.Scanner;

public class Name {
    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carname = scanner.next();
        scanner.close();
        System.out.println("차이름"+carname);
        return String.valueOf(carname);

    }
    public String[] NameList(String wow) {
        return wow.split(",");
    }
}
