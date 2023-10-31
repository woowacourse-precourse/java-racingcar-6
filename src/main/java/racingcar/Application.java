package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Executor executor = new Executor();
        InputManager inputManager = new InputManager();
        List<String> winner;
        
        // 1-1. 입력: 자동차 이름 초기화
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = inputManager.makeCars();
        // 1-2. 입력: 게임 횟수
        System.out.println("시도할 회수는 몇 회인가요?");
        int num = inputManager.howMany();
        
        System.out.println();
        
        // 2. 게임 진행, 진행 중 진행 상황 출력
        while(num != 0) {
            executor.doGame(cars);
            num -= 1;
        }
        
        // 3. 게임 완료 후 비교, 출력
        winner = executor.findWinner(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winner));

        Console.close();
    }
}
