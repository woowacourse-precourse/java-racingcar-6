# 기능 요구 사항

## 기능
- [x] 각 자동차에 이름을 부여하는 기능 - Car#Car()
- [x] 자동차를 전진 시키는 기능 - Car#moveForward()
- [x] 어떤 차가 우승했는지 계산하는 기능 - Race#evaluate()

# 입출력 요구 사항

## 입력
- [x] 자동차 이름을 쉼표(,)를 기준으로 구분해서 입력받는 기능. - Input#readCarName()
  - [x] 입력받은 값이 숫자,알파벳,구분자 이외의 문자일 경우 - InputValidation#checkCharacter()
  - [x] 자동차 이름이 중복될 경우 - InputValidation#checkOverlap()
  - [x] 자동차 이름의 길이가 1미만이거나 5를 초과할 경우 - InputValidation#checkNameLength()

- [x] 사용자가 몇 번의 이동을 할 것 인지를 입력받는 기능. - Input#readMoveCount()
  - [x] 입력받은 값이 숫자가 아닐 경우 - InputValidation#checkNumber()
  - [x] 이동 횟수가 1 미만일 경우 - InputValidation#checkNumberSize()
## 출력
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력하는 기능 - Output#printCar()
- [x] 우승자를 출력하는 기능 여러 명일 경우 쉼표(,)를 이용하여 구분. - Output#printWinners()

## 예외처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생
