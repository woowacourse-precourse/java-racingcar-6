package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.List;

public class RacingCarView {

    public String inputStartRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String cars = Console.readLine();
        return cars;
    }

    public String inputRacingCarTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        final String racingCount = Console.readLine();
        return racingCount;
    }

    public void printAheadCount(List<Car> racingCarList) {
        for (Car car:racingCarList){
            System.out.println(car.getName()+" : "+"-".repeat(car.getAheadCount()));
        }
        System.out.println("");
    }

    public void printWinner(List<String> winnerList){
        String winners = String.join(", ", winnerList);
        System.out.println("최종 우승자 : "+winners);
    }
}
