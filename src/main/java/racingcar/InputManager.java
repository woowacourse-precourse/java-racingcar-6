import java.util.Scanner;

public class InputManager {
    public static String[] getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요 (쉼표로 구분): ");
        String input = scanner.nextLine();
        String[] carNames = input.split(",");
        
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
        
        return carNames;
    }

    public static int getNumberOfAttempts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("시도할 회수를 입력하세요: ");
        try {
            int numberOfAttempts = Integer.parseInt(scanner.nextLine());
            if (numberOfAttempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return numberOfAttempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }
}
