package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.dto.InputCarDto;
import racingcar.dto.ResultDto;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {
        InputCarDto inputCarDto = inputView.printInputCarName();
        CarGroup carGroup = getCarGroup(inputCarDto);

        String round = inputView.printInputRound();
        int roundNumber = getRoundNumber(round);
        carGroup.move(roundNumber);

        outputView.printResult(new ResultDto(carGroup, roundNumber));

        List<String> winners = carGroup.getCars().stream()
            .filter(car -> car.getPosition() == carGroup.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대값이 없습니다.")))
            .map(Car::getName)
            .collect(Collectors.toList());
        outputView.printWinner(winners);
    }

    private static int getRoundNumber(String round) {
        validateRound(round);
        return Integer.parseInt(round);
    }

    private static void validateRound(String round) {
        if (round == null || !round.matches("[0-9]+")) {
            throw new IllegalArgumentException("0이상의 숫자만 입력 가능합니다.");
        }
    }


    private static CarGroup getCarGroup(InputCarDto inputCarDto) {
        String[] separateCarGroup  = splitCarGroup(inputCarDto);
        List<Car> carList = Arrays.stream(separateCarGroup)
            .map(Car::new)
            .collect(Collectors.toList());
        return new CarGroup(carList);
    }

    private static String[] splitCarGroup(InputCarDto inputCarDto) {
        return inputCarDto.carName().split(inputCarDto.Delimiter());
    }
}
