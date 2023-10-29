package racingcar.view;

public class Printer {
    public static String ERROR_CAR_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하여야 합니다.";
    public static String ERROR_CAR_NAME_FIRST_WHITE_SPACE = "자동차 이름은 시작이 공백이면 안됩니다.";

    public static void printWhiteSpace(){
        System.out.println();
    }
    public static void printQuestionCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

}
