package racingcar.view;

public class OutputView {
  public void displayCarName(){
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }
  public void displayGameCount(){
    System.out.println("시도할 회수는 몇회인가요?");
  }
  public void displayStart(){
    System.out.println("실행 결과");
  }
  public void displayResult(){
    System.out.println("pobi : -\n"
        + "woni : \n"
        + "jun : -"); //추후 모델로부터 값을 받아오기
  }

  public void displayWinner(){
    System.out.println("최종 우승자 : "+"pobi, jun"); //추후 모델로부터 값을 받아오기
  }
}
