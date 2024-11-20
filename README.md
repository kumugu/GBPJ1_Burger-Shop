# 햄버거 가게 직원 관리 프로그램 기획서
------

#### **1. 프로젝트 개요**

- **프로젝트 명**: 햄버거 가게 직원 관리 프로그램
- **목적**: 직원 관리, 메뉴 및 재고 관리, 스케줄 관리 등 가게 운영 효율성 향상과 데이터 기반의 체계적인 관리 구현.
- 개발 환경:
  - **언어**: Java (Swing을 사용하여 GUI 구현)
  - **데이터베이스**: Oracle SQL
  - **버전 관리**: Git
------

#### **2. 주요 기능 및 상세 설명**

##### **1) 로그인 및 출근/퇴근 관리**
- 직원 ID와 비밀번호로 로그인.
- 권한별 접근 제어: 관리자와 일반 직원의 권한 구분.(정보조회)
  - 관리자: 전체 직원 정보 접근 가능
  - 일반 직원: 자신의 정보만 조회 가능
- 출근/퇴근 시간 기록과 현재 출근자 확인 기능 제공.

##### **2) 직원 관리**
- **등록**: 신규 직원 정보 추가(사진, 번호, 이름, 직책, 거주지, 이메일)
- **수정**: 직원 정보 수정
- **삭제**: 퇴직자 정보 삭제
- **급여 관리**: 급여/보너스 정산 관리(관리자).
- **직원 리스트**: 현재 등록된 직원 출력 및 상세 정보 확인.
- **권한 관리**: 관리자/일반 직원으로 구분.

##### **3) 메뉴 상품 관리**
- **재고 확인 및 수정**: 메뉴별 재고량 확인 및 수정
- **판매 설정**: 이벤트 설정, 메뉴 할인율 적용, 쿠폰 사용 가능 여부 설정
- **판매 관리**: 메뉴 판매 활성화/비활성화 설정

##### **4) 재고 관리**
- **재료 재고 관리**: 각 재료별 현재 재고량 조회와 부족 시 주문 알림.
- **주문 기록 관리**: 발주 내역 저장 및 추적 가능.

##### **5) 스케줄 관리**
- 직원 휴가 및 일정 관리, 스케줄 충돌 시 알림.
- 가게 이벤트 관리와 주문 일정 및 재고 연동.

##### **6) 인사 관리**
- 휴가, 병가, 조퇴 신청 관리와 승인/반려 시스템 제공.

##### **7) 보고서 생성 및 알림**
- 월별 매출, 직원 근무 기록, 재고 소모 등 주요 데이터 요약 제공.
- 재고 부족 및 미처리 요청에 대한 알림 시스템.
------

#### **3. 보안 및 권한 관리**

- **비밀번호 암호화**: bcrypt를 활용하여 안전한 비밀번호 저장.(확인중)
- **로그인 실패 처리**: 5회 이상 연속 실패 시 계정 잠금 및 관리자 알림.
- **로그 기록**: 로그인/로그아웃 및 주요 데이터 변경 로그 생성.
------

#### **4. 테스트 계획**

- **유닛 테스트**: 기능별 단위 테스트 케이스 작성 및 검증.
- **통합 테스트**: 시스템 전체의 상호작용 테스트.
- **부하 테스트**: 예상 최대 사용량에 따른 성능 확인 및 개선.
------

#### **5. UI/UX 설계**

- **대시보드**: 관리자 로그인 시 주요 정보 한눈에 표시 (출근자 수, 재고 부족 품목 등).
- **직관적 인터페이스**: 직관적인 버튼과 구성으로 사용자의 편의성 증대.
------

#### **6. 유지보수 및 확장성**

- **모듈화 설계**: 각 기능별 독립된 클래스로 구성하여 유지보수와 확장 용이.
- **버전 관리**: Git을 활용하여 팀원 간 협업 및 코드 이력 추적.
------

#### **7. 문서화**

- **클래스 다이어그램**: 각 클래스 간 관계를 시각화하여 유지보수 용이.
- **API 스펙 문서**: RESTful API 명세서 포함하여 향후 확장 가능성 고려.
------

### 3. 폴더 구조
```
src/
├── main/
│   ├── Main.java
│   ├── MenuManager.java
├── auth/
│   └── Login.java
├── employee/
│   ├── EmployeeManager.java
│   └── Employee.java
├── menu/
│   ├── MenuManager.java
│   └── MenuItem.java
├── inventory/
│   ├── InventoryManager.java
│   └── Ingredient.java
├── schedule/
│   ├── ScheduleManager.java
│   └── Schedule.java
├── hr/
│   ├── HRManager.java
│   └── LeaveRequest.java
├── report/
│   └── ReportManager.java
└── util/
    ├── DBConnection.java
    └── InputValidator.java
```

#### **폴더 및 클래스 구조 설명**
**`src/`**
- `main/`
  : 주요 실행 클래스 및 애플리케이션 시작점
  - `Main.java`: 프로그램 진입점
  - `MenuManager.java`: 프로그램 메뉴 선택 및 흐름 제어

- `auth/`
  : 인증 관련 클래스
  - `Login.java`: 로그인 및 권한 관리

