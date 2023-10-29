package racingcar;

import java.util.*;

public class Application {
    private static RaceView view;
    private static CarList carList;

    public static void main(String[] args) {
        view = new RaceView();

        // TODO: string을 List<String>으로 변환하면서 검증까지 하는 메소드를 만드는게 더 좋지 않을까?
        view.printCarListInputMessage();
        String carListInput = view.getCarListInput();
        validateCarListInput(carListInput);
        List<String> nameList = Arrays.asList(carListInput.split(","));

        carList = new CarList(RacingUtil.createCarsFromNames(nameList));

        // TODO: 시도횟수를 저장하는 객체를 만들어서 저장시 검증 과정을 거치게 만드는건 어떨까?
        view.printAttemptInputMessage();
        String attemptInput = view.getAttemptInput();
        validateAttemptInput(attemptInput);
        int attempt = Integer.parseInt(attemptInput);

        // TODO: RacingModel 클래스를 만들어 List<Car>을 포함하는 형태로 변경하자
        System.out.println("실행 결과");
        for (int i = 0; i < attempt; i++) {
            carList.moveRandomEachCars();
            view.printProgress(carList.getCarList());
        }

        view.printWinners(carList.findWinners());
    }

    public static void validateCarListInput(String input) {
        List<String> inputList = List.of(input.split(",", -1));
        validateCarListInputBlank(inputList);
        validateCarListInputLength(inputList);
        validateCarListInputUnique(inputList);
    }

    public static void validateCarListInputBlank(List<String> inputList) {
        for (String name : inputList) {
            validateCarNameBlank(name);
        }
    }

    public static void validateCarNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }
    }

    public static void validateCarListInputLength(List<String> inputList) {
        for (String name : inputList) {
            validateCarNameLength(name);
        }
    }

    public static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarListInputUnique(List<String> inputList) {
        Set<String> seen = new HashSet<>();
        for (String name : inputList) {
            if (seen.contains(name)) {
                throw new IllegalArgumentException();
            }
            seen.add(name);
        }
    }

    public static void validateAttemptInput(String input) {
        validatePositiveNumber(input);
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePositiveNumber(String input) {
        validateNumber(input);
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
