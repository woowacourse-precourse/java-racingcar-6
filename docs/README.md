# ⚙️기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.


# 📦프로젝트 구조
-

# 🔎 To-Do
## Model
### car
- [x] 전진 할 수 있다(주어진 횟수동안) ✅ 2023-10-26
- [x] 이름이 있다 (제한 : 5자 이내, 쉼표로 구분) ✅ 2023-10-29


## player
- [x] 이동 횟수를 입력한다 ✅ 2023-10-29
	- [x] 랜덤한 수를 생성한다. ✅ 2023-10-29
	- [x] 4 이상의 숫자인 경우에만 이동(validate) ✅ 2023-10-29
	- [x] 각각의 자동차 리스트에 접근하여 값 변경(car) ✅ 2023-10-29
	- [x] 위 과정을 새로운 클래스를 만들어 관리한다. ✅ 2023-10-29
- [x] 경주할 자동차 이름을 부여한다 ✅ 2023-10-28


## Controller
### GameController
- [x] 각종 컴포넌트를 합쳐 게임을 실행시킨다. ✅ 2023-10-29
- [x] 입력받은 레이싱 카 클래스를 만든다. ✅ 2023-10-28
### GameUtils
- [x] 입력받은 이름을 나눠 반환한다 ✅ 2023-10-28
- [x] 랜덤한 숫자를 만든다. ✅ 2023-10-29

## Validate
- [x] 전진하는 조건을 확인한다 ✅ 2023-10-29
- [x] 자동차 이름이 5자 이내인지 확인한다 ✅ 2023-10-28

# View
- [x] 입력 형식과 출력 형식에 따른 메시지 설정 ✅ 2023-10-29
	- [x] 자동차 입력 ✅ 2023-10-29
	- [x] 시도 횟수 입력 ✅ 2023-10-29

- [x] 게임 결과 출력 ✅ 2023-10-29
	- [x] 인스턴스 이름 : 진행도(-) ✅ 2023-10-29


---
# 리펙토링 리스트
 - [x] 메소드 간소화 가능한지 확인하기 ✅ 2023-10-31
 - [x] 가독성 측면에서 확인하기 ✅ 2023-10-30
 - [x] 역할과 책임 측면에서 확인하기 ✅ 2023-10-30

- [ ] 추가 예외사항 확인


> 깃 브랜치전략을 세울 필요성을 느꼈다. 
> GitFlow 전략을 채택하고 앞으로 나올 브랜치부터 적용하기로 했다.

Cycrypto : 마스터 브랜치
develop : 개발 브랜치
feature : 새로운 기능을 개발하는 브랜치
refactor : 리펙토링시 필요한 브랜치 (예정)


# 몰입 기록

