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
            throw new IllegalArgumentException("입력 문자열에 공백이 포함되어 있습니다.");
        }
        return String.valueOf(carname);
    }

    public String[] NameList(String wow) {
        String[] now = wow.split(",");
        try {
            now = now;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("자동차의 이름 또는 시도 회수를 잘못 입력하셨습니다.");
        }
        return now;
    }
}
