# 需求用例

## Use Case 1: Unlock

### 用例名称

`Unlock(UC-1)`

### 关联需求

* **REQ-1**: As a user, I can be sure that the doors by default will be locked.
* **REQ-2**: As a user, I will be able to unlock the doors using a mobile phone.
* **REQ-3**: An intruder will not be able to unlock the doors by using his own mobile phone; the system will block when it detects multiple lock-phone pairing failures.
* **REQ-4**: As a user, I can be sure that the doors will be automatically locked at all times.
* **REQ-8**: As a user, I will be able to view the history of accesses to my home.
* **REQ-9**: As a user, I will be able to configure the preferences for how my household devices will be activated on my arrival.

### 发起者

Any of: Tenant, Landlord

### 目标

To disarm the lock and enter, and get space lighted up automatically.

### 参与者

LockDevice, Household Device, Timer, Database

### 前置条件

* 门锁处于锁定状态。
* 已记录至少一个关联了手机的用户账号。

### 基本事件流

1. **Tenant/Landlord**发出解锁请求。

2. <u>include::`AuthenticateUser(UC-7)`</u>

3. **System**通知**LockDevice**解除锁定。

   （4-7可按任意顺序或并行进行）

4. **System**通知**Tenant/Landlord**门锁已打开。

5. **System**通知**Household Device**按用户配置打开设备。

6. **System**通知**Timer**开始自动锁定倒计时。

7. **Tenant/Landlord**打开房门，进入室内[并关门上锁]。

### 备选事件流

**2a**. 未查到附近有允许解锁的手机，用例结束。

**6a**. 倒计时结束但**Tenant/Landlord**未打开房门，**System**通知**LockDevice**锁定房门、通知**Tenant/Landlord**超时、通知**Household Device**关闭设备，用例结束。

**7a**. **Tenant/Landlord**未关门，**System**在倒计时结束时提醒**Tenant/Landlord**关门上锁，用例结束。

### 后置条件

* 室内设备已按用户配置打开。
* 门锁处于锁定状态。

### 子用例摘要

* **用例名称**：`AuthenticateUser(UC-7)`
* **参与者**：Database
* **前置条件**：已记录至少一个用户账号。
* **事件流**：系统检查是否有已记录手机位于附近，若有则查询其对应账号的权限，记录日志并返回结果。
* **注**：考虑到手机损坏和远程控制等情况，肯定要有其他认证方法。但暂时没要求写，就不展开了。

## Use Case 4: RetireUser

### 用例名称

`RetireUser(UC-4)`

### 关联需求

* **REQ-7**: As a user, I will be able to manage additional user accounts.

### 发起者

Landlord

### 目标

Retire an existing user account and disable access.

### 参与者

Database

### 前置条件

* 已记录至少一个用户账号。

### 基本事件流

1. **Landlord**发出查询请求。
2. <u>include::`AuthenticateUser(UC-7)`</u>
3. **System**向**Database**查询用户账号列表。
4. **System**向**Landlord**展示用户账号列表。
5. **Landlord**调整用户权限，提交修改。
6. **System**向**Database**记录修改结果。
7. **System**通知**Landlord**操作成功。

### 备选事件流

**2a**. 认证失败，用例结束。

**3a**.  **6a**. **Database**异常，**System**通知**Landlord**操作失败，用例结束。

### 后置条件

* 指定用户被撤销解锁权限。

# 测试用例

## TC-1

用于测试UC-1。

| 测试步骤                                               | 预期结果                                                     |
| ------------------------------------------------------ | ------------------------------------------------------------ |
| 1. 在已授权的手机位于门锁附近的情况下，请求解锁。      | 1. 门锁打开。<br />2. 用户收到门锁打开的通知。<br />3. 系统记录解锁信息。 |
| 2. 开门。                                              | 观察到室内设备已按用户设置打开。                             |
| 3. 关门。                                              | 门锁锁定。                                                   |
| 1a. 在没有已授权的手机位于门锁附近的情况下，请求解锁。 | 系统记录解锁失败信息。                                       |
| 2a. 一段时间不开门。                                   | 门锁锁定。                                                   |
| 3a. 一段时间不关门。                                   | 用户收到关门提醒。                                           |

## TC-4

用于测试UC-4。

| 测试步骤                   | 预期结果           |
| -------------------------- | ------------------ |
| 1. 房东查询用户列表。      | 系统展示用户列表。 |
| 2. 房东修改用户权限。      | 系统提示修改成功。 |
| 1a. 非房东者查询用户列表。 | 无事发生。         |