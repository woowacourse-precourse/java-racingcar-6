package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Position;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_NAME_TAG = " : ";
    private static final String PROGRESS_BAR = "-";

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
        System.out.print(carName.getName() + CAR_NAME_TAG);
        for(int i=0; i<position.getPosition(); i++){
            System.out.print(PROGRESS_BAR);
        }
        System.out.println();
    }
}
