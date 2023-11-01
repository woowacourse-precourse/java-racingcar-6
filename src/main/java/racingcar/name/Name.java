package racingcar.name;
import racingcar.name.go;
import java.util.Scanner;

public class Name {
    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carname = scanner.nextLine();
        int check = 0;
        if (carname.contains(" ")) {
            System.out.println("자동차 이름을 잘못 입력하셨습니다. 프로그램을 종료합니다.");
        }
        else {
            scanner.close();
            check = 1;
        }
        if (check == 0) {
            return "";
        }
        else {
            return String.valueOf(carname);
        }
    }

    public static String[] validateStringLength(String[] now) {
        if (now.length == 0) {
            throw new IllegalArgumentException("자동차의 이름 또는 시도 회수를 잘못 입력하셨습니다.");
        }
        else {
            return now;
        }
    }

    public String[] NameList(String wow) {
        String[] now = wow.split(",");
        try {
            validateStringLength(now);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return now;
    }
}
