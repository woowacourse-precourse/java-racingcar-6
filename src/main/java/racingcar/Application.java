package racingcar;

public class Application {
    public static void main(String[] args) {
        // 이름 입력 받기
        NameInput.getNameInput();
        NameInput.checkNameInput();
        Car[] carArr = NameInput.setNameInput();
        // 회수 입력 받기
        String input = CountInput.getCountInput();
        CountInput.checkCountInput(input);
        // 전체 게임 진행
        MoveForward.totalGame(carArr, CountInput.getCount());
        // 우승자 선정
        SelectWinner.selectWinner(carArr);
        SelectWinner.printWinner();
    }
}
