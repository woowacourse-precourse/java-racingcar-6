package racingcar.view.output;

import racingcar.dto.CarDto;

public class PlayResultOutput {
    private static final String OUTPUT_FORMAT = "%s : %s";
    private static final String POSITION_INDICATOR = "-";

    private final String output;

    private PlayResultOutput(String output) {
        this.output = output;
    }

    public static PlayResultOutput from(CarDto carDto) {
        return new PlayResultOutput(OUTPUT_FORMAT.formatted(carDto.name(), positionString(carDto)));
    }

    private static String positionString(CarDto carDto) {
        return POSITION_INDICATOR.repeat(carDto.position());
    }

    public String output() {
        return output;
    }
}
