package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.RacingCarEntity;

import java.util.Arrays;
import java.util.List;

public class UserInputService {
    public List<RacingCarEntity> getRacingCarEntities() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<RacingCarEntity> cars = inputCars();
        return cars;
    }


    public List<RacingCarEntity> inputCars() {
        List<String> userInputCars = getUserInputAndCheck();
        //인풋받은 데이터를 RacingCarEntity로 변환
        List<RacingCarEntity> cars = userInputCars.stream().map(car -> new RacingCarEntity(car,0)).toList();
        return cars;
    }


    public List<String> getUserInputAndCheck() {
        String userInput = Console.readLine();
        inputNottingTest(userInput);
        List<String> userInputCars = stringToListAndLengthCheck(userInput);
        return userInputCars;
    }

    public void inputNottingTest(String userInput) {
        if (userInput.length() == 0) throw new IllegalArgumentException("빈 입력");
    }

    private List<String> stringToListAndLengthCheck(String userInput) {
        List<String> userInputCars = Arrays.stream((userInput.split(","))).toList();
        userInputCars.stream().forEach(userInputCar -> inputCarLengthCheck(userInputCar));
        return userInputCars;
    }

    public boolean inputCarLengthCheck(String userInputCar) {
        System.out.println(userInputCar);
        if (userInputCar.length() > 5) {
            throw new IllegalArgumentException("유저 인풋 길이 5 초과");
        }
        return true;
    }


    public Integer getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 입력");
        }
        return tryCount;
    }

}
