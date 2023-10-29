package racingcar.view;

import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarDtos;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printInputCarNamesMessage(){
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public void printInputGameTryCountMessage(){
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }
    public void printCarPositions(CarDtos carDtos) {
        for (CarDto carDto : carDtos.getCarDtos()) {
            printSingleCarPosition(carDto);
        }
        System.out.println();
    }

    private void printSingleCarPosition(CarDto carDto) {
        System.out.println(carDto.getName() + " : " + "-".repeat(carDto.getPosition()));
    }


    public void printWinners(List<String> winnerNames) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winnerNames));
    }
}
