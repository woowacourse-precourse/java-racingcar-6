package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputRacerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        return scanner.nextLine();
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