<svg width="748" height="598.4"><g transform="translate(30,30)"><circle class="bubble" r="133.07693322638707" cx="273.65480464041167" cy="286.07696172198666" style="fill: rgb(141, 211, 199);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/controller/GameController.java</title></circle><circle class="bubble" r="94.15890807631294" cx="502.8482342697274" cy="286.07696172198666" style="fill: rgb(255, 255, 179);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/docs/README.md</title></circle><circle class="bubble" r="74.64498973581148" cx="420.5517741568541" cy="435.699078406658" style="fill: rgb(190, 186, 218);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/model/RacingCar.java</title></circle><circle class="bubble" r="58.58118901142333" cx="417.8240720512194" cy="156.83971588473332" style="fill: rgb(251, 128, 114);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/controller/GameProcess.java</title></circle><circle class="bubble" r="55.90129088818507" cx="316.22863230902595" cy="99.94809864530097" style="fill: rgb(128, 177, 211);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/view/OutputView.java</title></circle><circle class="bubble" r="55.02968350607204" cx="294.90751509532424" cy="474.94920516463156" style="fill: rgb(253, 180, 98);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/model/CarList.java</title></circle><circle class="bubble" r="51.16225468630165" cx="528.4008826049159" cy="141.03182155706543" style="fill: rgb(179, 222, 105);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/test/java/racingcar/controller/GameProcessTest.java</title></circle><circle class="bubble" r="48.05332810166579" cx="544.6621752653991" cy="424.04990340294114" style="fill: rgb(252, 205, 229);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/validator/InputValidation.java</title></circle><circle class="bubble" r="47.715994672424344" cx="211.61720741948056" cy="114.1784808918361" style="fill: rgb(217, 217, 217);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/controller/GameUtils.java</title></circle><circle class="bubble" r="41.86165230665616" cx="200.10462425554832" cy="446.95774768333376" style="fill: rgb(188, 128, 189);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/view/InputView.java</title></circle><circle class="bubble" r="41.69984377601718" cx="405.2530485800042" cy="55.37689010016476" style="fill: rgb(204, 235, 197);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/test/java/racingcar/controller/GameUtilsTest.java</title></circle><circle class="bubble" r="34.213143302385305" cx="365.9544868056102" cy="532.1317508547938" style="fill: rgb(255, 237, 111);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/test/java/racingcar/controller/GameControllerTest.java</title></circle><circle class="bubble" r="32.462451391457485" cx="479.843690169944" cy="70.55822239858475" style="fill: rgb(141, 211, 199);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/global/GameConfig.java</title></circle><circle class="bubble" r="31.667861596247743" cx="593.1993710118439" cy="195.7137267274987" style="fill: rgb(255, 255, 179);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/model/RacingCarList.java</title></circle><circle class="bubble" r="28.906608948685477" cx="598.6112840734564" cy="366.4524254161349" style="fill: rgb(190, 186, 218);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/model/Cars.java</title></circle><circle class="bubble" r="28.79678339128576" cx="157.26474138235355" cy="170.77713668077635" style="fill: rgb(251, 128, 114);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/test/java/study/StringTest.java</title></circle><circle class="bubble" r="26.7742029790996" cx="507.67684610983065" cy="491.3406159096462" style="fill: rgb(128, 177, 211);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/test/java/racingcar/ApplicationTest.java</title></circle><circle class="bubble" r="25.769336443310817" cx="154.67137661156895" cy="394.24731163823594" style="fill: rgb(253, 180, 98);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/Application.java</title></circle><circle class="bubble" r="23.203814502623118" cx="250.48209576702197" cy="52.52918632694616" style="fill: rgb(179, 222, 105);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/constant/GameMessage.java</title></circle><circle class="bubble" r="22.781574596069635" cx="346.13516159604427" cy="25.058297625216483" style="fill: rgb(252, 205, 229);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/src/main/java/racingcar/validation/InputValidation.java</title></circle><circle class="bubble" r="18.125577208984815" cx="609.39762792277" cy="244.86436540339932" style="fill: rgb(217, 217, 217);"><title>/Users/cycrpto/Desktop/My Brain/1.Projects/우아한테크코스/프리코스/week2/java-racingcar-6/README.md</title></circle><text class="label" x="273.65480464041167" y="286.07696172198666" pointer-events="none" style="text-anchor: middle; font-size: 28px;">GameControll…</text><text class="label" x="502.8482342697274" y="286.07696172198666" pointer-events="none" style="text-anchor: middle; font-size: 17px;">README.md</text><text class="label" x="420.5517741568541" y="435.699078406658" pointer-events="none" style="text-anchor: middle; font-size: 13px;">RacingCar.java</text><text class="label" x="417.8240720512194" y="156.83971588473332" pointer-events="none" style="text-anchor: middle; font-size: 10px;">GameProcess.…</text><text class="label" x="316.22863230902595" y="99.94809864530097" pointer-events="none" style="text-anchor: middle; font-size: 10px;">OutputView.java</text><text class="label" x="294.90751509532424" y="474.94920516463156" pointer-events="none" style="text-anchor: middle; font-size: 10px;">CarList.java</text><text class="label" x="528.4008826049159" y="141.03182155706543" pointer-events="none" style="text-anchor: middle; font-size: 9px;">GameProcessT…</text><text class="label" x="544.6621752653991" y="424.04990340294114" pointer-events="none" style="text-anchor: middle; font-size: 9px;">InputValidat…</text><text class="label" x="211.61720741948056" y="114.1784808918361" pointer-events="none" style="text-anchor: middle; font-size: 9px;">GameUtils.java</text><text class="label" x="200.10462425554832" y="446.95774768333376" pointer-events="none" style="text-anchor: middle; font-size: 8px;">InputView.java</text><text class="label" x="405.2530485800042" y="55.37689010016476" pointer-events="none" style="text-anchor: middle; font-size: 8px;">GameUtilsTes…</text><text class="label" x="365.9544868056102" y="532.1317508547938" pointer-events="none" style="text-anchor: middle; font-size: 7px;">GameControll…</text><text class="label" x="479.843690169944" y="70.55822239858475" pointer-events="none" style="text-anchor: middle; font-size: 7px;">GameConfig.java</text><text class="label" x="593.1993710118439" y="195.7137267274987" pointer-events="none" style="text-anchor: middle; font-size: 7px;">RacingCarLis…</text><text class="label" x="598.6112840734564" y="366.4524254161349" pointer-events="none" style="text-anchor: middle; font-size: 7px;">Cars.java</text><text class="label" x="157.26474138235355" y="170.77713668077635" pointer-events="none" style="text-anchor: middle; font-size: 7px;">StringTest.java</text><text class="label" x="507.67684610983065" y="491.3406159096462" pointer-events="none" style="text-anchor: middle; font-size: 7px;">ApplicationT…</text><text class="label" x="154.67137661156895" y="394.24731163823594" pointer-events="none" style="text-anchor: middle; font-size: 7px;">Application.…</text><text class="label" x="250.48209576702197" y="52.52918632694616" pointer-events="none" style="text-anchor: middle; font-size: 7px;">GameMessage.…</text><text class="label" x="346.13516159604427" y="25.058297625216483" pointer-events="none" style="text-anchor: middle; font-size: 7px;">InputValidat…</text><text class="label" x="609.39762792277" y="244.86436540339932" pointer-events="none" style="text-anchor: middle; font-size: 6px;">README.md</text><text class="label hours" x="273.65480464041167" y="314.07696172198666" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 22.4px;">4 hrs 9 mins</text><text class="label hours" x="502.8482342697274" y="303.07696172198666" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 13.6px;">2 hrs 5 mins</text><text class="label hours" x="420.5517741568541" y="448.699078406658" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 10.4px;">1 hr 18 mins</text><text class="label hours" x="417.8240720512194" y="166.83971588473332" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 8px;">48 mins</text><text class="label hours" x="316.22863230902595" y="109.94809864530097" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 8px;">44 mins</text><text class="label hours" x="294.90751509532424" y="484.94920516463156" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 8px;">42 mins</text><text class="label hours" x="528.4008826049159" y="150.03182155706543" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 7.2px;">36 mins</text><text class="label hours" x="544.6621752653991" y="433.04990340294114" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 7.2px;">32 mins</text><text class="label hours" x="211.61720741948056" y="123.1784808918361" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 7.2px;">32 mins</text><text class="label hours" x="200.10462425554832" y="454.95774768333376" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 6.4px;">24 mins</text><text class="label hours" x="405.2530485800042" y="63.37689010016476" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 6.4px;">24 mins</text><text class="label hours" x="365.9544868056102" y="539.1317508547938" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">16 mins</text><text class="label hours" x="479.843690169944" y="77.55822239858475" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">14 mins</text><text class="label hours" x="593.1993710118439" y="202.7137267274987" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">14 mins</text><text class="label hours" x="598.6112840734564" y="373.4524254161349" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">11 mins</text><text class="label hours" x="157.26474138235355" y="177.77713668077635" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">11 mins</text><text class="label hours" x="507.67684610983065" y="498.3406159096462" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">10 mins</text><text class="label hours" x="154.67137661156895" y="401.24731163823594" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">9 mins</text><text class="label hours" x="250.48209576702197" y="59.52918632694616" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">7 mins</text><text class="label hours" x="346.13516159604427" y="32.05829762521648" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 5.6px;">7 mins</text><text class="label hours" x="609.39762792277" y="250.86436540339932" pointer-events="none" style="font-weight: 100; text-anchor: middle; font-size: 4.8px;">4 mins</text></g></svg>
