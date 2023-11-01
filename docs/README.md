# 기능 구현 

## OutputView (View) 
의존성 x
- [x] 이름 입력 받는 문장 출력
- [x] 시도할 회수 받는 문장 출력
- [x] 실행 결과 출력 (컨트롤러로부터 데이터 받음)
- [x] 최종 우승자 출력

## InputView (View)
의존성 x
- [x] 이름 입력 받는 문장 출력
- [x] 시도할 회수 받는 문장 출력
- [x] 실행 결과 출력 (컨트롤러로부터 데이터 받음)
- [x] 최종 우승자 출력

## Car (Model)
의존성 x
- [x] 이름, 이동 횟수 저장
- [x] 랜덤 값 생성 기능
- [x] 값이 4이상인 경우 이동 횟수를 +1하는 기능
- Car에서 random값을 만드는 것은 좋다.
- 하지만 문제는 Random값의 Upper Bound와 LowerBound



## CarController (Controller)
Model과 View에 의존성을 가짐
- [x] 자동차 리스트에 저장
- [x] 시도 횟수 만큼 실행 결과 출력하기
- [x] start() 함수 구현
- [x] 사용자로부터 입력된 값의 유효성 검증
- 이름은 5자 이하만 가능(양 옆 공백 제외 5자)
- 이름 중복 불가능
- 자동차가 한 대인 경우 불가능


## CarDto
View에서 출력을 하기 위해 Model의 정보를 넘겨주기 위함

---

# Test

## CarView (View)
- [ ] addCarMovingLine() test
- [ ] printResult() test
- [ ] printWinner() test
- 공동 우승 출력 되도록 구현

## Car (Model)
- [ ] isMoving(), generateRandomNumber() test
- 랜덤한 조건의 함수를 어떻게 테스트 하는지 공부 하기

## CarController (Controller)
- [ ] validInput() test
- 이름은 5자 이하만 가능(양 옆 공백 제외 5자)
- 이름 중복 불가능
- 자동차가 한 대인 경우 불가능
- [ ] carListMoving() test
- 랜덤한 조건의 함수를 어떻게 테스트 하는지 공부 하기
- [ ] converCarToCarDto() test
- 객체의 타입 비교 어떻게 테스트 하는지 공부 하기
- [ ] start() test
- 가장 마지막에 테스트 하기



---

# Refactoring

## CarView (View) -> InputView와 OutputView로 분리
- [ ] InputView 기능 추가하고 OutputView와 분리하기
- [ ] printWinner에서 max값 찾는 부분 함수로 추출하기
- [ ] printResult에서 for-each 구문 함수로 추출하기

## Car (Model) 
- [ ] getter 대체하기
- [ ] RandomNumber클래스에 static을 활용해서 랜덤 숫자 생성 로직 분리

## CarController (Controller)
- [ ] InputView 사용해서 입력 받도록 변경하기
- [ ] start() 내부 for문 함수로 추출하기
- [ ] validateInput() 로직 간단하게 변경하기

## CarDto
- [ ] getter 대체하기

## carList -> Cars 일급 컬렉션 분리
- CarController에 종속적이던 carList를 Cars로 Wrap하여서 의존성을 낮춤

## Random number