package racingcar.controller;

import racingcar.constant.ErrorMessage;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGame {
    private Cars cars = new Cars();

    // 레이싱 게임 시작 함수
    public void start() {

        setCarsName(cars);
        setTryNumber(cars);
        OutputView.printCarResult();
    }

    // 자동차 이름 설정하기
    public void setCarsName(Cars cars) {

        try {
            cars.addCar(InputView.printSetCarsNameMessage());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_ERROR.print());
        }
    }

    // 게임 시도 회수  설정하기
    public void setTryNumber(Cars cars) {
        try {
            cars.setTryNumber(InputView.printGetTryNumberMessage());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_INPUT_ERROR.print());
        }
    }

    // 각 자동차 전진한 만큼 출력하기
    public void printCarsPosition(Cars cars) {
        for (Car car : cars.getCarList()){
            car.selectMoveOrStop();
            OutputView.printCarName(car.getName());
            OutputView.printCarPosition(car.getPosition());
            OutputView.printSpace();
        }
        OutputView.printSpace();
    }

    // 입력한 시도 횟수 만큼 출력하기
    public void printAllTry(Cars cars) {
        for (int i = 0; cars.getTryNumber() > i; i++) {
            printCarsPosition(cars);
        }
    }

    // 우승자 출력
    public void printWinner(Cars cars) {
        OutputView.printWinner(getWinner(cars));
    }

    // 우승자 반환하기
    private String getWinner(Cars cars) {
        return cars.getWinner(cars.getCarsPosition());
    }

    public Cars getCars() {
        return cars;
    }
}