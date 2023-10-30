package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class RacingCarApplication {

    public RacingCarApplication() {
    }

    public void run() {

        // 중복 체크, 이름에 공백 체크, 5자 이하 체크, 시작 및 끝이 ,로 끝나면 체크 등
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<String> carNames = Arrays.stream(inputCarNames.split(",")).toList();

        Cars cars = Cars.of(carNames);


        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        cars.goForward(attemptCount);



        System.out.println("최종 우승자 : " + cars.getWinningCarNames());
    }
}
