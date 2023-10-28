package racingcar.view;

import racingcar.controller.UserController;

public class View {
    private final UserController userController = new UserController();

    public void main(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userController.makeUser();
        System.out.println("시도할 회수는 몇회인가요?");
        System.out.println("실행 결과");
    }

}
