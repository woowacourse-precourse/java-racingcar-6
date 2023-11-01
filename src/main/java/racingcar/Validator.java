package racingcar;

public class Validator {
        private String carNames;

        private String tryCount;
        public void nameValidator(String nameString){
                this.carNames= nameString;
                nameException();
        }
        public void tryCountValidator(String countString){
                this.tryCount = countString;
                tryCountException();
        }
        private void nameException(){

                if(carNames.length() > 5) {
                        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
                }
                if(carNames.isEmpty()) {
                        throw new IllegalArgumentException("공백인 자동차 이름이 있습니다.");
                }
                if(carNames.contains(" ")) {
                        throw new IllegalArgumentException("자동차 이름에 공백이 있습니다.");
                }
                //특수문자 포함된 경우
                if(!carNames.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*" )) {
                        throw new IllegalArgumentException("자동차 이름에 특수문자가 있습니다.");
                }

        }
        private void tryCountException(){

                if(!tryCount.matches("\\d")){
                        throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
                }
                if (Integer.parseInt(tryCount) < 1) {
                        throw new IllegalArgumentException("시도 횟수는 1이상만 가능합니다.");
                }
        }

}
