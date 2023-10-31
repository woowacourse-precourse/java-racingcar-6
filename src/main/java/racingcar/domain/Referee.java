package racingcar.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee{

    private List<Racer> group;
    private int playCount;
    private int maxDistance;

    public Referee() {
        group = new ArrayList<>();
        playCount = maxDistance = 0;
    }

    public void addGroup(String name) { // 해당 이름의 player를 group에 추가
        Racer player = new Racer(name);
        group.add(player);

        this.playCount += 1;
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

    public void run() {

    }
}
