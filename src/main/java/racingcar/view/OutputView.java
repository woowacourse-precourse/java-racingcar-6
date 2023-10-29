package racingcar.view;

import java.util.List;

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

        System.out.println();
        System.out.println("실행 결과");
    }

    public void printWinner(List<String> names){
        StringBuilder concatenatedNames = new StringBuilder();
        for (String name : names) {
            concatenatedNames.append(name);
            concatenatedNames.append(", ");
        }

        // 마지막 쉼표와 공백 제거
        String result = concatenatedNames.substring(0, concatenatedNames.length() - 2);

        System.out.println("최종 우승자 : "+result);

    }


}
