# 기능 목록

## 게임 과정
# 🏎️ 1. 자동차 입력
## Car클래스
#### (1) selectCars 메소드 : 사용자가 입력한 자동차를 반환
#### (2-1) makeRacingCarList 메소드 : 사용자가 입력한 자동차들을 ","를 기준으로 분리하여 리스트에 저장
#### (2-2) CustomizedException클래스의 numberUpException을 통해 5글자 이상 넘어가면 IllegalArgumentException이 나타나도록 설정
# 👌 2. 시도할 횟수 입력

## Race클래스
#### (1) numberOfGameRound 메소드 : 시도할 횟수를 사용자가 입력하여 설정하는 기능


# 🙆 🙅 3. 자동차의 전진을 결정
#### (1) racingByRandomNumber메소드 : 자동차마다 4이하의 숫자가 나타나면 전진하지 않고 4이상이 나오면 전진

# ⏪ 4. 라운드 수만큼 3을 반복
#### (1) repeatRacing 메소드 : 3번 과정을 입력돈 라운드 수만큼 반복한다.

# 🏆 5. 전진을 가장 많이한 자동차(들)을 뽑아 우승자로 출력
## Winner클래스
#### (1) findWinners메소드 : carList와 goCount를 파라미터로 받아 우승자 도출하는 기능
#### (1-1) findMaxNumberAndToSaveIndexOfMaxNumber메소드 : 전진을 가장 많이한 자동차의 전진 횟수를 sort를 통해 알아내고 몇 번 인덱스에 그 전진횟수가 있는지 알아내는 기능
#### (1-2) findWinnerCarByIndexOfMaxNumber메소드 : (1-1)의 메소드를 통해 알아낸 인덱스들을 통해 winner들의 이름을 뽑아 winner리스트에 저장
#### (1-3) printWinner메소드 : (1-2)에서 저장한 winner리스트에서 승리자들을 출력하는 기능
