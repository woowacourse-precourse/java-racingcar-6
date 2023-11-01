package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.Validator;
public class Game {
        private String name;
        private List<Car> carList = new ArrayList<>();
        private List<String> winnerList = new ArrayList<>();
        private String[] carNames;
        private int count;
        public void start(){
                inputCarName();
                inputTryCount();
                play(count);
                getWinnerList();
                printWinner(winnerList);
        }
        public List<Car> inputCarName(){
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                carNames = Console.readLine().split(",");
                for(String name: carNames){
                        Validator validator = new Validator();
                        validator.nameValidator(name);
                        addList(name);
                }
                return carList;
        }
        public void inputTryCount(){
                System.out.println("시도할 회수는 몇회인가요?");
                String tryCount = Console.readLine();
                Validator validator = new Validator();
                validator.tryCountValidator(tryCount);
                count = Integer.parseInt(tryCount);
        }
        public List<Car> addList(String name){
                Car car = new Car(name,0);
                carList.add(car);
                return carList;
        }
        public List<Car> play(int tryCount){
                for(int i=0; i<tryCount; i++){
                        for(Car car: carList){
                                car.move();
                                car.printCar();
                        }
                        System.out.println("");
                }
                return carList;
        }
        public List<String> getWinnerList(){
                int max = 0;
                for(Car car: carList){
                        if(car.getPosition() > max){
                                max = car.getPosition();
                        }
                }
                for(Car car: carList){
                        if(car.getPosition() == max){
                                winnerList.add(car.getName());
                        }
                }
                return winnerList;
        }
        public void printWinner(List<String> winnerList){
                System.out.print("최종 우승자 : "+ String.join(", ",winnerList));
        }

}
