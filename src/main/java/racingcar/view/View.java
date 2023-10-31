package racingcar.view;

import java.util.List;

public class View {
    public static View instance;

    public static View getInstance() {
        if(instance == null){
            instance = new View();
        }
        return instance;
    }
    public void initView(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void tryNumberView(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void resultView(){
        System.out.println("실행 결과");
    }
    public void resultViewperIter(String[] carNameList, List<String>resultList){
        for(int i=0; i<carNameList.length; i++){
            System.out.println(carNameList[i]+" : "+resultList.get(i));
        }
        System.out.println();
    }

    public void winnerView(List<String> winners){
        String exitString = "최종 우승자 : ";
        exitString += String.join(", ", winners);
        System.out.println(exitString);
    }
}
