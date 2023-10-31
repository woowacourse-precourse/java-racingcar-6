package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Racer> RacerInput(){ //사용자의 입력을 받는 함수
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String RacerNameInput = Console.readLine();
        return RacerCheck(RacerNameInput);
    }
    private static List<Racer> RacerCheck(String RacerNameChk){ //사용자에 입력값에 따른 유효성 검사
        String[] RacerNames = RacerNameChk.split(","); //사용자의 ","에 따라 값을 나눠 리스트에 저장
        List<Racer> racers = new ArrayList<>();
        for (String racerName : RacerNames) {
            if (racerName.length() > 5) throw new IllegalArgumentException("유효하지않은 수 입니다.");
            racers.add(new Racer(racerName));
        }
        return racers; //racer 클래스에 정보 전달
    }
    private static int RacingCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String RacingCountInput = Console.readLine(); //시도할 횟수를 입력받음
        try{
            return Integer.parseInt(RacingCountInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 수 입니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Racer> racers = RacerInput();
        Racing racing = new Racing(RacingCount());
        racing.Race(racers);
    }
}
