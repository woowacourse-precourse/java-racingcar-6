package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1. 사용자로부터 자동차 이름, 시도할 회수 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();
        String[] carNames = inputCarNames.split(",");
//        for(String carName : carNames)
//            System.out.println("carName = " + carName);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = readLine();
        int tryCount = Integer.parseInt(inputTryCount);
//        System.out.println("tryCount = " + tryCount);
    }
}
