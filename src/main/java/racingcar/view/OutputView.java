package racingcar.view;

import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarDtos;
import racingcar.domain.dto.WinnersDto;

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
    public void printCarPositions(final CarDtos carDtos) {
        for (CarDto carDto : carDtos.carDtos()) {
            printSingleCarPosition(carDto);
        }
        System.out.println();
    }

    private void printSingleCarPosition(final CarDto carDto) {
        System.out.println(carDto.name() + " : " + "-".repeat(carDto.position()));
    }


    public void printWinners(final WinnersDto winners) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winners.winners()));
    }
}
