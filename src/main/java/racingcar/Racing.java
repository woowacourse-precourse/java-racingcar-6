package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int numberOfRacing;
    public void gameStart() {
        init();
        for (int i = 0; i < this.numberOfRacing; i++) {
            race();
        }
        System.out.println(result);
    }

    private void init(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputcars = Console.readLine(); //자동차 이름 input
        List<String> carnames = Arrays.asList(inputcars.split(",")); //Array로 변환
        for (String name: carnames) {
            this.cars.add(new Car(name)); // 객체 생성
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        String inputNum = Console.readLine(); //횟수 input
        numberOfRacing = Integer.parseInt(inputNum); //int로 변환
    }

    private void race() {
        for (Car car : cars) {
            int dice = Randoms.pickNumberInRange(0,9);
            if(dice >= 4) {
                car.moveForward(); //4 이상 나오면 move
            }
            int stepLength = car.movementHistory().length();
            System.out.println(car.name() + " : " 
            + car.movementHistory().substring(1,stepLength - 1)); //지금까지의 step 출력
        }
    }

}
