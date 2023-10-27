package racingcar.Controller;

import racingcar.CarManager;
import racingcar.Controller.RaceController;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    CarManager carManager=new CarManager();
    RaceController raceController =new RaceController();
    public void getNameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        splitName(readLine());
    }

    private void splitName(String readLine) {
        List<String> carNamesList = Arrays.asList(readLine.split(","));
        for (String carName : carNamesList) {
            Car car = new Car(carName.trim());
            carManager.addCar(car);
        }
        //설정한 값을 raceController에서 쓰기 위해 carManager값을 전달해준다.
        raceController.setCarList(carManager);
    }

    public int getRaceTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }

}
