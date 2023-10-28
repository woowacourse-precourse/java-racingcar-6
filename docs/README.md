## OutputView
- 자동차 이름 입력하라는 문구 출력
    ```java
    void printCarNameInputGuide()
    ```
- 시도 횟수 입력하라는 문구 출력
    ```java
    void printTryNumInputGuide()
    ```
- 차수별 실행 결과 출력
    ```java
    void printRacingResult()
    ```
- 우승자 출력
    ```java
    void printWinner()
    ```

## InputView
- 자동차 이름 입력 받는 기능
    ```java
    List<String> InputCarName()
    ```
- 시도 횟수 입력 받는 기능
    ```java
    int InputTryNum()
    ```

## Car
- 자동차 객체 생성
    ```java
    Car(String name);
    ```
- 전진 횟수 증가 기능
    ```java
    void increaseForwardNum();
    ```
- 전진 횟수 조회 기능 
    ```java
    int getForwardNum();
    ```
- 무작위 값을 조회하는 기능
    ```java
    int getRandomNum();
    ```
- 자동차 이름을 조회하는 기능
    ```java
    String getName();
    ```
- 무작위 값을 초기화하는 기능
  ```java
  void initRandomNum();
  ```

## RacingController
- 경주 게임 동작
    ```java
    void run();
    ```
- 입력한 차 이름에 대한 차 객체를 리스트에 담는 기능
    ```java
    List<Car> toCarList(String carNames);
    ```
- 전진할지 멈출지 판단하는 기능
    ```java
    boolean isMove(Car car);
    ```
- 전진하는 기능
    ```java
    void modifyForwardNum(List<Car> carList);
    ```
- 누가 우승자인지 판단하는 기능
    ```java
    List<String> findWinners(List<Car> carList);
    ```

## Validator
- 자동차 입력 구분은 ,로 하고 있는가
    ```java
    boolean isIdentifierComma(String carNameInput)
    ```
- 시도 횟수에 숫자로 입력하는가
    ```java
    boolean isTryNumInteger(String tryNum)
    ```
- 시도 횟수가 1 이상인가
    ```java
    boolean isTryNumPositiveNum(String tryNum)
    ```
- 자동차 이름이 5자 이하인가
    ```java
    boolean checkCarNameLength(String carName)
    ```
- 자동차 이름 입력이 중복되는 경우
    ```java
    boolean checkDuplicateCarName(String carName)
    ```

