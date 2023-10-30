package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String[] inputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = readLine().split(",");
        isCorrectName(nameList);
        return nameList;

    }
    private void isCorrectName(String[] nameList){
        for(int i=0; i<nameList.length;i++){
            if(nameList[i].length()>6 || nameList[i].isEmpty()){
                throw new IllegalArgumentException();
            }
        }
    }

    public String inputTrial(){
        System.out.println("시도할 회수는 몇회인가요?");
        String trial = readLine();
        isCorrectNumber(trial);
        return trial;
    }
    private void isCorrectNumber(String trial){
        
    }

}
