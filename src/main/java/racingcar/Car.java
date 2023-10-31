package racingcar;

public class Car {

  String playerName;
  int forwordCount;
  int FORWARD_MIN_CONDITION = 4;

  public Car(String playerName){
    this.playerName = playerName;
    this.forwordCount = forwordCount;
  }

  public String getPlayerName(){
        return playerName;
  }

  public int getForwardCount(){
    return forwordCount ++;
  }
  pu
  public void run(int count){
      if(count >= FORWARD_MIN_CONDITION){
        forwordCount ++;
      }
  }

}
