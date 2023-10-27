package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputUser();
    }

    //1) 사용자 입력처리 기능
    static void inputUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        //입력값 검증 호출
        validateInput(carName);
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(Console.readLine());
    }

    //2) 사용자 입력에 대한 예외처리
    static void validateInput(String carName) throws IllegalArgumentException {
        //1) 각 이름 길이 5초과 시 예외
        for (String x : carName.split(",")) {
            if (x.length() > 5) {
                throw new IllegalArgumentException("경주할 자동차 이름의 길이는 5이하여야 합니다.");
            }
        }
        //2) 각 이름에 " " 공백 포함 시 예외
        for (String x : carName.split(",")) {
            if (x.contains(" ")) {
                throw new IllegalArgumentException("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
            }
        }
    }

}