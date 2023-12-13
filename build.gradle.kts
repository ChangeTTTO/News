// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0-Beta1" apply false
    id("com.android.library") version "8.1.3" apply false
}
//扩展配置
//相当于定义常量
//只是我们这里定义的常量是在gradle文件中引用
//而不是在java文件中引用
ext {
    //目标版本
    set("targetSdk",33)
}
