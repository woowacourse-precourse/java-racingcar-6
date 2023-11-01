package racingcar;

public class Validation {
    public static void validateCarName(String carNames){
        validateEmpty(carNames);
        validateCars(carNames);
    }

    public static void validateEmpty(String carNames){
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCars(String carNames){
        // ,로 split한 후, 비어있거나 스페이스바로 이루어진 이름이 있는지 확인
        String[] cars = carNames.split(",");
        for (String car : cars) {
            if (car == null || car.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

    }

    public static void validateRound(String round){
        if (round == null || round.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
