## ✏️ 구현할 기능 목록

### 객체

1. car : 자동차

- 자동차 이름 저장하는 변수
- 이동 거리 저장하는 변수

- 메서드
    - move() : 조건에 만족하여 전진 할 때 사용

# Enum

- Standard : 무작위 숫자가 4 이상인지 비교

### Service (클래스 별 테스트 코드 추가)

```
1. PlayRacingGame : play(int moveCount, List<Car> cars), printCarStatus(List<Car> cars)
2. PrintResult : printWinner(List<Car> cars)
3. UserInput : inputCarName(), tryCount()
4. UserInputValidate : validate(String[] names)
```

### 메서드 정의

```
1. inputCarName() : 자동차 이름 입력 
2. validate(String[] names) : 자동차 이름 valid (이름은 5자 이하만 가능)
3. tryCount() : 시도할 회수는 입력
3. play(int moveCount, List<Car> cars) : 레이싱 게임 시작
4. printCarStatus(List<Car> cars) : 게임 중간 캐릭터별 전진 상황 출력
5. printWinner() : 최종 우승자 출력  
```

### 메서드 로직 설명