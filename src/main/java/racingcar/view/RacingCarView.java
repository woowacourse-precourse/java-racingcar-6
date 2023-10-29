package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.GameInfo;
import racingcar.domain.RacingCar;
import racingcar.utils.Validator;

public class RacingCarView {
    private static final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT = "시도할 회수는 몇회인가요?";
    private static final String WINNER = "최종 우승자 : ";
    private static final String RESULT = "실행 결과";
    public static GameInfo gameStart(){
        printStart();
        List<RacingCar> cars = getRacingCarName();
        Validator.validate(cars);
        printAttempt();
        int count = getAttempt();
        printBlank();
        return new GameInfo(cars, count);

    }
    public static void printResult(){
        System.out.println(RESULT);
    }
    private static List<RacingCar> getRacingCarName(){
        return Arrays.stream(Console.readLine().split(","))
            .map(RacingCar::new)
            .toList();
    }
    private static int getAttempt(){
        return Validator.StringToInt(Console.readLine());
    }
    private static void printStart(){
        System.out.println(START);
    }
    private static void printAttempt(){
        System.out.println(ATTEMPT);
    }
    public static void printWinnerName(String name){
        System.out.println(WINNER+name);
    }
    public static void printBlank(){
        System.out.println();
    }

}
