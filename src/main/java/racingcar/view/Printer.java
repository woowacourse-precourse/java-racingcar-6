package racingcar.view;

import java.util.List;

public class Printer {
    public static String ERROR_CAR_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하여야 합니다.";
    public static String ERROR_CAR_NAME_FIRST_WHITE_SPACE = "자동차 이름은 시작이 공백이면 안됩니다.";

    public static void printWhiteSpace(){
        System.out.println();
    }
    public static void printQuestionCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void printQuestionTryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public static void printResultStart() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(String carName, Integer forwardNumber) {
        System.out.println(carName + " : " + "-".repeat(forwardNumber));
    }

    public static void printWinner(List<String> winners){
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for(int i = 0; i < winners.size(); i++){
            sb.append(winners.get(i));
            if(i != winners.size()-1){
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
