package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.message.ErrorMessage;
import racingcar.message.SystemMessage;

public class Racing {
    static final List<Car> participants = new ArrayList<>();
    static int tryCount;

    public static void run() {
        getCarNameInput();
        getTryCountInput();
        runEachRound();
        getFinalWinner();
    }

    private static void getFinalWinner() {
        participants.sort((o1, o2) -> o2.advance - o1.advance);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Car firstWinner = participants.get(0);
        System.out.print(SystemMessage.FINAL_WINNER.getMessage()); // TODO :: MVC 패턴을 적용한다면 뷰(화면)에 관련한 코드를 분리하여야 한다.
        try {
            bw.write(firstWinner.name);
            if (participants.size() > 1) {
                checkJointFirstPlace(firstWinner, bw);
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO :: MVC 패턴을 적용한다면 뷰(화면)에 관련한 코드를 분리하여야 한다.
    private static void checkJointFirstPlace(Car firstWinner, BufferedWriter bw) throws IOException {
        for (int i = 1; i < participants.size(); i++) {
            if (Objects.equals(participants.get(i).advance, firstWinner.advance)) {
                bw.write(", ");
                bw.write(participants.get(i).name);
            }
        }
    }

    private static void runEachRound() {
        System.out.println(SystemMessage.ROUND_RUN_RESULT.getMessage());
        while (tryCount-- > 0) {
            participants.forEach(Car::rollDice);
            participants.forEach(car -> {
                try {
                    car.printStatus();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println();
        }
    }

    private static void getTryCountInput() {
        System.out.println(
                SystemMessage.INPUT_TRY_COUNT.getMessage()); // TODO :: MVC 패턴을 적용한다면 뷰(화면)에 관련한 코드를 분리하여야 한다.
        tryCount = validateTryCount(Console.readLine());
        System.out.println();
    }

    public static int validateTryCount(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException(ErrorMessage.NOT_AN_INTEGER_OVER_ZERO.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    private static void getCarNameInput() throws IllegalArgumentException {
        System.out.println(SystemMessage.INPUT_CAR_NAME.getMessage()); // TODO :: MVC 패턴을 적용한다면 뷰(화면)에 관련한 코드를 분리하여야 한다.
        String[] carNameInput = Console.readLine().split(",");
        for (String name : carNameInput) {
            validateCarName(name);
            participants.add(new Car(name));
        }
    }

    public static void validateCarName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_MUST_BE_UNDER_5.getMessage());
        }
    }
}
