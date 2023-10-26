package racingcar.view;

public class PlayGameMsg {

    public void start(){
        System.out.println("\n실행 결과");
    }

    public void eachResult(String player, int num){
        System.out.printf("%s : %s%n", player, "-".repeat(num));
    }

    public void changeLine(){
        System.out.println();
    }

    public void end(String winner){
        System.out.printf("최종 우승자 : %s%n",winner);
    }
}
