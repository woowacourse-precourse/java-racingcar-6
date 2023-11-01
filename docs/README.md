## 🤖우테코 프리코스 2주차 : 자동차 경주🤖

- 자동차 경주를 통해 우승자를 출력하는 게임

### 🛠️기능 구현🛠️

1. 사용자에게 자동차 이름과 수행 횟수를 입력받는다.
    1. 자동차 이름은 ','로 구분된다.
    2. 수행 횟수는 숫자의 형태로 입력된다.
    3. 올바르지 않은 값을 입력하면 `IllegalArgumentException`을 발생시킨다.
2. 각 자동차마다 0~9의 난수를 발생시킨다.
3. 난수가 4 이상일 시, 전진한다.
4. 2~3의 과정을 수행 횟수만큼 반복한다.
5. 레이싱이 끝난 뒤, 우승자를 출력한다.
    1. 우승자는 여러명일 수 있으며, ', '로 구분하여 출력한다.

<br>
   
### 📝 상세 기능 구현 📝

 - 💾 Domain(Model)
   - `Car` : 자동차 각각의 정보를 담는 객체입니다.
   - `Cars` : Car를 담는 List<Car>를 랩핑한 일급 컬렉션입니다. 
   - `Race` : 레이싱의 정보인 Count, Times, Cars를 담으며, 게임의 상세 진행에 대한 메서드를 담고 있습니다.
 - 🖥️ View
   - `InputView` : 사용자 입력 값(자동차, 횟수)을 받습니다.
   - `OutputView` : 게임 운영 및 결과를 출력하는 메서드를 담고 있습니다.
 - 🔌 Controller
   - `RacingController` : 경주의 전반적인 운영을 책임집니다.
 - ✂️ Utils
   - `InputValidator` : input 값의 유효성 검사를 시행합니다.
   - `RandomNumberGenerater` : 0~9 사이의 랜덤 숫자를 생성합니다.

<br>

### 💾 파일구조 💾

```
📦src
 ┣ 📂main
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂racingcar
 ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┗ 📜RacingController.java
 ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┣ 📜Car.java
 ┃ ┃ ┃ ┃ ┣ 📜Cars.java
 ┃ ┃ ┃ ┃ ┗ 📜Race.java
 ┃ ┃ ┃ ┣ 📂utils
 ┃ ┃ ┃ ┃ ┣ 📜InputValidator.java
 ┃ ┃ ┃ ┃ ┗ 📜RandomNumberGenerater.java
 ┃ ┃ ┃ ┣ 📂view
 ┃ ┃ ┃ ┃ ┣ 📜InputView.java
 ┃ ┃ ┃ ┃ ┗ 📜OutputView.java
 ┃ ┃ ┃ ┗ 📜Application.java
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┣ 📂racingcar
 ┃ ┃ ┃ ┣ 📜ApplicationTest.java
 ┃ ┃ ┃ ┣ 📜CarsTest.java
 ┃ ┃ ┃ ┣ 📜CarTest.java
 ┃ ┃ ┃ ┗ 📜RaceTest.java
 ┃ ┃ ┗ 📂study
 ┃ ┃ ┃ ┗ 📜StringTest.java
```
