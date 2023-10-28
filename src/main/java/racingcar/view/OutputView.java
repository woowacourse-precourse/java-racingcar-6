package racingcar.view;

import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;

public final class OutputView {

    public void printAllRoundMessage() {
        System.out.println("실행 결과");
    }

    public void printGameResult(CarsDto carsDto) {
        for (CarDto carDto : carsDto.carDtoList()) {
            System.out.printf("%s : %s\n", carDto.carName(), "-".repeat(carDto.position()));
        }
        System.out.println();
    }

    public void printGameWinner(CarsDto carsDto) {
        System.out.println("최종 우승자 : " + carsDto.getWinners());
    }
}
