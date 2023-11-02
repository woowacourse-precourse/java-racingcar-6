package racingcar.view;

import racingcar.dto.CarGroupDto;
import racingcar.dto.WinnersDto;

public class OutputView {

    private static final String CAR_DISTANCE = "-";
    private static final String DELIMITER = ", ";

    public void printResultHeader() {
        System.out.println("실행 결과");
    }

    public void printWinner(WinnersDto winnersDto) {
        System.out.println("최종 우승자 : " + String.join(DELIMITER, winnersDto.winners()));
    }

    public void printRoundResult(CarGroupDto carGroupDto) {
        carGroupDto.carGroup().forEach(car -> {
            String result = car.getName() + " : " + printPosition(car.getPosition());
            System.out.println(result);
        });
        System.out.println();
    }

    private String printPosition(int position) {
        return CAR_DISTANCE.repeat(position);
    }

}
