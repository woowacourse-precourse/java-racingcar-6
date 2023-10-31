package racingcar.domain;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee{
    private List<Racer> group;
    private int playerCount;
    private int maxDistance;

    public Referee() {
        group = new ArrayList<>();
        playerCount = maxDistance = 0;
    }

    public void addGroup(String name) {
        Racer player = new Racer(name);
        group.add(player);

        this.playerCount += 1;
    }

    public void printProgress() { // 현재까지의 모든 player 진행상황을 출력
        for (Racer player : group) {
            player.printDistance();
        }
    }

    public void findMaxDistance(){

      for(Racer player : group){
        compareMax(player);
      }
    }

  public void compareMax(Racer player){

      if(this.maxDistance < player.getDistance())
          this.maxDistance = player.getDistance();
  }

  public void printWinner() {
    List<String> members = new ArrayList<>();

    for (Racer player : group)
      addMaxPlayer(members, player);

    String result = String.join(", ", members);
    System.out.println(result);
  }

  public void addMaxPlayer(List<String> members, Racer player) { // 해당 player가 최대 전진거리 일 경우 우승자에 추가함
    if (player.getDistance() >= this.maxDistance)
      members.add(player.getName());
  }

  public void readPlayer(String str){
        String[] player = str.split(",");

        for(String name : player){
            Judgment.isOverFiveLength(name); // 자동차 이름 길이가 5를 초과하는지 확인
            addGroup(name);
        }
  }



    public void run() {

    }
}
