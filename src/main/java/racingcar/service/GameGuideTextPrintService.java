package racingcar.service;

public class GameGuideTextPrintService {
    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void gameResult() {
        System.out.println("실행 결과");
    }

    public void gmaeWinner() {
        System.out.print("최종 우승자 : ");
    }
}
