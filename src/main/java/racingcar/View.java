package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    static Control control = new Control();
    static public void print(String cmd){
        if(cmd.equals("Start")){
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        }
        else if(cmd.equals("Try")){
            System.out.println("시도할 회수는 몇회인가요?");
        }
        else if(cmd.equals("Result")){
            System.out.println("실행 결과");
        }
        else if(cmd.equals("Progress")){
            for(int i = 0; i < Control.Cars.size(); i++){
                System.out.print(Control.Cars.get(i).name+" : ");
                for(int j = 0; j < Control.Cars.get(i).moveCount; j++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
        else if(cmd.equals("Winner")){
            String winnerName = String.join(", ", Control.winnerName);
            System.out.println("최종 우승자 : " + winnerName);
        }

    }
    static public void input(String cmd){
        if(cmd.equals("Name")){
            String names = Console.readLine();
            control.stringToList(names); //입력 받은 이름을 Control Class로 넘겨준다.
        }
        else if(cmd.equals("NumberOfAttempts")){
            String tryNumber = Console.readLine();
            control.setTryNumber(tryNumber); // 입력 받은 시도 횟수를 Control Class로 넘겨준다.
        }

    }
}
