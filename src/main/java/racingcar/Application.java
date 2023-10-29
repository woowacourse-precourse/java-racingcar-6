package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
    }

    private static final String CarNamesAlert = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String NumberTryAlert = "시도할 회수는 몇 회인가요?";
    private Map<String, String> carStatus;

    public void startGame(){
        System.out.println(CarNamesAlert);
        String name =readLine();
        String[] carNames = name.split(",");
        CarNameValidate(carNames);

        System.out.println(NumberTryAlert);
        int number = Integer.parseInt(readLine());
    }

    private void CarNameValidate(String[] carNames){
        for(String carName : carNames){
            if(carName.length()>5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }
}