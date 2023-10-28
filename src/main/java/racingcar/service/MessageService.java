package racingcar.service;

public class MessageService {

    // 공통처리
    public void questionCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void questionTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    // 값마다 다른것
    public void printProcess(String name) {
        System.out.print(name + " : ");
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }


}
