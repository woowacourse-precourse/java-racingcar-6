package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Racing racing = new Racing();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        racing.registCars(inputNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = Console.readLine();
        racing.registCount(inputCount);

        System.out.println("실행 결과");

        System.out.print("최종 우승자 : ");
    }
}