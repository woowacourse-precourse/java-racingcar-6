![wooteco](https://github.com/AidenRoh/wooteco-precourse/assets/124841119/08c069a4-a7b0-41c1-884f-dfc6af17d373)

# 프리코스 2주차 미션: 자동차 경주

![Generic badge](https://img.shields.io/badge/precourse-week2-blue.svg)
![Generic badge](https://img.shields.io/badge/unitTest-6-green.svg)

> 우아한테크코스 6기 2주차 미션, 자동차 경주를 구현한 저장소입니다.

<br>

![racingcar](https://github.com/AidenRoh/wooteco-precourse/assets/124841119/3d843806-54f2-497d-b662-a23c38599e45)

<br>

---

## 목차

- [패키지 구조](#패키지-구조)
- [게임 흐름](#게임-흐름)
- [기능 목록](#기능-목록)
    - [️플레이어 등록](#1-플레이어-등록)
    - [시도 횟수 입력](#2-시도-횟수-입력)
    - [회당 게임 진행](#3-회당-게임-진행)
    - [우승자 출력](#4-우승자-출력)

<br>

---

## 패키지 구조

<br>

```

📦 racingcar
├─ 📁 controller
│  └─————————————— 🕹️ [GameController]
├─ 📁 domain
│  ├─————————————— 🏎️ [Car]
│  ├─————————————— 👨‍👨‍👦‍👦 [Participant]
│  ├─————————————— 🚥 [Progress]
│  └─————————————— 📜 [RacingResult]
├─ 📁 dto
│  └─————————————— 🗣️ CarStatusDto(record)
├─ 📁 exception
│  ├─————————————— 🏷️ ErrorMessage(enum)
│  └─————————————— ❌ RacingCarException
├─ 📁↘️ validation
│  ├─ 📂 playtime
│  │  ├─————————————— PlayTimeValidator(interface)
│  │  ├─————————————— [EmptyPlayTimeValidator]
│  │  ├─————————————— [IntegerTypeValidator]
│  │  └─————————————— [MinimumPlayTimeValidator]
│  ├─ 📂 registry
│  │  ├─————————————— RegistryValidator(interface)
│  │  ├─————————————— [DuplicateNameValidator]
│  │  ├─————————————— [EmptyRegistryValidator]
│  │  ├─————————————— [MaximumLengthValidator]
│  │  ├─————————————— [MinimumLengthValidator]
│  │  └─————————————— [OnlyPlayerValidator]
│  ├─——————————— ✅ [PlayTime]
│  └─——————————— ✅ [Registry]
└─ 📁 view
   ├─————————————— 🏷️ IOMessage(enum)
   ├─————————————— ⌨️ [InputView]
   └─————————————— 🖨️ [OutputView]

```

## 게임 흐름

![gameflow](https://github.com/AidenRoh/wooteco-precourse/assets/124841119/d0d40409-e4e5-4111-ae7e-38ea4a00c3e4)

<br>

---

## 기능 목록

> 게임 흐름 순서로 기능 목록이 나열되어 있습니다. [게임 흐름](#게임-흐름)

### 1️⃣ 플레이어 등록

- [x] 사용자로부터 구분자 쉼표(,)를 기준으로 하는 플레이어 이름의 입력값을 받는다.

    - **[InputView]** : 플레이어 등록 메세지를 출력한다.
    - **[InputView]** : ``camp.nextstep.edu.missionutils.Console``의 ``readLine()``을 활용하여 입력값을 받는다.
    - **[InputView]** : 입력값은 쉼표(,)를 기준으로 파싱하여 ``List<String>`` 로 변환한다.
    - **[Registry]** : 변환된 입력값을 검증하고 유효하지 않은 입력값은 ⚠️ 예외처리 ⚠️ 한다. (``IllegalArgumentException``을 호출)

<br>

- [x] 파싱된 입력값으로 ``Car``객체를 생성한다.

    - **[Participant]** : 플레이어 이름이 담겨있는 ``List<String>``을 이용해 ``Car``객체를 생성한다.
    - **[Participant]** : 생성된 ``Car``객체를 ``List<Car>``형태로 변환하여 필드 값을 갖는다.

<br>

##### ⚠️ 예외 처리 ⚠️

- [x] ``IllegalArgumentException``를 상속한 **[RacingCarException]** 을 활용한다.
- [x] ``Registry``클래스는 **[RegistryValidator]** 인터페이스를 통해 구현된 validator를 사용한다.
    - **[MaximumLengthValidator]** : 플레이어 명이 5자 초과한 경우, ``RacingCarException``을 호출한다
    - **[MinimumLengthValidator]** : 플레이어 명이 1자 미만인 경우, ``RacingCarException``을 호출한다
    - **[DuplicateNameValidator]** : 플레이어 명이 중복된 경우, ``RacingCarException``을 호출한다
    - **[OnlyPlayerValidator]** : 참가 플레이어가 단 1명일 경우, ``RacingCarException``을 호출한다
    - **[EmptyRegistryValidator]** : 입력값이 비어있는 경우, ``RacingCarException``을 호출한다

<br>

### 2️⃣ 시도 횟수 입력

- [x] 사용자로부터 시도할 횟수를 입력받는다.

    - **[InputView]** : 플레이 타임 메세지를 출력한다.
    - **[InputView]** : ``camp.nextstep.edu.missionutils.Console``의 ``readLine()``을 활용하여 입력값을 받는다.
    - **[PlayTime]** : 입력값을 검증하고 유효하지 않은 입력값은 ⚠️ 예외처리 ⚠️한다. (``IllegalArgumentException``을 호출)
    - **[InputView]** : 검증된 입력값은 ``Integer``으로 파싱한다.

<br>

##### ⚠️ 예외 처리 ⚠️

- [x] ``IllegalArgumentException``를 상속한 **[RacingCarException]** 를 활용한다.
- [x] ``PlayTime``클래스는 **[PlayTimeValidator]** 인터페이스를 통해 구현된 validator를 사용한다.
    - **[EmptyPlayTimeValidator]** : 입력값이 비어있는 경우, ``RacingCarException``을 호출한다
    - **[IntegerTypeValidator]** : 입력값이 ``Integer``타입이 아닌 경우, ``RacingCarException``을 호출한다
    - **[MinimumPlayTimeValidator]** : 입력값이 최소 시도 횟수 (1) 미만인 경우, ``RacingCarException``을 호출한다

<br>

### 3️⃣ 회당 게임 진행

- [x] 시도 횟수만큼 다음 과정을 반복하여 진행한다.

    - **[Participant]** : 필드로 가지고 있던 ``List<Car>``를 통해 등록된``Car``객체에 ``tryProgress``함수를 호출한다.
    - **[Car]** : ``tryProgress``함수는 **[Progress]** 클래스를 통해 1 또는 0의 값을 받아 ``progressScore`` 필드를 업데이트한다.
        - **[Progress]** : ``Randoms.pickNumberInRange(0, 9)``을 활용하여 4 이상의 값이 나온 경우, SUCCESS (1) 값을 반환한다.
        - **[Progress]** : ``Randoms.pickNumberInRange(0, 9)``을 활용하여 4 미만의 값이 나온 경우, FAIL (0) 값을 반환한다.

    - **[Participant]** : ``generateResult``함수를 호출하여 [CarStatusDto] ``List``를 매개로하는 **[RacingResult]** 객체를 생성한다.
    - **[RacingResult]** : ``referExecution`` 함수로 String 결과값을 List로 묶어 반환한다.
    - **[OutView]** : 반환받은 ``List<Stinrg>`` 을 파싱하여 결과를 출력한다.

<br>

### 4️⃣ 우승자 출력

- [x] 게임이 모두 진행된 우승자를 출력한다.
    - **[Participant]** : ``generateResult``함수를 호출하여 [CarStatusDto] ``List``를 매개로하는 **[RacingResult]** 객체를 생성한다.
    - **[RacingResult]** : ``referWinner`` 함수로 String 결과값을 List로 묶어 반환한다.
    - **[OutView]** : 반환받은 ``List<Stinrg>`` 을 파싱하여 결과를 출력한다.

---