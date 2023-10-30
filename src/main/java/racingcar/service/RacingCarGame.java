package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;


public class RacingCarGame {


    public void playGame() {

        // TODO : carName 입력 체크
        String carName = Console.readLine();
        CarService carService = new CarService();
        List<Car> carList = carService.createCar(carName);


        // TODO : attemptNum 입력 체크
        int attemptNum = Integer.parseInt(Console.readLine());
        for(int i = 0; i < attemptNum; i++) {
            carService.moveForwards(carList);
            carService.displayPositions(carList);
            System.out.println();
        }
        displayWinnerCar(carList);
    }

    public void displayWinnerCar(List<Car> carList) {
        String winCarName = "";
        int winCarPosition = -1;
        for (Car car : carList) {
            if(car.getPosition() > winCarPosition) {
                winCarPosition = car.getPosition();
                winCarName = car.getName();
            } else if (car.getPosition() == winCarPosition) {
                winCarPosition = car.getPosition();
                winCarName = winCarName + ", " + car.getName();
            }
        }
        System.out.println("최종 우승자 : " + winCarName);
    }

    private boolean isInvalidInput(List<Car> carList) {
        //TODO : carName input check 만들기
        return true;
    }

    private boolean isNumber(String inputStr) {
        return inputStr != null && inputStr.matches("[0-9]+");
    }
}
