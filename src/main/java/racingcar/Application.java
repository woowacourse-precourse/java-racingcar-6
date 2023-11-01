package racingcar;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = scanner.nextLine();
    }
}
