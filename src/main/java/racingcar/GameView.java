package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.Validation.carNameValid;

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
        List<String> strList = carNameValid(Arrays.asList(inputCars.split(",",-1)));

        for (String car : strList) {
            if(Validation.carValid(car)){     // Car 이름 검증
                carList.add(new Car(car));
            }
        }
        return carList;
    }

    public void printDash(int num){
        for (int i=0;i<num;i++){
            System.out.print("-");
        }
        System.out.println();
    }


}
