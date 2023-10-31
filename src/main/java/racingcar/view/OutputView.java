package racingcar.view;

import java.util.List;
import racingcar.dto.RacingCarDto;

public class OutputView {
    public static void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static  void  inputTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public static void progressGameIntro() {
        System.out.println();
        System.out.println("실행 결과");
    }
    public static void gameProgress(List<RacingCarDto> racingCarDtoList) {
        StringBuilder sb = new StringBuilder();
        racingCarDtoList.forEach(racingCarDto -> {
            System.out.println(racingCarDto.getName()
                    + " : "
                    + "-".repeat(Math.max(0, racingCarDto.getDistance())));
        });
        System.out.println();
    }
    public static void gameResult(List<String> racingCarNames) {
        System.out.println("최종 우승자 : " + String.join(", ", racingCarNames));
    }
}
