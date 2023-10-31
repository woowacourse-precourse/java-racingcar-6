package racingcar;

public class Car {
    private final String name;
    private int nowPosition;
  Car(String name){
      if(name.length()>Global.CAR_NAME_LIMIT){
          throw new IllegalArgumentException();
      }
   /*   for (int i = 0; i < name.length(); i++) {
          try{
            int A =  Integer.parseInt(name.charAt(i)+"");
            throw new IllegalArgumentException();
          }catch(NumberFormatException e){
            break;
          }
      }*/
      this.name = name;
  }
  public int moveForward(boolean isSuccess){
      if(isSuccess){
          nowPosition++;
      }
      return nowPosition;
  }
  public int getNowPosition(){
      return nowPosition;
  }
  public String getName(){
      return name;
  }
}
