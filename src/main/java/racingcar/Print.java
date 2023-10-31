package racingcar;

import java.util.List;

public class Print {
    private static final String GetCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GetPlayCount = "시도할 회수는 몇회인가요?";
    private static final String PlayResult = "실행 결과";
    private static final String WinnerInfo = "최종 우승자";


    public static void message(int i){
        switch (i){
            case 1: System.out.println(GetCarName);
                break;
            case 2: System.out.println(GetPlayCount);
                break;
            case 3: System.out.println(PlayResult);
                break;
            default: break;

        }

    }

    public static void result(List<Car> cars){
        for(Car c: cars){
            System.out.println(c.name + " : " + "-".repeat(c.distance));
        }

    }

    public static void winner(List<String> winners){
        System.out.print(WinnerInfo + " : ");

        for(String s: winners){
            if(s.equals(winners.get(winners.size()-1))){
                System.out.print(s);
            } else {
                System.out.print(s + ", ");
            }
        }
    }
}
