package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.controller.CarController;
import racingcar.dto.CarsResponseDto;
import racingcar.dto.NamesRequestDto;
import racingcar.dto.WinnerResponseDto;
import racingcar.util.Log;
import racingcar.view.View;

public class Application {
    private static final String DIVIDE_CONDITION = ",";
    private static final String NUMBER_REGEX = "^[1-9]+[0-9]*$";
    private static final int NAME_SIZE = 5;


    private static final CarController carController = new CarController();

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Log.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carController.createCars(makeNamesRequestDto(Console.readLine()));

        Log.println("시도할 회수는 몇회인가요?");
        int tryCount = getTryCount(Console.readLine());
        Log.println("");

        Log.println("실행 결과");
        for (int requestCount = 0; requestCount < tryCount; requestCount++) {
            CarsResponseDto carsResponseDto = carController.raceCar();
            View.printProgress(carsResponseDto);
        }
        Log.print("최종 우승자 : ");
        WinnerResponseDto winners = carController.getWinners();
        View.printWinner(winners);

    }

    private static NamesRequestDto makeNamesRequestDto(String input) {
        List<String> names = divideNamesByComma(input);

        for (String name : names) {
            if (!checkNameSize(name)) {
                throw new IllegalArgumentException("[ERROR] 이름 길이는 5자 이하입니다.");
            }

        }
        return NamesRequestDto.createNamesRequestDto(names);
    }

    private static List<String> divideNamesByComma(String names) {
        return Arrays.stream(names.split(DIVIDE_CONDITION)).toList();
    }

    private static boolean checkNameSize(String name) {
        return name.length() <=NAME_SIZE;
    }

    private static int getTryCount(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        return Integer.parseInt(input);
    }

    private static boolean isNumber(String input) {
        return input.matches(NUMBER_REGEX);
    }
}
