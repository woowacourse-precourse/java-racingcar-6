package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.utils.Utils;

public class RacingCarService {
    private static final String START_GAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String SHOW_RESULT_MESSAGE = "실행 결과";
    private final static RacingCars cars = new RacingCars();
    private static Integer input_cnt;

    public void exec() {
        createRacingCar();
        getInputCount();
        System.out.println();
        System.out.println(SHOW_RESULT_MESSAGE);
        do {
            cars.tryRace();
            input_cnt--;
        } while (input_cnt != 0);
        System.out.println(String.format("최종 우승자 : %s", RacingCars.comparison()));
    }

    private void createRacingCar() {
        System.out.println(START_GAME_MESSAGE);
        Arrays.stream(Console.readLine().split(","))
                .forEach(e -> {
                    Utils.nameValidation(e);
                    cars.add(new RacingCar(e), new RacingResult());
                });
    }

    private void getInputCount() {
        System.out.println(INPUT_COUNT_MESSAGE);
        try {
            input_cnt = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
