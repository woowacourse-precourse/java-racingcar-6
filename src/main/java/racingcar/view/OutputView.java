package racingcar.view;

import racingcar.domain.dto.output.CarDto;
import racingcar.domain.dto.output.CarsDto;
import racingcar.io.OutputWriter;

import java.util.List;

public class OutputView {
    private static final String DASH = "-";
    private final OutputWriter writer;

    public OutputView(OutputWriter writer) {
        this.writer = writer;
    }

    public void printGameResultMsg() {
        writer.writeGameResultMsg();
    }

    public void printGameResult(CarsDto carsDto) {
        List<CarDto> carDtoList = carsDto.carDtoList();
        for (CarDto carDto : carDtoList) {
            String carGameResult = String.format("%s : %s",
                    carDto.name(),
                    convertToDashes(carDto.position()));
            System.out.println(carGameResult);
        }
        System.out.println();
    }

    private String convertToDashes(int position) {
        return DASH.repeat(Math.max(0, position));
    }

}
