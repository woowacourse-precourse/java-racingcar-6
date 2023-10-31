# 2주차 미션: 자동차 경주 게임 구현 기능 목록

# Model

## ✅ 랜덤 수 생성 기능
- ✅ getRandomNumber 메서드 구현
  - ✅ camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 0에서 9사이의 랜덤 숫자 생성

## ✅ 전진/후진 확인 기능
- ✅ checkForwardOrStop 메서드 구현
  - ✅ 입력한 숫자가 4이상일 경우 1을 리턴, 그렇지 않을 경우 0을 리턴

## ✅ Count 증가 기능
- ✅ putCarResult 메서드 구현
  - ✅ 입력한 값이 1이면 이름에 항목 count를 증가

# View

## ✅ 게임 시작 메시지 출력 기능
- ✅ displayGameStartMessage  메서드 구현
  - ✅ 게임 시작 안내 메시지 <a>경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)</a> 출력

## ✅ 시도 회수 입력 메시지 출력 기능
- ✅ displayPlayCountMessage  메서드 구현
  - ✅ 플레이어 시도 회수 입력 안내 메시지 <a>시도할 회수는 몇회인가요?</a> 출력

## ✅ 게임 실행 결과 메시지 출력 기능
- ✅ displayPlayResult  메서드 구현
  - ✅ 실행 결과 출력 <br><a>ex)<br> pobi : - <br>woni :<br>jun : -</a>

## ✅ 게임 우승자 출력 메시지 출력 기능
- ✅ displayWinner  메서드 구현
  - ✅ 최종 우승자 출력 <a>ex) 최종 우승자 : pobi</a>
  - 
## ✅ 숫자에 맞춰 대시 기호 변환
- ✅ generateDashes 메서드 구현
  - ✅ 입력한 수에 맞춰 '-' 문자열을 반환
  
# Controller

## ✅ 경주 할 자동차 이름 입력
- ✅ getCarsName 메서드 구현
  - ✅ 사용자들에게 자동차 이름을 입력 받음

## ✅ 시도할 회수 입력
- ✅ getPlayCount 메서드 구현
  - ✅ 사용자들에게 시도활 회수를 입력 받음


  
## ✅ 입력한 값 검증
- ✅ validateInputIsNumber  메서드 구현
  - ✅ 입력한 수가 숫자가 맞는지 검증
  - 만족하지 않으면 <mark>IllegalArgumentException</mark> 예외 발생
- ✅ validateNameInput  메서드 구현
  - ✅ 입력한 자동차들의 이름이 규칙에 맞게 잘 입력 됐는지 검증
  - 만족하지 않으면 <mark>IllegalArgumentException</mark> 예외 발생
- ✅ validateNameInputContainsComma  메서드 구현
  - ✅ 입력한 자동차들의 이름이 컴마를 포함 하였는지 검증
- ✅ validateNameLength  메서드 구현
  - ✅ 입력한 자동차의 이름이 5자리 이하 인지 검증

## ✅ 우승자 추출 기능
- ✅ getWinner
  - ✅ 가장 길이가 긴 자동차 이름을 출력, 단 동일 항목에 대해선 쉼표(,)를 이용하여 구분

## ✅ 게임 시작 기능
- ✅ playGame 메서드 구현
  -  프로그램 시작
