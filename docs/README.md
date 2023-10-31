## 기능
- [ ] 경주할 자동차 입력 
  - 입력 하는 자동차 수는 제한이 없다. 
  - 자동차 이름은 5자 이하.
- [ ] 사용자가 입력한 자동차를 쉼표를 기준으로 구분.
- [ ] 자동차 후보를 저장
- [ ] 자동차 후보 출력. (pobi,woni,jun)
- [ ] 시도 횟수 입력
- [ ] 0-9 사이의 랜덤값 추출
- [ ] 추출한 랜덤 값이 4이상인지 판단
- [ ] 현재 전진 횟수 갱신
- [ ] 전진 결과 출력
- [ ] 최종 우승자 판단
- [ ] 최종 우승자 출력
---

## 메서드
- inputCarNames() : 경주할 자동차 이름 입력 
- splitByComma() : 컴마를 기준으로 string구분 
- ListUpRacingCar() : 경주할 자동차 후보를 저장 
- showCarList() : 경주할 자동차 후보를 출력 
- inputRaceCount() : 시도 횟수 입력 
- getRandomNumberInRange() : 랜덤값 추출 
- updateRacingStatus() : 경주 현황 갱신 
- showRacingStatus() : 경주 현황 출력 
- whoIsWinner() : 우승자 판단 
- showWinners() : 우승자 출력 
---

## MVC
### [Model]
#### class :
- RacingGameModel <br/>
  ㄴ data <br/>
  ㄴ ListUpRacingCar() <br/>
  ㄴ updateRacingStatus() <br/>
  ㄴ whoIsWinner() <br/>
- UtilityModel <br/>
  ㄴ splitByComma() <br/>
  ㄴ getRandomNumberInRange() <br/>
#### data :
- 자동차 후보
- 시도 횟수
- 경주 진행 현황
- 우승자 명단
### [View]
#### class :
- GuideMessageView <br/>
  ㄴ 안내문구
    - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    - 시도할 회수는 몇회인가요?
    - 실행 결과
    - 최종 우승자 :
- RacingView <br/>
  ㄴ showCarList() <br/>
  ㄴ showRacingStatus() <br/>
  ㄴ showWinners() <br/>

### [Controller]
#### class
- UserInputController<br/>
  ㄴ inputCarNames() <br/>
  ㄴ inputRaceCount()


