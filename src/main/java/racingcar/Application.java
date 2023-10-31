package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = Console.readLine().split(",");
        // 이름에 대한 여러 예외들 처리 (5자 이하만 가능)
        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameRoundString = Console.readLine();
        // 숫자 아닌 경우 예외 처리 신경쓰자
        try{
            int gameRound = Integer.parseInt(gameRoundString);
        }
        catch (NumberFormatException exception){
            throw new IllegalArgumentException();
            // 메세지 나중에 입력
        }
    }
}
