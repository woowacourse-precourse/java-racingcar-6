package racingcar.model;

import java.util.Random;

public class CarDto {
   private final String name;
   private int position;

   public CarDto(String name){
       this.name=name;
       this.position=0;
   }

   public String getName(){
       return name;
   }

   public int getPosition(){
       return position;
   }

   public void move(boolean isMove){
       if(isMove){
           position++;
       }
   }

}
