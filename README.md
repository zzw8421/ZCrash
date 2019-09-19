# ZCrash  
该库主要用于抓取程序异常崩溃信息并存储到本地，便于测试程序崩溃时，容易查找问题。  
该库还具有在本地文件打印log信息，方便在调试的时候查看开发中产生的信息。  

之前在开发阶段中抓取异常崩溃信息一直使用的腾讯的[Bugly](https://bugly.qq.com/v2/)，但是在使用过程中发现好多时候异常崩溃信息报不上去，一旦测试无法复现的时候，就无从查看该异常崩溃信息，但是有时候碰到异常崩溃但是也无从下手，所以就写了一个本地缓存异常的框架。  
## Zcrash的集成与使用  
#### 1.在build.gradle（app）中引用   

![引用](https://upload-images.jianshu.io/upload_images/10747033-f2f21ff487ba7bd4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

在dependencies 添加 ：
**implementation 'com.zzw.zcrash:zcrash:1.0.1'**  
如果出现引用失败的问题，请查看build.gradle（项目）中是否添加了Jcenter库。  
![Jcenter.png](https://upload-images.jianshu.io/upload_images/10747033-f50365766043d89a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 2.在Application中初始化
在自己自定义的applicationh中添加一下代码，初始化Zcrash。
`  ZCrashHelper.create(this); `
如果需要使用自定义配置：
请实例化ZCrashOption该类。  

|方法|说明|
|:-|:-:|
|setDirPath|设置Zcrash的根存储路径|
|setLogTAG|设置Zcrash在LogCat中打印信息的TAG|
|setCrashSolveType|设置发生异常后的处理方式(默认RESTARTAPP)|
|setPaintSpanCount|设置每个异常信息的间距|
|setIsPaintDetail|设置是否显示详细信息(暂未实现)|
|setShowTip|设置是否打印Toast提示崩溃问题(暂未实现)|

**CrashSolveType**共有三种类型可供选择：


|类型|说明|   
|:-|:-:|    
|SHUTDOWNAPP|直接关闭该APP|    
|RESTARTAPP|重新启动该APP(默认)|    
|USERDEFINED|自定义处理（需设置回调接口）|  

自定义处理接口可通过该方法设置
![image.png](https://upload-images.jianshu.io/upload_images/10747033-25996789362c8bd8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

自定义配置完成后在Application中通过该方法进行初始化：
  `ZCrashHelper.create(this, zCrashOption);`

**以上配置完成**
当有异常触发的时候会在本地设置的根目录里面以项目包名创建一个文件夹。

若使用默认配置的话 路径为    **/storage/emulated/0/crashLog/**。 

![image.png](https://upload-images.jianshu.io/upload_images/10747033-d294fdafa7dd7a9d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
![image.png](https://upload-images.jianshu.io/upload_images/10747033-1e626abb5bb1448a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)   
其中 crash_2019_09_19文件则为异常抓捕信息记录的txt,该异常信息以天为单位存储在txt中，若当天中有多个异常则追加到该日期txt下。  
异常信息捕捉如下：  
![image.png](https://upload-images.jianshu.io/upload_images/10747033-9ee448aa6389b663.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
#### 提示  

如果想在手机端查看异常信息可以下载一个[ES文件浏览器](http://www.estrongs.com/)进行查看。  
或者使用abd命令 导出在电脑端查看。  

adb pull /storage/emulated/0/crashLog  C:\Users\zzw\Desktop   
使用时将路径修改为自己设置的路径。    




# ZLog的使用    
ZLog主要是用来在本地存储Log的，主要用于后期测试在测试APP时无法在LogCat中打印日志，所以可以将一些重要日志打印到本地并持久化存储，便于后期查看和追踪问题。  
#### 初始化  

在自定义的application中通过一下代码进行ZLog的初始化  
`  ZLogHelper.init(this);`  
由于比较懒直接使用了ZCrash中的一些配置，所以请在初始化的时候一定在ZCrash的初始化后面进行。 

#### 使用  

  `ZLog.v("MainActivity", "这是一条用来测试静态类的Log");`  
![image.png](https://upload-images.jianshu.io/upload_images/10747033-3cc27140e4e440bb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
本地打印log跟在LogCat上打印log使用基本一致，打印后会存储在ZCrash中的配置的路径中的TAG文件夹中，以打印时的 TAG进行创建文件  
![image.png](https://upload-images.jianshu.io/upload_images/10747033-0426ec661df0756c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
具体打印出来的信息如下：  
![image.png](https://upload-images.jianshu.io/upload_images/10747033-9179037018acab43.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
包含打印时间，打印级别 ，在代码中的位置和输出的Log信息。  
