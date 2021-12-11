# refuseClassification
一个使用springboot和thymeleaf搭建的垃圾分类检索系统。本系统是来交实训作业的，所以还是存在着很多的bug，因为我也比较懒，所以就就就应付一下哈哈哈
## 使用技术
> Springboot、Thymeleaf、bootstrap、Mysql
## 说明
> 本项目只是自己为了交实训报告而写的，并没有花太多时间去认真写（后续可能会前后端分离重构一个版本，毕竟思路全部都有了），页面也是根据别人写好的改的，有一些是自己一边抄一点的哈哈哈。如果你也想要应付的话，需要修改数据库的信息和token的信息。数据库已经放在本项目根目录了。
> 数据库修改在application.yml
## 主要功能
### 目前有的功能
#### 前台
* 检索垃圾属于什么分类 (初步完成，是对接了alapi的接口，需要到alapi.cn申请token 填写在SearchServiceImpl的57行
* 登录、注册功能
* 提交正确的分类到数据库（因为没有进行判断，所以会有一些bug）
#### 后台
* 最近的登录记录
* 最近添加的垃圾分类词条
* 系统人数查询（管理员人数、所有用户数量、垃圾分类词条数量、登录记录数量）
* 用户管理
* 查询所有用户
* 增删改用户（未实现，不想花时间了
* 垃圾分类词条管理
* 增删改词条（未实现，同上）
## 演示截图
### 前台
首页
![首页](https://s2.loli.net/2021/12/11/D6ZXG3LmchNRwFC.png)

搜索页面
![搜索页面](https://s2.loli.net/2021/12/11/IogMdE3lRQKL1wJ.png)

登录页面
![登录页面](https://s2.loli.net/2021/12/11/mQ2hjxwsuJ5BFAH.png)

注册页面
![注册页面](https://s2.loli.net/2021/12/11/jme6gbaSiIFKqET.png)

### 后台
后台首页
![后台首页](https://s2.loli.net/2021/12/11/EdsXt1LTU2yAxi5.png)

用户列表
![查询所有用户](https://s2.loli.net/2021/12/11/ubJDcqEko2dBYQi.png)

词条列表
![词条列表](https://s2.loli.net/2021/12/11/tPwe1JkjRSMhzFr.png)
