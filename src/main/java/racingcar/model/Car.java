package racingcar.model;

import racingcar.utils.RandomNumberGenerator;
public class Car {

        private String name;
        private int position=0;

        public Car(String name){
            this.name=name;
        }

        public Car(String name, int position){
            this.name=name;
            this.position=position;
        }

        public void updatePosition(){
            int randomNumber=RandomNumberGenerator.generateRandomNumber();
            if(randomNumber>=4){
                ++position;
            }
        }

        public String getName(){
            return name;
        }

        public int getPosition(){
            return position;
        }
}
