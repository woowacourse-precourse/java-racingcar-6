package racingcar.domain;
/* Car 하나하나 관리 하는 클래스
*  이름
*  위치
*  전진 기능
*  후진 기능
* */
public class Car {
    private String carName;
    private int location;
    public Car(String carName) {
        this.carName = carName;
    }

    // 전진 기능
    public void forward() {
        this.location++;
    }

    // 후진 기능
    public void backward() {
        this.location--;
    }
}
