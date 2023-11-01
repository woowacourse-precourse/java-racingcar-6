package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameView {
//    입력 : 한 줄로 자동차들 입력, 자동차 리스트에 추가 하기.
    public List<Car> inputCars() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        return makeCarList(inputCars);
    }

//    입력 : 게임 횟수
    public int inputNum() throws IllegalArgumentException{
        System.out.println("시도할 회수는 몇회인가요?");
        int num = Integer.parseInt(Console.readLine());
        return Validation.numValid(num);
    }

    public List<Car> makeCarList(String inputCars){
        List<Car> carList = new ArrayList<>();
        String[] splitCars = inputCars.split(",");

        // List를 분리하는 다른 방법 : List<Object> carNames = Arrays.asList(inputCars.split(","));
        for (String splitCar : splitCars) {
            if(Validation.carValid(splitCar)){     // Car 이름 검증
                carList.add(new Car(splitCar));
            }
        }
        return carList;
    }

    public void printSlash(int num){
        for (int i=0;i<num;i++){
            System.out.print("-");
        }
        System.out.println();
    }


}
