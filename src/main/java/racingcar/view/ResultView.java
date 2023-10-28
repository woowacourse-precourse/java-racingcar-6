package racingcar.view;

public class ResultView {
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자";
    private static final String DELIMITER = " : ";
    private static final String DASH = "-";
    private static final String COMMAS = ", ";

    public void printResultTitle(){
        System.out.println(RESULT);
    }

    public void printCarState(String name, int position){
        System.out.println(name+DELIMITER+DASH.repeat(position));
    }

    public void printWinner(String[] names){
        System.out.print(WINNER+DELIMITER+String.join(COMMAS, names));
    }
}
