package racingcar;

import java.util.List;

public class Print {
    private static final String GetUserInput = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GetPlayCount = "시도할 회수는 몇회인가요?";
    private static final String PlayResult = "실행 결과";
    private static final String WinnerInfo = "최종 우승자";


    // 실행결과 출력 시작 안내 문구 출력
    public void start() {
        System.out.println(PlayResult);
    }

    // 실행 결과 출력
    public void result(Car car){
        System.out.println(car.name + " : " + "-".repeat(car.distance));
    }

    // 우승자 출력
    public void winner(List<String> winnerName){
        System.out.print(WinnerInfo + " : ");

        for(String s: winnerName){
            if(s.equals(winnerName.get(winnerName.size()-1))){
                System.out.print(s);
            } else {
                System.out.print(s + ", ");
            }
        }
    }
}
