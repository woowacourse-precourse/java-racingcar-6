package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    static Control control = new Control();

    /* 콘솔에 출력할 각종 문장을 출력하는 메소드 -> Parameter(cmd)별로 다른 출력을 하도록 설계 */
    static public void print(String cmd){
        switch (cmd) {
            case "Start" -> System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            case "Try" -> System.out.println("시도할 회수는 몇회인가요?");
            case "Result" -> System.out.println("실행 결과");
            case "Progress" -> {
                for (int i = 0; i < Control.Cars.size(); i++) {
                    System.out.print(Control.Cars.get(i).name + " : ");
                    for (int j = 0; j < Control.Cars.get(i).moveCount; j++) {
                        System.out.print("-");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            case "Winner" -> {
                String winnerName = String.join(", ", Control.winnerName);
                System.out.println("최종 우승자 : " + winnerName);
            }
        }

    }

    /* 콘솔에서 사용자에게 입력받는 메소드 -> Parameter(cmd)별로 다른 입력을 받도록 설계*/
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
