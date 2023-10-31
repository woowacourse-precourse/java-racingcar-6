# 자동차 경주 프로그램 기능 목록

## 자동차 N개 이름 입력
> Race.inputCarNames()
- "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분" 메시지 출력 
- 사용자로부터 자동차의 이름들을 입력 받음
- 쉼표(,)를 기준으로 이름 나누기

## 자동차 객체 생성
- String[]로 자동차 이름들을 파라미터로 함
- 이 이름들에 해당하는 car의 객체를 생성하여 list에 추가

## 이동 횟수 입력
> Race.inputMovingNumber()
- "시도할 회수는 몇회인가요?" 메시지 출력
- 사용자로부터 이동 횟수를 입력 받음

## 자동차들 위치 갱신
> Race.updateCarsPosition()
- 각 자동차들은 랜덤한 수 뽑기
- 이 수를 통해 자동차 위치 갱신
  - 수가 4 미만이라면 멈춤
  - 수가 4 이상이라면 전진

## 각 회차의 실행 결과 출력
> Race.displayCarMoving()
- 각 회차의 실행 결과를 출력
- 각 자동차들의 이름과, 위치 출력

## 가장 큰 자동차 위치 찾기
> Race.findMaxPosition()
- 자동차의 position 중 가장 큰 위치를 찾음

## 우승자 결정
> Race.findWinners()
- maxPosition과 동일한 값을 가지는 자동차를 찾음

## 우승자 안내 문구 출력
> Race.displayWinner()
- 우승자가 한 명일 경우 하나만 출력
- 우승자가 한 명 이상일 경우 쉼표(,)로 구분하여 출력

## 각 자동차 랜덤한 값 뽑기
> NumberGenerator.createRandomNumber()
- 0 ~ 9까지 사이의 무작위 값 뽑기

## 이름 입력 값이 없을 경우 예외 처리
> InputValidator.validateNamesIsEmpty()
- 자동차 이름 입력 값이 없을 경우 예외 처리
- 자동차 이름 입력 값이 존재할 경우 통과

## 이름 사이에 공백이 존재할 경우 예외 처리
> InputValidator.validateNameContainSpace()
- 자동차 이름에 공백이 존재할 경우 예외 처리
- 공백이 존재 하지 않을 경우 통과

## 이름이 5자 초과일 경우 예외 처리
> InputValidator.validateNameLength()
- 자동차 이름의 길이가 5를 초과할 경우 예외 처리
- 자동차 이름의 길이가 5 이하일 경우 통과

## 동일한 이름이 있을 경우 예외 처리
> InputValidator.validateDuplicateName()
- 입력한 자동차 이름에 중복 되는 이름이 있을 경우 예외 처리
- 중복 되는 이름이 없을 경우 통과

## 숫자 아닐 경우 예외 처리
> InputValidator.validateNotNumber()
- 시도 회수 입력시 숫자가 아닐 경우 예외 처리
- 숫자일 경우 통과

## 1보다 작을 경우 예외 처리
> validateNotNumber.validateNumberRange()
- 시도 회수가 1보다 작을 경우 예외 처리
- 1보다 클 경우 통과