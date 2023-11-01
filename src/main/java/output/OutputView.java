package output;

import java.util.List;

public class OutputView implements OutputInterface{
    static final private String inputMsg = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final private String tryNumMsg = "시도할 회수는 몇회인가요?";
    static final private String resultMsg = "실행 결과";
    static final private String runMsg = "-";
    static final private String winnerMsg = "최종 우승자 : ";
    @Override
    public void printInputMsg() {
        System.out.println(inputMsg);
    }

    @Override
    public void printTryNumMsg() {
        System.out.println(tryNumMsg);
    }

    @Override
    public void printResultMsg() {
        System.out.println(resultMsg);
    }

    @Override
    public void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    @Override
    public void printRunMsg(int count) {
        for(int i = 0; i < count; i++)
            System.out.print(runMsg);
        System.out.println();
        System.out.println();
    }

    @Override
    public void printWinnerMsg(List<String> winner) {
        System.out.print(winnerMsg +  winner.toString().substring(1, winner.toString().length()-1));
    }
}
