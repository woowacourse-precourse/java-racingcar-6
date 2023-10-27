package racingcar;


import racingcar.controller.Controller;

//객체지향 프로그래밍!
//기능을 가지고 있는 클래스를 인스턴스화 한다
//필요한 기능을 각 인스턴스가 수행하게 한다
//각 결과를 종합한다
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.racingGame();
    }
}
