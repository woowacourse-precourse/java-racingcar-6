package racingcar;

import model.Car;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class SetRace {
    private final List<Car> carsList = new ArrayList<>();
    public List<Car> createCar() {
        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input.contains(",")) {
            String[] carNames = input.split(",");
            for (String carName : carNames) {
                Car car = new Car(carName);
                carsList.add(car);
            }
        } else {
            throw new IllegalArgumentException("적어도 하나 이상의 자동차 이름을 입력해야 합니다.");
        }
        return carsList;
    }

    public int inputMovement() {
        try{
            System.out.println("이동할 횟수를 입력하세요");
            String time = Console.readLine();
            int number = Integer.parseInt(time);
            return number;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
