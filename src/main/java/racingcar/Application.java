package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.*;

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

    public int createRandomNumber(){
        return pickNumberInRange(0, 9);
    }

    public List<Car> tryCarSteps(List<Car> cars, int steps){
        for (int tryNums = 0; tryNums < steps; tryNums++) {
            cars=checkCarSteps(cars);
            printCarSteps(cars);
        }
        return cars;
    }
    public void printCarSteps(List<Car> cars){
        for (int i = 0; i < cars.size(); i++) {
            StringBuilder message= new StringBuilder(cars.get(i).getCarName() + " : ");
            for (int j = 0; j < cars.get(i).getSteps(); j++) {
                message.append("-");
            }
            System.out.println(message);
        }
    }
    public List<Car> checkCarSteps(List<Car> cars) {
        for (int i = 0; i <cars.size() ; i++) {
            int randomNumber = createRandomNumber();
            if(randomNumber>=4) cars.get(i).setSteps(cars.get(i).getSteps()+1);
        }
        return cars;
    }

}
