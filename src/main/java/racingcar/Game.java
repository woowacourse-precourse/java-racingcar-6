package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {

    List<Car> carList;

    public void start() {
        saveCar();
        runRace(carList, attemptsCheck());
    }

    public void saveCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = Arrays.asList(readLine().split(","));
        carNameCheck(carNameList);
    }

    public void carNameCheck(List<String> carNameList) {
        carList = new ArrayList<>();
        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carList.add(new Car(name));
        }

    }

    public int attemptsCheck() {
        System.out.println("시도할 회수는 몇회인가요?");
        return numberCheckException(readLine());
    }

    // 예외처리
    public int numberCheckException(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void runRace(List<Car> cars, int attemptsCheck) {
        System.out.println();
        for (int attempt = 0; attempt < attemptsCheck; attempt++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPositionString());
            }
            System.out.println();
        }


    }



}



