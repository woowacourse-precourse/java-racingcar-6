# 구현할 기능 목록
## 1. 자동차 이름 분류하기
- InputHandler#makeCarNamesArray()
- 사용자에게 입력 받은 값을 구분자에 맞게 분류하여 배열로 반환한다.

## 2. 자동차 이름 입력 유효성 확인하기
- Validator#checkValidCarNames()
- 자동차 이름 목록을 전달받아 자동차 이름의 유효성을 확인한다.

## 3. 시도 횟수 입력 유효성 확인하기
- Validator#isValidNumberOfAttempts()
- 시도 횟수를 전달받아 0과 비교하여 유효성을 확인한다.

## 5. 랜덤 값 분석 및 변환하기
- NumericUtility#isNumberGreaterOrEqualToFour()
- 값을 전달 받아 4 이상이라면 True를 반환하고, 그 외에는 False를 반환한다.

## 6. 자동차 경주 게임 실행하기
- Judge#run()
- 자동차 경주 게임을 실행한다.

## 7. 자동차 생성하기
- Judge#setCars()
- 차량의 이름 정보를 바탕으로 여러 개의 차량을 생성한다.

## 8. 여러 개의 자동차 이동하기
- Judge#moveCars()
- 여러 개의 자동차를 이동시킨다.

## 9. 우승자 선택하기
- Judge#selectWinner()
- 자동차들의 이동 정보를 바탕으로 우승자를 선택한다.

## 10. 자동차 이동하기
- Car#move()
- 자동차가 전달받은 값만큼 이동한다.