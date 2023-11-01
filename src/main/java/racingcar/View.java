package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View{
    public static String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static void printCarMove(String carName, int position){
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public static void printResultAlarm(){
        System.out.println("실행 결과");
    }

    public static void printFinalWinner(String winners){
        System.out.println("최종 우승자 : "+winners);
    }
}