- `employee/`
  : 직원 관리 관련 클래스
  - `EmployeeManager.java`: 직원 등록, 수정, 삭제 로직
  - `Employee.java`: 직원 정보를 담는 모델 클래스

- `menu/`
  : 메뉴 상품 관리 관련 클래스
  - `MenuManager.java`: 메뉴 등록, 수정, 삭제, 이벤트 할인 적용 관리
  - `MenuItem.java`: 메뉴 정보를 담는 모델 클래스

- `inventory/`
  : 재고 관리 관련 클래스
  - `InventoryManager.java`: 재료 등록, 재고 확인, 재료 주문 관리
  - `Ingredient.java`: 재료 정보를 담는 모델 클래스

- `schedule/`
  : 스케줄 관리 관련 클래스
  - `ScheduleManager.java`: 가게 일정 및 직원 스케줄 관리
  - `Schedule.java`: 스케줄 정보를 담는 모델 클래스

- `hr/`
  : 인사 관리 관련 클래스
  - `HRManager.java`: 휴가, 조퇴, 병가 등 관리
  - `LeaveRequest.java`: 인사 요청 정보를 담는 모델 클래스

- `report/`
  : 보고서 생성 관련 클래스
  - `ReportManager.java`: 월별 매출, 재고 소모 등 보고서 생성

- `util/`
  : 공통 유틸리티
  - `DBConnection.java`: 데이터베이스 연결 및 종료 관리
  - `InputValidator.java`: 입력값 검증 유틸리티
 ------

### 4. RESTful API 설계 (추후 확장을 고려)

#### **1) 인증**

| 메서드 | 경로    | 설명            | 요청 데이터            | 응답 데이터     |
| ------ | ------- | --------------- | ---------------------- | --------------- |
| POST   | /login  | 사용자 로그인   | `username`, `password` | `token`, `role` |
| POST   | /logout | 사용자 로그아웃 | `token`                | `status`        |

#### **2) 직원 관리**

| 메서드 | 경로        | 설명           | 요청 데이터                 | 응답 데이터      |
| ------ | ----------- | -------------- | --------------------------- | ---------------- |
| GET    | /employees  | 모든 직원 조회 | `token`                     | 직원 리스트      |
| POST   | /employees  | 직원 등록      | `name`, `role`, `salary` 등 | 생성된 직원 정보 |
| PUT    | /employees/ | 직원 정보 수정 | `name`, `role`, `salary` 등 | 수정된 직원 정보 |
| DELETE | /employees/ | 직원 삭제      | `id`                        | 삭제 상태        |

#### **3) 메뉴 관리**

| 메서드 | 경로   | 설명             | 요청 데이터                 | 응답 데이터      |
| ------ | ------ | ---------------- | --------------------------- | ---------------- |
| GET    | /menu  | 메뉴 리스트 조회 | `token`                     | 메뉴 리스트      |
| POST   | /menu  | 메뉴 추가        | `name`, `price`, `stock` 등 | 생성된 메뉴 정보 |
| PUT    | /menu/ | 메뉴 정보 수정   | `name`, `price`, `stock` 등 | 수정된 메뉴 정보 |
| DELETE | /menu/ | 메뉴 삭제        | `id`                        | 삭제 상태        |

#### **4) 보고서**

| 메서드 | 경로           | 설명             | 요청 데이터 | 응답 데이터             |
| ------ | -------------- | ---------------- | ----------- | ----------------------- |
| GET    | /reports/month | 월별 보고서 조회 | `yearMonth` | 매출, 재고 등 요약 정보 |
 ------

### 5. 데이터베이스 ER 다이어그램
```mermaid
erDiagram
    EMPLOYEES {
        NUMBER EMP_ID PK
        VARCHAR2(50) NAME
        VARCHAR2(50) USERNAME
        VARCHAR2(100) PASSWORD
        VARCHAR2(20) ROLE
        DATE JOIN_DATE
    }

    MENU_ITEMS {
        NUMBER ITEM_ID PK
        VARCHAR2(100) NAME
        NUMBER PRICE
        NUMBER STOCK
        NUMBER DISCOUNT
        CHAR(1) IS_AVAILABLE
    }

    INGREDIENTS {
        NUMBER INGREDIENT_ID PK
        VARCHAR2(100) NAME
        NUMBER QUANTITY
        VARCHAR2(10) UNIT
        NUMBER MIN_QUANTITY
    }

    SCHEDULES {
        NUMBER SCHEDULE_ID PK
        DATE DATE
        VARCHAR2(50) TYPE
        VARCHAR2(500) DETAILS
        NUMBER EMP_ID FK
    }

    LEAVE_REQUESTS {
        NUMBER REQUEST_ID PK
        NUMBER EMP_ID FK
        DATE START_DATE
        DATE END_DATE
        VARCHAR2(500) REASON
        VARCHAR2(20) STATUS
    }

    LOGIN_HISTORY {
        NUMBER HISTORY_ID PK
        NUMBER EMP_ID FK
        TIMESTAMP LOGIN_TIME
        TIMESTAMP LOGOUT_TIME
    }

    EMPLOYEES ||--o{ SCHEDULES : "has"
    EMPLOYEES ||--o{ LEAVE_REQUESTS : "submits"
    EMPLOYEES ||--o{ LOGIN_HISTORY : "creates"



