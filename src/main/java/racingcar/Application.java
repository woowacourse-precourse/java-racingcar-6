package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        input = input.trim();

        String[] values = input.split(",");

        for (String value : values) {
            if (value.trim().length() > 5) {
                throw new IllegalArgumentException("길이가 5 이상인 값이 감지되었습니다: " + value);
            }
        }
    }
}
