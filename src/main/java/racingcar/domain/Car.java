package racingcar.domain;

public class Car {

    private int position;
    private String name;

    public Car(String name) {
        //생성시 이름 철자 개수 제한
        if (name.length() > 5) {
            throw new IllegalArgumentException();   //종료 되로록 try/catch 사용 X
        }
    }
}
