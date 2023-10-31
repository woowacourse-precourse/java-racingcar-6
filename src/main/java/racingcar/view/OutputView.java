package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarDto;

public class OutputView {
    public static void gameProgress(List<RacingCarDto> racingCarDtoList) {
        StringBuilder sb = new StringBuilder();
        racingCarDtoList.forEach(racingCarDto -> {
            System.out.println(racingCarDto.getName()
                    + " : "
                    + "-".repeat(Math.max(0, racingCarDto.getDistance())));
        });
    }
    public static void gameResult(List<String> racingCarNames) {
        System.out.println(String.join(", ", racingCarNames));
    }
}
