package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {

        Application app = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        app.checkInput(input);

        System.out.println("시도할 횟수는 몇회인가요?");
        int racingGameCount = Integer.parseInt(Console.readLine());


    }

    private void checkInput(String input) { // 각 자동차의 이름은 5글자 이하, 쉼표로만 구분
        List<String> carNameList = Arrays.asList(input.split(","));

        for (int i=0; i<carNameList.size(); i++) {
            String carName = carNameList.get(i);

            if (carName.length() > 5) { // 5자를 초과할 경우 예외처리
                throw new IllegalArgumentException("레이싱 카 이름이 5글자를 초과하였습니다.");
            }

            if (Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*",carName)) { // 한글이 들어간 경우 예외처리
                throw new IllegalArgumentException("레이싱 카 이름에 한글이 포함되어 있습니다.");
            }

            if(validateDuplication(carNameList, carName, i)){ // 이름이 중복될 경우 예외 처리
                throw new IllegalArgumentException(carName + " 이름이 중복됩니다.");
            }

        }

    }

    private boolean validateDuplication(List<String> carNameList, String carName, int index) {
        for (int i = index+1; i < carNameList.size(); i++) {
            if (carNameList.get(i).equals(carName)) {
                return true;
            }
        }
        return false;

    }


}