package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.UserInput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력값
        UserInput input = inputUser();
    }

    //1) 사용자 입력 처리 기능
    static UserInput inputUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(Console.readLine());

        return new UserInput(carName, gameCount);
    }
}




