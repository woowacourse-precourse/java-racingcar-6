package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.Validator;
public class Game {

        private List<Car> carList = new ArrayList<>();
        private String[] carNames;

        public void start(){
                inputCarName();
                inputTryCount();
                for(String name: carNames){
                        Car car = new Car(name,0);
                        carList.add(car);
                }
                for(int i=0; i<3; i++){
                        for(Car car: carList){
                                car.move();
                                car.printCar();
                        }
                        System.out.println();
                }
        }
        public void inputCarName(){
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                carNames = Console.readLine().split(",");
                for(String name: carNames){
                        Validator validator = new Validator();
                        validator.nameValidator(name);
                        Car car = new Car(name,0);
                }
        }
        public void inputTryCount(){
                System.out.println("시도할 회수는 몇회인가요?");
                String tryCount = Console.readLine();
                Validator validator = new Validator();
                validator.tryCountValidator(tryCount);
        }

}
