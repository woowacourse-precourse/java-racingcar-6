package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int carNameRange = 5;

    public static void NameCheck(String carName){
        if (carName.length() > carNameRange)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        String[] carNameList = carNameInput.split("\\,");

        for(int i=0; i<carNameList.length; i++){
            NameCheck(carNameList[i]);
        }
        
    }
}
