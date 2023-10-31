package racingcar;

import racingcar.domain.Input;
import racingcar.domain.RacingCar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력값을 받을 Input 객체
        Input input = new Input();

        // 경기할 자동차 이름을 입력받고, 경기를 진행할 RacingCar 객체 생성
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        RacingCar racingCar = new RacingCar(input.inputPlayers());

        // 시행 횟수를 입력 받는다
        System.out.println("시도할 회수는 몇회인가요?");
        int num = input.inputNumber();

        // 경기 실행
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            racingCar.run();
            System.out.println();
        }

        // 최종 우승자 출력
        racingCar.printWinner();
    }


}
