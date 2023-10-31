package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingClient {

    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRIAL_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private final int trialNumber;
    private final CarGroups carGroups;

    public RacingClient() {
        try (Scanner scanner = new Scanner(System.in)) {
            this.carGroups = inputCarGroups(scanner);
            this.trialNumber = inputTrialNumber(scanner);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private CarGroups inputCarGroups(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = scanner.nextLine();
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        return new CarGroups(carNames);
    }

    private int inputTrialNumber(Scanner scanner) {
        System.out.println(INPUT_TRIAL_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public void run() {
        System.out.println("실행 결과");
        for (int i = 0; i < trialNumber; i++) {
            carGroups.go();
            System.out.println(carGroups);
        }

        System.out.println("최종 우승자 : " + carGroups.getWinners());
    }

}
