package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    // 정지, 직진을 계산해주는 메소드
    public static void racingCar(List<String> name, String count){

        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if(randomNumber>4){ // 랜덤한 숫자가 4이상일 경우 전진

        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> name = new ArrayList<>();
        str.split(",");
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        name.add(userInput);
        System.out.println("시도할 회수는 몇회인가요?");
        String count = camp.nextstep.edu.missionutils.Console.readLine();

        racingCar(name, count);
    }
}
