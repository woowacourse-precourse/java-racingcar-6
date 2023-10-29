package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분): ");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        try {
            //자동차 이름의 길이가 5초과이거나, 쉼표(,)로 구분되지 않을때 종료
            for (String carName : carNames) {
                // 자동차 이름이 6글자 이상인 경우 예외 발생 후 프로그램 종료
                validateCarName(carName);
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        // 시도할 횟수 입력 및 검증
        int numberOfAttempts = 0;
        try {
            System.out.print("시도할 회수는 몇회인가요?: ");
            String attemptsInput = Console.readLine();
            validateAttempts(attemptsInput);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    //자동차이름 입력시 생길수있는 예외처리(예외발생시 바로종료)
    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("올바른 5글자 이내의 carname을 입력하세요.");
        }
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("올바른 자동차 이름을 입력하세요.");
        }
    }

    // 횟수 입력시 생길수있는 예외처리(예외발생시 바로종료)
    private static void validateAttempts(String attemptsInput) {
        int numberOfAttempts;
        try {
            numberOfAttempts = Integer.parseInt(attemptsInput);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값은 정수가 아닙니다.");
        }
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("입력된 정수는 양수가 아닙니다.");
        }

    }
}

