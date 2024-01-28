package com.example.hiltsample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 使用Hilt則一定要有個Application類別，觸發代碼生成的操作
// 包含提供 application-level dependency 容器
// 產生的Hilt元件附加到Application物件的生命週期並提供依賴項目
@HiltAndroidApp
class MainApplication: Application() {}