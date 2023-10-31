package racingcar;

import Util.Converter;
import Util.NumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final Input input = new Input();
    private static final Referee referee = new Referee();
    private static final String RESULT_MESSAGE =  "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER_FOR_INPUT = ",";
    private static final String DELIMITER_FOR_OUTPUT = ", ";
    private static final List<Car> cars = new ArrayList<>();
    private static String carsName;
    private static int tryNum;

    public static void main(String[] args) {
        init();
        startRace();
        raceOver();
        // 정상 종료 시 혹은 에러 발생에 의한 종료 시 close (필수적인 부분인지?)
//        Console.close();
    }

    public static void init() {
        getInput();
        makeCars();
    }

    public static void startRace() {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < tryNum; i++) {
            runRound();
            System.out.println();
        }
    }

    public static void raceOver() {
        List<String> winners = referee.judgeWinners(cars, Calculator.MaxMove(cars));
        printWinners(winners);
    }

    public static void getInput() {
        carsName = input.askCarsName();
        String tryNumString = input.askTryNum();
        tryNum = Converter.StringToInt(tryNumString);
        InputValidator.TryNum(tryNum);
    }

    public static void makeCars() {
        for (String name : Converter.StringToStringArray(carsName, DELIMITER_FOR_INPUT)) {
            cars.add(new Car(name));
        }
    }

    public static void runRound() {
        cars.forEach(car -> {
            int randomNumber = NumberGenerator.createRandomNumber();
            boolean isMove = referee.judgeMoveOrStop(randomNumber);
            car.moveOrStop(isMove);
        });
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNERS_MESSAGE);
        String winnerList = String.join(DELIMITER_FOR_OUTPUT, winners);
        System.out.println(winnerList);
    }
}
