package racingcar.view;

public class OutputView {

    public void printEachCarResult(String s,int moveCount){
        System.out.print(s+" : ");
        for(int i=0;i<moveCount;i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printLineSpace(){
        System.out.println();
    }

    public void printResult(){
        System.out.println("실행 결과");
    }

}
