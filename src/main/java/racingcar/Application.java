package racingcar;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    private static void validateCarNames(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = scanner.nextLine();
        validateCarNames(carNamesInput);
    }
}
