package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Position;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";

    public void printRaceResultMessage(){
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void printCurrentRaceStatus(Cars cars){
        for(Car car : cars.getCars()) {
            CarName carName = car.getCarName();
            Position position = car.getPosition();
            printCarStatus(carName, position);
        }
        System.out.println();
    }

    private void printCarStatus(CarName carName, Position position){
        System.out.print(carName.getName() + ":");
        for(int i=0; i<position.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
