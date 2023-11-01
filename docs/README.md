<div align="center">

[![header](https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=2&animation=fadeIn&height=230&section=header&text=우아한테크코스%20Precourse%202주차&desc=🚘%20자동차%20경주%20게임%20(Racing%20Car)%20-%20변해빈&fontSize=40&fontAlign=50&fontAlignY=33&descSize=20&descAlign=50&descAlignY=55)](https://github.com/h-beeen/java-racingcar-6/blob/h-beeen/docs/README.md)

</div>

## 💌&nbsp;&nbsp;목차

- [📦&nbsp;&nbsp;패키지 구조](#📦패키지-구조)
- [✨&nbsp;&nbsp;구현 목록](#구현-목록)
  * [Non-Functional Requirement](#1%EF%B8%8F⃣-non-functional-requirement)
  * [Functional Requirement](#2%EF%B8%8F⃣-functional-requirement-controller-code-flow)
- [🆘&nbsp;&nbsp;고민의-흔적](#고민의-흔적)
  * [MVC 패턴에서 View Layer와 Domain Layer의 검증 책임](#1%EF%B8%8F⃣mvc-패턴에서-view-layer와-domain-layer의-검증-책임)
  * [객체 간 관계를 static으로 풀어낸 결과 어려워진 테스트 코드 작성](#2%EF%B8%8F⃣객체-간-관계를-static으로-풀어낸-결과-어려워진-테스트-코드-작성)
- [👬&nbsp;&nbsp;31명과 함께 나눈 224개의 소중한 코드리뷰 적용기](#31명과-함께한-223개의-소중한-코드리뷰-적용기)

---

## 📦&nbsp;&nbsp;패키지 구조

<div align="center">
<table>
    <tr>
        <th align="center">Package</th>
        <th align="center">Class</th>
        <th align="center">Description</th>
    </tr>
    <tr>
        <td><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/2f32b4cd-187c-4b92-a136-2d86cd3341cd" width="20px">&nbsp;&nbsp;controller</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Game</b></td>
        <td>게임 로직을 메인으로 동작하는 컨트롤러 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="4"><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/f16a8719-281f-4535-a958-c1c62d69cfa2" width="20px">&nbsp;&nbsp;domain</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Car</b></td>
        <td>움직임을 동작하는 개별 자동차 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Cars</b></td>
        <td>개별 자동차를 멤버변수로 갖는 일급 컬렉션 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;MovementCondition</b></td>
        <td>자동차의 전진 조건을 생성하고 검증하는 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Name</b></td>
        <td>자동차 이름에 대한 원시값 포장 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/219d6ae0-19c4-4984-970d-ea244700b6a9" width="20px">&nbsp;&nbsp;dto</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/3ef9d8a2-d4bb-42a1-900f-754799cac3fd" height="32px">&nbsp;&nbsp;FinalResponse</b></td>
        <td>최종 우승자를 리턴하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/3ef9d8a2-d4bb-42a1-900f-754799cac3fd" height="32px">&nbsp;&nbsp;RoundResponse</b></td>
        <td>라운드 별 각 자동차의 점수를 시각화해 리턴하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/3ef9d8a2-d4bb-42a1-900f-754799cac3fd" height="32px">&nbsp;&nbsp;RoundResponses</b></td>
        <td>각 라운드별 모든 자동차의 점수를 리턴하는 DTO 레코드</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/1de269e3-5ceb-4e91-b9a9-922e81bc0e6a" width="20px">&nbsp;&nbsp;exception</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/b8e837c7-bc6a-4bbc-a4c3-267ec11da553" height="32px">&nbsp;&nbsp;ErrorMessage</b></td>
        <td>예외를 던질 때 사용되는 에러 메세지 Enum 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;RacingCarException</b></td>
        <td>전역에서 에러를 핸들링하는 Custom Exception</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/6236ca3c-b1b5-4ee9-b2ba-062252930498" width="20px">&nbsp;&nbsp;parser</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Parser</b></td>
        <td>Input을 생성자 멤버변수 형식에 맞게 파싱하는 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/1cb95818-66f2-42b0-b03c-b7cc8cc27dad" width="19px">&nbsp;&nbsp;validator</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;InputValidator</b></td>
        <td>Input Value에 대한 기본 유효성 검증을 진행하는 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/ea629f71-ed2c-4277-bc10-d93a0758e377" width="20px">&nbsp;&nbsp;view</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;View</b></td>
        <td>View Layer에서 입/출력을 담당하는 클래스</td>
    </tr>
    <tr>
        <td><b>&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/a7b13c6b-dc98-4571-b8bc-7d50d2ca5b49" width="20px" align="center">&nbsp;&nbsp;constants</b></td>
                <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/b8e837c7-bc6a-4bbc-a4c3-267ec11da553" height="32px">&nbsp;&nbsp;ConstantMessage</b></td>
        <td>사용자에게 출력할 정적 메세지 Enum 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
      <th colspan="3">Project Flow Chart</th>
    </tr>
    <tr>
      <td colspan="3" align="center"><img src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/de3b64d1-abde-4364-b22c-40ac1982f596" width="99%"/></td>
    </tr>

</table>
</div>

<br>

---

## ✨&nbsp;&nbsp;구현 목록

### 1️⃣ Non-Functional Requirement

<br>

+ [X] 자동차 경주 프로그램은 [MVC 패턴]("https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC")에 따라 설계한다.
+ [X] [YAGNI]("https://ko.wikipedia.org/wiki/YAGNI") 원칙에 의거해, 필요 구현 요소를 밀도있게 구현하는 것을 목표로 한다.

<br>

### 2️⃣ Functional Requirement (Controller Code Flow)


+ [X] [Game] 사용자에게 자동차 이름을 `,(Comma)`를 기준으로 입력 받는다

  * [View] 사용자에게 자동차 이름 요청 폼을 출력하고, 문자열을 입력받는다.
  * [InputValidator] 유효성 검사 : Comma로 끝나거나, whiteSpace를 포함하는 요청 예외처리한다.
  * [Parser] 플레이어에게 입력받은 String을 Comma를 기준으로 파싱해 List<String> 형태로 변환한다.
  * [InputValidator] 유효성 검사 : List<String>에 동일한 이름이 포함된 경우 예외처리한다.

+ [X] [Game] 파싱된 List<String> 문자열로 List<Car>를 멤버변수로 갖는 Cars 객체를 생성한다.

  * [Cars] stream 문법을 사용해, 모든 List<String> 원소를 바탕으로 Car 객체를 생성한다.
  * [Cars] 위에서 만든 Car 객체를 List<Car> 형태로 리턴해 Cars의 멤버변수로 생성한다.

+ [X] [Game] 사용자에게 라운드 횟수를 입력받는다.

  * [View] 사용자에게 라운드 횟수 요청 폼을 출력하고, 숫자형 문자열을 입력받는다.
  * [InputValidator] 유효성 검사 : 정수형이 아닌 숫자나 문자열이 요청되면 예외처리
  * [InputValidator] 유효성 검사 : 1 미만의 숫자가 요청되면 예외처리
  * [Parser] 라운드 횟수를 정수형으로 파싱해 컨트롤러에 리턴한다.

+ [X] [Game] 라운드 횟수에 따라, 각 라운드를 반복 진행한다

  * [Cars] for-each 문법을 사용해, 멤버변수의 모든 car를 대상으로 move 메소드를 호출
  * [(Each) Car] `MoveCondition.create` 함수를 호출해 1~9 사이의 랜덤 정수를 담은 조건 객체를 생성한다.
  * [(Each) Car] `MoveCondition.movable` 함수를 호출해 이동 가능 여부 메세지를 보내고, 이동 여부에 따라 행동한다.

+ [X] [Game] 각 라운드 종료`(모든 Each Car가 1회전 경주를 마친 상황)`

  * [Cars] buildRoundResponses 함수를 호출해 일급 컬렉션 멤버변수를 아래 과정을 통해 DTO로 변환한다.
  * [RoundResponses] stream 문법을 사용해 모든 List<Car>를 순회하며 List<RoundResponse>를 생성한다.
  * [RoundResponse] 각 RoundResponse는 name과 score를 가지며, getResponse 편의 메소드로 <br>`이름 : --` 형태로 출력한다.
  * [RoundResponses] 레코드의 일급 컬렉션 멤버변수인 List<RoundResponse>를 순회하며 모든 자동차의 라운드 결과를 <br>`이름 : --` 형태의 `String`으로 리턴한다.
  * [View] RoundResponses.getResponses()를 통해 각 라운드 진행 현황을 사용자에게 출력한다.

+ [X] [Game] 모든 라운드 종료`(라운드 횟수 만큼 모든 자동차가 경주를 진행한 상황)`되었을 때

  * [Cars] buildFinalResponse 함수를 호출해 일급 컬렉션 멤버변수를 아래 과정을 통해 DTO로 변환한다.
  * [FinalResponse] FinalResponse는 List<String> winnerNames 가지며, getResponse 편의 메소드로 <br>`최종 우승자 : 해빈, 햅, 빈빈`
    형태의 `String`으로
    리턴한다.
  * [View] FinalResponse.getResponse()를 통해 최종 우승자를 사용자에게 출력한다.
  * [Console] Console.close() 명령어를 통해 `Scanner.close()` 기능을 수행한다.

<br>

--------------------------------------------------------

## 🆘&nbsp;&nbsp;고민의 흔적

### 1️⃣&nbsp;&nbsp;&nbsp;[MVC 패턴]("https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC")에서 View Layer와 Domain Layer의 검증 책임

- Input Layer에서 유효성 검사를 진행하는게 맞을까에 대한 고민을 꾸준히 해왔습니다.<br>

      ➡️ (View) 순수하게 문자열을 입/출력하는 기능
      ➡️ (Validator) 기본 유효성, 자료형 검사
      ➡️ (Parser) Validator를 통해 검증된 문자열을 자료형에 맞게 변환 `ex : String ➡️ List<String>`<br>
      ➡️ (Domain Constructor) 요구사항 예외처리 및 검증

- 위 순서로 View Layer에서 검증하지 않고, 별도의 Validator 도메인에서 유효성/자료형 검증을 진행합니다.
- 이렇게 기본적인 유효성 검증을 마치고, 개발 요구사항에 대한 검증은 일급컬렉션 및 각 도메인의 생성자에서 검증합니다.
- 위와 같은 방식의 설계가 MVC 패턴에 입각해 좋은 설계로 구성되었는지 봐주시면 좋을 것 같아요. ⸝⸝ʚ ̯ʚ⸝⸝

### 2️⃣&nbsp;&nbsp;&nbsp;객체 간 관계를 Static으로 풀어낸 결과, 어려워진 테스트 코드 작성

- 도메인 구조를 싱글톤으로 가져가지 않고, 설계하다 보니 테스트 코드 작성 간 어려움을 겪었습니다.
- `MovementCondition` 의 경우, 개별 `Car`가 매 라운드마다 새로운 `MovementCondition` 객체를 생성하고, 전진 여부를 요청합니다.

- MovementCondition은 Static 객체라, 해당 조건으로 분기하는 Car 객체는 일반적인 방법으로 테스트를 진행하기 어려웠습니다.
- 그래서 우회 방법으로 `Randoms` 객체를 모킹해, Random Generated Value를 모킹해서, 테스트를 진행했습니다.
- 해당 방법은 좋은 테스트 방법이라고 생각되지 않습니다! 이 부분에 대해서 리뷰를 꼭 받아보고 싶어요.
  (어쩌면 초기 설계가 부적절 했을 수도 있다고 생각합니다.)

---------------------------------------------------------

## 👬&nbsp;&nbsp;31명과 함께한 223개의 소중한 코드리뷰 적용기

- [1주차 숫자 야구 Pull Request](https://github.com/woowacourse-precourse/java-baseball-6/pull/1613) 는 많은 리뷰가 남겨져 있어 로드하는데 시간이 좀 걸립니다!
  (유니콘 414 에러가 뜨면서 PR창이 뜨지 않는다면 새로고침 해주세요!)
- 지난 리뷰에서 **아쉬웠다고 리뷰를 받은 부분**을 아래와 같이 반영하고자 노력했습니다.

<table>
    <tr>
        <th align="center">Type</th>
        <th align="center">Review</th>
        <th align="center">Reviewers</th>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/9a2cdecd-2df4-4541-86ec-4e8fa1017643" height="32px">&nbsp;&nbsp;README</b></td>
        <td>0x00. 어떤 객체가 기능들을 할당하는지도 같이 명시되어 있으면 좋을 것 같다.</td>
        <td><b>@Gyu-won</b></td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="15"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;코드 리뷰</b></td>
        <td>0x01. 검증 메소드에서 <b>긍정 조건</b>을 사용하는게 가독성에 좋다.</td>
        <td><b>@junseoparkk</b></td>
    </tr>
      <tr>
        <td>0x02. 컨벤션이 없는 상황에서 <b>정적 팩토리 메소드 사용은 혼선</b>을 가져올 수 있다.</td>
        <td><b>@OiKimiO</b></td>
    </tr>
      <tr>
        <td>0x03. MVC 패턴에서 <b>모델에서 뷰의 정보를 알아서는 안 된다.</b></td>
        <td><b>@oxdjww</b></td>
    </tr>
      <tr>
        <td>0x04. 일부 <b>접근지정자가 세밀하게 조정되지 않았다</b>.</td>
        <td><b>@U-Keun</b></td>
    </tr>
      <tr>
        <td>0x05. <b>Open-Closed Principle</b> vs <b>YAGNI</b></td>
        <td><b>@oxdjww</b></td>
    </tr>
      <tr>
        <td>0x06. <b>Flag 네이밍은 boolean</b>의 의미가 강하다. 정수는 다른 네이밍이 필요하다.</td>
        <td><b>@cosyflower</b></td>
    </tr>
      <tr>
        <td>0x07. <b>클래스 내부 함수의 선언 순서가</b> 세밀하게 조정될 필요가 있다.</td>
        <td><b>@jcoding-play</b></td>
    </tr>
    <tr>
        <td>0x08. 커스텀 예외 선언은 <b>정적 팩토리 메소드보다, 직접 선언하는게 정확</b>하다.</td>
        <td><b>@IMWoo94</b></td>
    </tr>
    <tr>
        <td>0x09. <b>Protected</b> 생성자 vs <b>Private</b> 생성자</td>
        <td><b>@cosyflower</b></td>
    </tr>
    <tr>
        <td>0x0a. <b>조건에 따라 분기하는 것은 검증(Validator)계층</b>이 아니다.</td>
        <td><b>@minnim1010</b></td>
    </tr>
</table>

#### 🌱 0x00 `어떤 객체가 기능들을 할당하는지도 같이 명시되어 있으면 좋을 것 같다.`

- 리드미에 기능 명세를 강화해서, **Controller Code Flow를 따라갈 수 있도록 설계**했습니다.
- 기능, 비기능 요구사항을 나누고 **설계 방향에 대한 명시를 강화**했습니다.
- 플로우 차트를 추가해, 직관적으로 **코드 플로우를 눈으로 따라갈 수 있도록 설계**했습니다.

#### 🌱 0x01 `검증 메소드에서 긍정 조건을 사용하는게 가독성에 좋다.`

- 예외처리 메소드에서 사용할 **검증 메소드(boolean)의 포스트컨디션에 따라, 긍정문으로 작성**했습니다.
- **isInvalidRoundCount, isExceedLength와 같이 직관적으로 해석되도록 정의**했습니다.

#### 🌱 0x02 `컨벤션이 없는 상황에서 정적 팩토리 메소드 사용은 혼선을 가져올 수 있다.`

- private 생성자 + 정적 팩토리 메소드 조합으로 명백한 의도가 표현되도록 노력했습니다.
- 메소드 명 자체가 해당 생성자의 의미를 직관적으로 담을 수 있도록 다음 표의 컨벤션 참고했습니다.

|   메소드명   |               역할               |
|:--------:|:------------------------------:|
|   from   |     하나의 매개변수를 받아서 인스턴스를 생성     |
|    of    |    여러개의 매개변수를 받아서 인스턴스를 생성     |
| instance | 인스턴스를 반환하지만 동일한 인스턴스임을 보장하지 않음 |
|  create  |        매번 새로운 인스턴스를 반환         |
| getXxxx  | 호출하는 클래스와 다른 타입의 인스턴스를 반환할때 사용 |
| newXxxx  |  getXxxx와 같으나 매번 새로운 인스턴스를 반환  |

출처 : [Static Factory Method 네이밍 컨벤션](https://multifrontgarden.tistory.com/255) - Tistory, Effective java

#### 🌱 0x03 `MVC 패턴에서 모델에서 뷰의 정보를 알아서는 안 된다.`

- 모델에서 View를 호출하지 않고, **View ↔️ Controller ↔️ Domain(Model) 의존 구조로 설계**했습니다.
- Domain 에서 Controller로 출력할 데이터를 **DTO를 통해 전달하고 <br/>View에서는 DTO의 Response를 단순 출력하는 방식으로 설계**했습니다.

#### 🌱 0x04 `일부 접근지정자가 세밀하게 조정되지 않았다.`

- private 메소드로 선언해야 했음에도, 꼼꼼하게 체크하지 않은 탓에, public으로 불필요하게 개방적인 함수가 일부 존재했습니다.
- 이번 자동차 경주 미션에서는, 해당 사항을 꼼꼼하게 검증해, 함수의 권한을 적절하게 관리하도록 통제했습니다.

#### 🌱 0x05 `Open-Closed Principle vs YAGNI`

> 실제로 필요할 때 무조건 구현하되, 그저 필요할 것이라고 예상할 때에는 절대 구현하지 말라.

출처 : [YAGNI](https://ko.wikipedia.org/wiki/YAGNI) - Wikipedia

- 기존 1주차에 OCP를 준수하기 위해 작성했던 코드에서, **과제 요구사항과는 거리가 있다**는 리뷰를 받았습니다.
- 반면 긍정적인 리뷰도 있었습니다. 확장성 있는 설계로 좋은 리뷰를 남겨주신 분도 계셨습니다.
- 이번 미션은 자동차 경주 게임의 본질을 꾸준히 되새기며 YAGNI 설계로 구성했습니다.

#### 🌱 0x06 `Flag 네이밍은 boolean의 의미가 강하다. 정수는 다른 네이밍이 필요하다.`

- 선언한 모든 변수에 대해서, 누구나 읽어도 직관적으로 해석이 가능한 변수 명으로 설정하고자 노력했습니다.
- 기존 리뷰 받았던 `xxFlag`, `xxOption`, `xxOrNot` 과 같이 해석에 혼동을 줄 수 있는 변수와 클래스명 사용을 지양했습니다.

#### 🌱 0x07 `클래스 내부 함수의 선언 순서가 세밀하게 조정될 필요가 있다.`

클래스 내부 선언 순서 컨벤션

> 1. Static Variable : `public -> protected -> private`
> 2. Member Variable : `public -> protected -> private`
> 3. Constructor
> 4. Static Method
> 5. Other Method : 기능 및 역할별로 분류하여 기능을 구현하는 그룹별로 작성
> 6. Standard Method : toString, equals, hashcode 와 같은 메소드
> 7. Getter / Setter : 클래스의 가장 하단 부분에 위치

출처 : [Are there Any Java method ordering conventions?](https://stackoverflow.com/questions/4668218/are-there-any-java-method-ordering-conventions) - Stack Overflow

#### 🌱 0x08 `예외 복구, 예외 회피, 예외 전환의 역할을 잘 알고 활용하자.`

자바에서 예외처리는 예외 복구, 예외 회피, 예외전환을 방식이 각각 있습니다.

| 종류 | 역할 |
|:-----:|:------------------------------------------------:|
| 예외 복구 | try catch -> 예외를 처리하고 정상 로직 처리 |
| 예외 회피 | throw 로 상위 컨텐츠에게 위임 |
| 예외 전환 | checkedExcpetion 을 unckeckedException 으로 변경하여 리턴 |

> 예외는 정적 팩토리메소드 보다는 있는 그대로를 보여주는 것이 더 정확하다고 생각합니다.
Exception 에 대한 처리는 정확하게 처리해야 서버의 죽음을 막을 수 있고,
에러에 대한 정보가 정확 해야지 추후 원인 판단에 빠른 해결책을 제공할 수 있을거라 봅니다.

출처 : [1주차 숫자야구 코드리뷰](https://github.com/woowacourse-precourse/java-baseball-6/pull/1613/files#r1373396177)  - @IMWoo94

- 이번 미션에서 `RacingCarException` 이라는 전역 예외를 공통으로 던지도록 설계했습니다.
- 에러 메세지를 정적으로 관리하고, 각 테스트 케이스에서 JUnit5의 `hasMessageContaining` 메소드를 활용해 해당
  예외 발생 여부와 Containing ErrorMessage 여부를 이중으로 검증해, 간결하면서 신뢰도 높은 테스트를 만들고자 했습니다.
- `IllegalArgumentException`을 원시 형태로 발생시키는 것 보다, <br>전역에서 에러를 공통 규격으로 관리하는 것이 더욱 확장성이 높다고 판단합니다.
- 서버가 예외의 상태를 파악할 수 있도록, 추후 Logging 방식을 통해 말씀 주신 문제를 해결할 수 있다고 생각합니다.

#### 🌱 0x09. `Protected 생성자 vs Private 생성자`

- 기존에 상속과 다형성을 목표로 작성했던 **protected 생성자에 대해 리뷰**를 받았습니다.
- 이번 과제에서 상속과 다형성으로 최종 개발되지 않은 클래스는 **private 생성자를 사용**했습니다.
- private 생성자를 기반으로, public Static Factory 메소드로 객체를 생성합니다.
- JPA에서 사용했던 경험을 바탕으로, 무의식적으로 사용했던 행동을 반성하게 되었습니다 :)

출처 : [[JPA] JPA에서 Entity에 protected 생성자를 만드는 이유](https://velog.io/@jyyoun1022/JPA-JPA%EC%97%90%EC%84%9C-Entity%EC%97%90-protected-%EC%83%9D%EC%84%B1%EC%9E%90%EB%A5%BC-%EB%A7%8C%EB%93%9C%EB%8A%94-%EC%9D%B4%EC%9C%A0) - Velog

#### 🌱 0x0a. `조건에 따라 분기하는 것은 검증(Validator)계층이 아니다.`

- 일부 검증 메소드(`isExitFlag`, `isRestartFlag`)와 같은 함수는 값에 대한 `검증`의 성격을 띄지 않는다는 리뷰를 받았습니다.
- 함수의 위치와, 이름, 그리고 이를 담는 패키지 이름까지, 조금 더 함수의 역할을 담을 수 있도록 설계했습니다.
