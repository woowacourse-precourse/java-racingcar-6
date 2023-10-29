package racingcar;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = readLine();
        List<String> carNameList = utils.convertToList(inputCarName);
        utils.checkCarNameUnderFiveLength(carNameList);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputStepCount = readLine();
        int stepCount = utils.convertToInteger(inputStepCount);

        List<Car> carList = new ArrayList<Car>();
        for (String carName : carNameList){
            Car car = new Car(carName);
            carList.add(car);
        }

        System.out.println("실행 결과");
        for (int i =0; i< stepCount; i++){
            for (Car car: carList){
                car.decideIfCarShouldGo();
                car.printCurrentDistance();
            }
            System.out.println();
        }

        List<Car> championCars = utils.findCarsWithMaxDistance(carList);

        System.out.print("최종 우승자 : ");
        int size = championCars.size();
        for (int i = 0; i < size; i++) {
            Car car = championCars.get(i);
            System.out.print(car.carName);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }

    }
}
