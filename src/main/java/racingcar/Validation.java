package racingcar;

public class Validation {
    public void carNameValidationCheck(String[] carArray) {
        for (String car : carArray) {
            if (car == null || car.trim().isEmpty()) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
            if (car.length() > 5) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    public void carMoveValidationCheck(String carMove) {
        int number = Integer.parseInt(carMove);
        if (number <= 0) {
            throw new NumberFormatException("입력하신 값이 0보다 작거나 같습니다.");
        }
    }
}
