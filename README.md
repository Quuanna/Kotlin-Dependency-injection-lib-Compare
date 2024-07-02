## 依賴注入定義
- 在單元測試中，如何讓不可測試的變成可以測試，使用注入方式，讓依賴關係改變成可被測試

## 舉例情境
### 賣雨傘晴天9折，雨天無折扣
1. 測試時產生問題 : 雨傘何時打折須依賴天氣決定
    - 先解決依賴關係，把天氣改成介面後使用注入方式，不要在買雨傘時實作取得天氣狀況，在外部處理，再注入買雨傘方法中
2. 解除依賴關係後，測試上如何進行呢?
    - 做"假物件"繼承物件實作後**代替真Weather傳入**，同時假物件要可控制，由假物件實作介面

## Injection 的種類
- Method injection  上述例子就屬此種類，方法注入
- Constructor injection 建構子時注入，能確保物件在使用時一定都會初始化，也確保不會被修改
- Property injection 比較少用，屬性公開提供直接修改
- Ambient context  比較少用，修改環境物件，例如單例模式

## library Injection 的種類
|                    | Dagger        | Hilt          | Koin          |
| -------------      | :---:  | :---:  | :---:  |
| Component          | 程式碼生成利用Annotation，compile後產生檔案 | 基於Dagger，在Android使用上做簡化 | 純Kotlin編寫，使用Kotlin語法糖，不使用Annotation和反射機制    |
| 學習成本            | 高 | 中 | 低|
| 編譯時間            | 慢  | 慢  | 快 |
| 需撰寫的程式碼量     | 多 | 多 | 少 |
| 自動生成程式碼       | yes  | yes  | no  |
| 編譯正確性          | yes  | yes  | no  |
| Android studio支持 | yes  | yes  | no  |

自動生成程式碼 
  - Dagger、Hilt 專案越大檔案越大

Android studio支持 
  - Dagger、Hilt 在4.1版本IDE有圖標<img width="45" alt="截圖 2024-01-28 下午3 15 35" src="https://github.com/Quuanna/DependencyInjectionExercise/assets/36694083/ac8ace4a-af02-4ab0-a808-1a5a092290ac">可以點擊查看程式碼間依賴關聯繫的關係
