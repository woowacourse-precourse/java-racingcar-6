package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = readLine();
        List<String> carNameList = ConvertAndValidation.convertToList(inputCarName);
        ConvertAndValidation.checkCarName(carNameList);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryNumber = readLine();
        int tryNumber = ConvertAndValidation.convertToInteger(inputTryNumber);

        List<NewCar> carList = new ArrayList<>();
        for (String carName : carNameList){
            NewCar car = new NewCar(carName);
            carList.add(car);
        }

        System.out.println("실행 결과");
        for (int i=0; i<tryNumber; i++){
            for (NewCar car : carList){
                car.carShouldGo();
                car.currentDistance();
            }
            System.out.println();
        }

        List<NewCar> champions = NewCar.findMaxDistance(carList);
        System.out.print("최종 우승자 : ");
        int size = champions.size();
        for (int i=0; i<size; i++){
            NewCar car = champions.get(i);
            System.out.print(car.carName);
            if (i < size-1){
                System.out.print(", ");
            }
        }
    }
}
