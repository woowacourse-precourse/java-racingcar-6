package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingGameService;

import java.util.Arrays;
import java.util.List;

public class Input {

    private RacingGameService racingGameService;

    public void start() {
        racingGameService = new RacingGameService(carsName(), tryCount());
        racingGameService.play();
    }

    private List<String> carsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] split = input.split(",");
        if(Arrays.stream(split).anyMatch(s -> s.length() > 5))
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");

        return Arrays.stream(split).toList();
    }

    private Integer tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
