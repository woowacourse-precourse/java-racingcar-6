package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public static String inputTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return readLine();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCurrentStatus(String name, int currentLocation) {
        System.out.print(name+" : ");
        for(int i=0;i<currentLocation; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printEnter(){
        System.out.println();
    }

    public static void printWinner() {
        System.out.println("최종 우승자 :");
    }

}
