package racingcar;



public class Racing {
    private List<Car> cars = new ArrayList<>();
        private int numberOfRacing;
        public void gameStart() {
        init();
        for (int i = 0; i < this.numberOfRacing; i++) {
            race();
        }
        System.out.println(result);
    }
}
