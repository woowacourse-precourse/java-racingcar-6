package racingcar.view.output;

import java.util.List;
import racingcar.dto.CarDto;

public class GameOutputView {
    public static void printPlayResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printPlayResults(List<CarDto> carDtos) {
        carDtos.stream()
                .map(PlayResultOutput::from)
                .map(PlayResultOutput::output)
                .forEach(System.out::println);
        System.out.println();
    }
}
