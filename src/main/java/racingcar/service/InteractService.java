package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

public class InteractService {

    public static String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static Integer getTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void printResult(List<Car> carList, int tryNum) {
        System.out.println("실행 결과");
        RacingService.racing(carList, tryNum);
        System.out.println("최종 우승자 : " + String.join(", ", RacingService.findWinner(carList)));
    }
}
