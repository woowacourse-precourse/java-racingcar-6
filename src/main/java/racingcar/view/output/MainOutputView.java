package racingcar.view.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;

public class MainOutputView {
    public static void printWinningCars(List<CarDto> carDtos) {
        System.out.println("최종 우승자 : " + joinedNames(carDtos));
    }

    private static String joinedNames(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(CarDto::name)
                .collect(Collectors.joining(", "));
    }
}
