package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String[] carNames;
    static Long raceTime;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputCarName();
        inputRaceTime();
    }

    public static void inputCarName() {
        String input = Console.readLine();
        carNames = parseCarName(input);
    }
    public static String[] parseCarName(String input) {

        String[] names = input.split(",");

        for (String name : names) {
            validateCarName(name);
        }
        return names;
    }

    public static void validateCarName(String name) {
        isBelowFiveWord(name);
    }

    static void isBelowFiveWord(String name) {
        if (5 < name.length()){
            throw new IllegalArgumentException("자동차의 이름이 5글자 이상입니다.");
        }
    }

    public static void inputRaceTime() {
        String input = Console.readLine();

        try{
            raceTime = Long.parseLong(input);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 횟수 입력입니다.");
        }
    }

}
