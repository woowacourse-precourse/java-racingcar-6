package racingcar.view;

import racingcar.dto.CarDto;

public class OutputView {

    public static final String SEPARATOR = " : ";
    public static final String POSITION_BAR = "-";

    private OutputView() {
    }

    public static void printSituation(CarDto dto) {
        String name = dto.name();
        int position = dto.position();
        System.out.println(name + SEPARATOR + POSITION_BAR.repeat(position));
    }
}
