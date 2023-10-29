package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();

        List<String> nameList = inputView.inputCarName();
        int round = inputView.inputTryNumber();

        List<Car> carList = mappingCar(nameList);
        Racing racing = new Racing(carList);

        for (Car car : carList) {
            if(racing.isGo())
                car.move +=1;
        }
    }

    private static List<Car> mappingCar(List<String> nameList) {
        List<Car> carList = new ArrayList<>();

        for(int i = 0; i< nameList.size(); i++){
            Car car = new Car(nameList.get(i), 0);
            carList.add(car);
        }

        return carList;
    }
}
