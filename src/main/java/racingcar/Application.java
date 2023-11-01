package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
        String carNamesInput = Console.readLine();
        System.out.println(carNamesInput);
        String[] carNames = carNamesInput.split(","); //입력된 이름은 쉼표(,)로 구분

        validateCarName(carNames);

        // 시도할 횟수 입력 및 검증
        int numberOfAttempts = 0;
        System.out.println("시도할 회수는 몇회인가요?");
        String attemptsInput = Console.readLine(); //시도할횟수 사용자 입력받음
        validateAttempts(attemptsInput); // 유효한 횟수 입력값인지 판단하는 메소드
        numberOfAttempts = Integer.parseInt(attemptsInput); //
        System.out.println(numberOfAttempts);

        Race race = new Race(carNames);
        race.start(numberOfAttempts);
        race.printRaceResult();
    }

    /**
     * 자동차이름 입력시 생길수있는 예외처리(예외발생시 바로종료)
     * @param carNames carName array
     */
    private static void validateCarName(String[] carNames) { //5글자 초과일경우 종료
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("올바른 5글자 이내의 carname을 입력하세요.");
            }
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("올바른 자동차 이름을 입력하세요.");
            }
        }
    }

    /**
     * 횟수 입력시 생길수있는 예외처리(예외발생시 바로종료)
     * @param attemptsInput attempts input array
     */
    private static void validateAttempts(String attemptsInput) {
        int numberOfAttempts;
        try {
            numberOfAttempts = Integer.parseInt(attemptsInput);
        } catch (NumberFormatException e) { //입력된값이 문자인 경우
            throw new IllegalArgumentException("시도횟수는 양의 숫자만 가능합니다.");
        }
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("시도횟수는 양의 숫자만 가능합니다.");
        }

    }
}


