package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String inputCarNames;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarNames = Console.readLine();
        try {
            String[] carNames = carNames(inputCarNames);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }



    }

    public static String[] carNames(String input) {
        String[] carNames =  input.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이내이어야 합니다.");
            }
        }
        return carNames;
    }
}
