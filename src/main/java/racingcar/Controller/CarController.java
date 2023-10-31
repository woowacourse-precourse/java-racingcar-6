package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private List<Car> carsList;
    public CarController() {
        carsList = new ArrayList<>();
    }

    public void start(){
        String carsName = InputView.setCarName();
        String[] carNamesArray = carsName.split(",");

        carsList = new ArrayList<>();

        for (String name : carNamesArray) {
            checkLength(name);
            Car car = new Car(name);
            carsList.add(car);
        }
        String num = InputView.setGameNum();
        OutputView.print();
        OutputView.printResult();
        for(int i = 0; i < Integer.parseInt(num); i++){
            setCount();
            OutputView.print();
        }

        List<String> winners = determineWinners();
        OutputView.printWinner();
        OutputView.printWinners(winners);
    }

    public void checkLength(String name) throws IllegalArgumentException{
        if(name.length() > 5){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public void setCount(){
        for (Car car : carsList) {
            car.move(setNumber());
        }
        printGameResult();
    }

    private int setNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printGameResult() {
        for (Car car : carsList) {
            OutputView.printCarName(car);
            OutputView.printCount(car.getPosition());
            OutputView.print();
        }
    }

    private List<String> determineWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = -1;

        for (Car car : carsList) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
                winners.clear();
                winners.add(car.getName());
            } else if (currentPosition == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
