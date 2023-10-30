package racingcar;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<RacingCar> carList = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();
        List<String> userInputList = transUserInputToList(userInput);
        for(int i=0;i<userInputList.size();i++){
            RacingCar racingCar = new RacingCar(userInputList.get(i),0);
            carList.add(racingCar);
        }
        for(int j=0;j<carList.size();j++){
            System.out.println(carList.get(j).getName());
        }


    }

    private static List<String> transUserInputToList(String userInput) {
        List<String> userInputList = new ArrayList<>();
        for (String s : userInput.split(",")) {
            userInputList.add(s);
        }
        return userInputList;
    }
}
