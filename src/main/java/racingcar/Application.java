package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Vector;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        //Console.readLine() 메서드를 이용해서 자동차 이름 받기
        String inputCarName = Console.readLine();
        String[] tokens = inputCarName.split(",");
        for (String token : tokens){
            //공백 제거할 때는 trim()메서드 사용하기
            System.out.println(token.trim());
        }


    }
}
