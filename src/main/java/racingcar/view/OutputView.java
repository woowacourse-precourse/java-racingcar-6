package racingcar.view;

import java.util.stream.Collectors;
import racingcar.controller.dto.CarDto;
import racingcar.controller.dto.RoundDto;
import racingcar.controller.dto.WinnerDto;
import racingcar.controller.dto.WinnersDto;

public final class OutputView {

    private boolean isFirstCall = true;

    public void printRoundDto(final RoundDto roundDto) {
        System.out.println();
        printStartMessageIfFirstCall();
        final String renderedString = roundDto.cars().stream()
                .map(this::renderCarDto)
                .collect(Collectors.joining("\n"));

        System.out.println(renderedString);
    }

    public void printWinnersDto(final WinnersDto winnersDto) {
        System.out.println();
        System.out.printf("최종 우승자 : %s", renderWinnersDto(winnersDto));
    }


    private void printStartMessageIfFirstCall() {
        if (isFirstCall) {
            System.out.println("실행 결과");
            isFirstCall = false;
        }
    }

    private String renderWinnersDto(final WinnersDto winnersDto) {
        return winnersDto.winners().stream()
                .map(WinnerDto::name)
                .collect(Collectors.joining(", "));
    }

    private String renderCarDto(final CarDto carDto) {
        return String.format("%s : %s",
                carDto.name(),
                "-".repeat(carDto.position())
        );
    }
}
