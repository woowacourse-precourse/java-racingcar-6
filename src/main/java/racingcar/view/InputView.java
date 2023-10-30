package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRIAL_NUMBER_GUIDE = "시도할 회수는 몇 회 인가요?";

    public static String carNames() {
        System.out.println(CAR_NAME_GUIDE);
        String carNames = scanner.nextLine();

        //자동차 이름이 비어 있는 경우
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
        //자동차 이름이 5자 이하인지 확인
        String[] carNameList = carNames.split(",");
        if (carNameList.length > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        return carNames;
    }

    public static int trialNumber() {
        System.out.println(TRIAL_NUMBER_GUIDE);
        int trialNumber = scanner.nextInt();

        //시도할 회수가 0보다 작은 경우
        if (trialNumber < 0) {
            throw new IllegalArgumentException("시도할 회수는 0보다 커야 합니다.");
        }
        return trialNumber;
    }


}
