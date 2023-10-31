package racingcar.domain;

import java.util.List;
import java.util.Map;

public class OutputCarName {
    List<String> carNameList;
    Map<String, Integer> point;

    public OutputCarName(List<String> carNameList, Map<String, Integer> point) {
        this.carNameList = carNameList;
        this.point = point;
    }

    public void outpuCarName() {
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < carNameList.size(); i++) {
            int randomNumber = numberGenerator.createRandomNumber();
            System.out.print(carNameList.get(i) + " : ");

            if (numberGenerator.checkMoreThanFour(randomNumber)) {
                point.replace(carNameList.get(i), point.get(carNameList.get(i)) + 1);
            }

            System.out.println(outputPoint(i));
        }
    }

    public String outputPoint(int index) {
        String result = "";
        for (int i = 0; i < point.get(carNameList.get(index)); i++) {
            result += "-";
        }

        return result;
    }
}
