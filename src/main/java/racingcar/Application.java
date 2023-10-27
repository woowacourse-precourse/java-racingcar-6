package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    static ArrayList<String> carNameSplit(String racingCarNames){
        ArrayList<String> nameList = new ArrayList<>();
        for(String carName : racingCarNames.split(",")){
            if (carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름의 길이가 5보다 깁니다.");
            }
            nameList.add(carName);
        }
        return nameList;
    }
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String iterateNumber = Console.readLine();
        ArrayList<String> nameList = carNameSplit(racingCarNames);
        Control control = new Control(iterateNumber, nameList);
        control.executeRacing(nameList);
    }
}
