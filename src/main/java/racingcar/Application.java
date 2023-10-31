package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static void checkCarNames(String[] inputNames){
        for(String name: inputNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int checkTurn(String turnInput){
        try {
            return Integer.parseInt(turnInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputs = Console.readLine().split(",");
        checkCarNames(inputs);      // 예외 처리

        // 2. 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String turnInput = Console.readLine();
        int turns = checkTurn(turnInput);       // 예외 처리 및 횟수 값
    }
}
