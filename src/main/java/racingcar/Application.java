package racingcar;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    private static String[] RacerInput(){ //사용자의 입력을 받는 함수
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String RacerNameInput = Console.readLine();
        return RacerCheck(RacerNameInput);
    }
    private static String[] RacerCheck(String RacerNameChk){ //사용자에 입력값에 따른 유효성 검사
        String[] RacerNames = RacerNameChk.split(","); //사용자의 ","에 따라 값을 나눠 리스트에 저장
        if (!RacerNameChk.contains(",")) return RacerNames; //사용자가 1개의 값을 입력한 경우 바로 출력
        for (String racerName : RacerNames) {
            if (racerName.length() > 5) throw new IllegalArgumentException("유효하지않은 수 입니다."); //사용자의 입력값 유효성검사
        }
        return RacerNames; //유효성 검사 후 리스트 return
    }
    private static int RacingCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String RacingCountInput = Console.readLine(); //시도할 횟수를 입력받음
        try{return Integer.parseInt(RacingCountInput);} //시도할 횟수를 Int 형식으로 return
        catch (NumberFormatException ex) {throw new IllegalArgumentException("유효하지 않은 수 입니다.");} //수가 아닌 경우 에러
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCount();
    }
}
