package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

    }

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public List<Car> inputCarNames(){
        String s = readLine();
        String[] carNames = s.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
    public void printQuestionMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public int inputNumberOfTimes(){
        String s = readLine();
        return Integer.parseInt(s);
    }
}
