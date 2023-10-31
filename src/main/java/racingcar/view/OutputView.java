package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printPlayResult()
    {
        System.out.println("실행 결과");
    }

    public void printCarListResult(List<Car> carList){
        carList.forEach(car -> car.getResult());
        System.out.println("");
    }


}
