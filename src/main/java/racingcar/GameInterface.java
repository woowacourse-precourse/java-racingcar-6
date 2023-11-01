package racingcar;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameInterface {
    public void play(){}

    private static String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = readLine();
        String[] inputCarNames = inputCarName.split(",");
        checkCarNames(inputCarNames);
        return inputCarNames;
    }

    private static void checkCarNames(String[] carNames){
        for (String name : carNames) {
            checkCarNameLength(name);
        }
    }

    private static void checkCarNameLength(String carName){
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static int getNumberOfRepetition() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = readLine();
        return Integer.parseInt(inputNumber);
    }
}
