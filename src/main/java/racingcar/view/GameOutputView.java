package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class GameOutputView {
    private static final String POSITION_INDICATOR = "-";

    public static void printPlayResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printPlayResults(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            System.out.println(carDto.name() + " : " + positionString(carDto));
        }
        System.out.println();
    }

    private static String positionString(CarDto carDto) {
        // TODO 클래스 분리 및 테스트
        return POSITION_INDICATOR.repeat(carDto.position());
    }
}
