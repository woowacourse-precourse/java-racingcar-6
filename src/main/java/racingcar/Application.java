package racingcar;

import domain.InputUser;

/**
 * 객체 지향 프로그래밍
 * 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다.
 * 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다. (의인화)
 * 3. 각 결과를 종합한다.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        InputUser inputUser = new InputUser();
        System.out.println(inputUser.getNumber());

        // TODO: 프로그램 구현
    }
}
