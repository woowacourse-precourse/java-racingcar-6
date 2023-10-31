package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static class GameStart {
        public GameStart(){ inputNames();}
            private void inputNames() {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String inputInformations = Console.readLine();

                CheckNames checkNames = new CheckNames();
                checkNames.CheckNames(inputInformations);

                if(checkNames.CheckNames(inputInformations) == true){
                    System.out.println("시도할 횟수는 몇 회인가요?");
                }

                String inputNumber = Console.readLine();
                int tryNumber = Integer.parseInt(inputNumber);
                System.out.println("시도할 횟수는 "+tryNumber+"회 입니다.");
            }

    public static class CheckNames {
        public boolean CheckNames(String inputNames){
            inputNames = inputNames.replaceAll("\\s", "");
            String[] nameList = inputNames.split(",");

            for(String names : nameList){
                if(names.length() < 0 || names.length() > 6){
                    throw new IllegalArgumentException("자동차의 이름은 5자이하로 작성해주세요.");
                }
//                System.out.println(names);
            }
                return true;
        }
        }
    }
    public static void main(String[] args) {
        GameStart gamestart = new GameStart();
        gamestart.inputNames();
    }
}
