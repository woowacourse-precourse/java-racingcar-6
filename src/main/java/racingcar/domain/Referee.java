package racingcar.domain;


import java.util.ArrayList;
import java.util.List;

public class Referee{

  List<Racer> group;
  int playCount;

  public Referee(){
    group = new ArrayList<>();
    playCount = 0;
  }

  public void addGroup(String name){
    Racer player = new Racer(name);
    group.add(player);

    this.playCount += 1;
  }

  public void printProgress(){
    for(Racer player : group){
        player.printDistance();
    }
  }

  public void run(){



  }
}
