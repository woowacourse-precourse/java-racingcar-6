package racingcar;

public class Model {
    String[] splitNames;
    int trial;
    Car[] raceCars;

    Model(String[] names, int n) {
        splitNames = names;
        trial = n;
        raceCars = new Car[splitNames.length];
        for (int i = 0; i < splitNames.length; i++) {
            raceCars[i] = new Car(splitNames[i]);
        }
    }
}
//모델은 데이터의 가공
//view에서 받음 이름 split, split한 이름으로 자동차 배열 반환