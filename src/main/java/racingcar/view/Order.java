package racingcar.view;

import java.util.List;

public class Order {
    private static final String INPUT_CARNAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROTATE_COUNT = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String SEPARATOR = ", ";
    private static final String WINNER = "최종 우승자 : ";
    private static final String FORWARD = "-";
    public void racingStart(){
        System.out.println(INPUT_CARNAME);
    }
    public void rotateCount(){
        System.out.println(ROTATE_COUNT);
    }

    public void gameProcess(){
        blank();
        System.out.println(GAME_RESULT);
    }

    public void blank(){
        System.out.print("\n");
    }

    public void printWinner(){
        System.out.print(WINNER);
    }

    public void noWinner(){
        System.out.print("");
    }

    public String step(String location){
        return location + FORWARD;
    }

    public void printLast(List<String> winner, int index){
        System.out.print(winner.get(index));
    }

    public void printPeoPle(List<String> winner, int index){
        System.out.print(winner.get(index) + SEPARATOR);
    }
}
