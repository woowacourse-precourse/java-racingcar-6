package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.PrintAll;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    PrintAll printAll = new PrintAll();

    public String finalResult(List<Car> carList) {
        String result = "";
        //가장 큰 값 구하기
        Car largestCar = largest(carList);
        //동점자 있는지 확인.
        List<String> finalNameList = winnersNumber(largestCar, carList);
        //최득점자 이름 출력
        printAll.outputFinalPrint(finalNameList);

        return result;
    }

    public List<String> winnersNumber(Car largestCar, List<Car> carList) {
        List<String> winnerNameList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getProgressbar() == largestCar.getProgressbar()) {
                //System.out.println(car.getName());
                winnerNameList.add(car.getName());
            }
        }


        return winnerNameList;
    }

    public Car largest(List<Car> carList) {
        Car maxNumCar = carList.get(0);
        for (Car car : carList) {
            if (car.getProgressbar() > maxNumCar.getProgressbar()) maxNumCar = car;
        }
        return maxNumCar;
    }


}
