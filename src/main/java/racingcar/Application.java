package racingcar;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    private static void RacerInput(){
        String RacerNameInput = Console.readLine();
        String[] RacerNames = RacerCheck(RacerNameInput);
    }
    private static String[] RacerCheck(String RacerNameChk){
        String[] RacerNames = RacerNameChk.split(",");;
        if (!RacerNameChk.contains(",")) return RacerNames;
        for (String racerName : RacerNames) {
            if (racerName.length() > 5) throw new IllegalArgumentException("유효하지않은 수 입니다.");
        }
        return RacerNames;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacerInput();
    }
}
