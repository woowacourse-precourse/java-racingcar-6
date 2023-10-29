package racingcar.domain;

import java.util.List;

public class View {
    public void viewResult(List<String> carName){
        GenerateRandomNum num = new GenerateRandomNum();
        String result = "";
        System.out.println("실행 결과");
        for (int i = 0; i < carName.size(); i++){
            System.out.println(carName.get(i) + " : " + result);
        }

    }
}
