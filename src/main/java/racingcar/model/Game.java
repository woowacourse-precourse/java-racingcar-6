package racingcar.model;

import java.util.HashMap;

public class Game {
    //    private int stageTimes;
    private HashMap<String, Integer> cars;

//    public int getStageTimes() {
//        return stageTimes;
//    }

    public HashMap<String, Integer> getCars() {
        return cars;
    }

    public void addCar(String name) {
        cars.put(name, 0);
    }

    public void editStatus(String key) {
        Integer originalStatus = cars.get(key);
        cars.replace(key, originalStatus);
    }

//    public class GameBuilder {
//        private int stageTimes;
//        private HashMap<String, Integer> cars;
//
//        public GameBuilder() {
//        }
//
//        public GameBuilder(int stageTimes, HashMap<String, Integer> cars) {
//            this.stageTimes = stageTimes;
//            this.cars = cars;
//        }
//
//        public GameBuilder stageTimes(int stageTimes) {
//            this.stageTimes = stageTimes;
//            return this;
//        }
//
//        public GameBuilder cars(HashMap<String, Integer> cars) {
//            this.cars = cars;
//            return this;
//        }
//
//        public Game build() {
//            return new Game(this.stageTimes, this.cars);
//        }
//    }
}
