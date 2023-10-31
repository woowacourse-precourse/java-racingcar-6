package racingcar;

public class Validate {

    public static void validateInputCars(String inputCarsName) {
        if (inputCarsName.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력하실 수 없습니다.");
        }

        if (!inputCarsName.contains(",")) {
            throw new IllegalArgumentException("이름을 쉼표(,)를 기준으로 구분하여 2개 이상 입력하셔야 합니다.");
        }

        String[] names = inputCarsName.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("각 이름은 다섯 글자 이하로 입력해야 합니다.");
            }
        }
    }



}
