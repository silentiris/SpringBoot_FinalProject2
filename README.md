# SpringBoot_FinalProject2
# 2020科协后端大作业

> v1.0.0

Base URLs:

* <a href="http://localhost:8080">开发环境: http://localhost:8080</a>

# Default

## POST 提交报名信息

POST /registration-information

> Body 请求参数

```json
{
  "studentID": "20222022",
  "name": "咩酱",
  "qq": "1120222022",
  "phone": "18100000006",
  "major": "计算机科学与技术",
  "className": "一班",
  "wills": [
    {
      "organization": "科技协会",
      "department": "科技协会",
      "reason": "我要学技术！"
    },
    {
      "organization": "学生会",
      "department": "学习部",
      "reason": "学生会厉害！"
    }
  ],
  "isDispensing": true
}
```

### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明 |
| ---- | ---- | ------ | ---- | ---- |
| body | body | object | 否   | none |

> 返回示例

> 成功

```json
{
  "code": "00000",
  "message": "对的"
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

## GET   获取学生报名信息

GET /registration-information

### 请求参数

| 名称          | 位置   | 类型    | 必选 | 说明 |
| ------------- | ------ | ------- | ---- | ---- |
| pageNum       | query  | integer | 否   | none |
| pageSize      | query  | integer | 否   | none |
| keyword       | query  | string  | 否   | none |
| Authorization | header | string  | 是   | none |

> 返回示例

> 成功

```json
{
  "code": "00000",
  "message": "对的",
  "data": {
    "total": 2,
    "students": [
      {
        "studentID": "20222022",
        "name": "咩酱",
        "qq": "1120222022",
        "phone": "18100000006",
        "major": "计算机科学与技术",
        "className": "一班",
        "wills": [
          {
            "organization": "科技协会",
            "department": "科技协会",
            "reason": "我要学技术！"
          },
          {
            "organization": "学生会",
            "department": "学习部",
            "reason": "学生会厉害！"
          }
        ],
        "isDispensing": true
      },
      {
        "studentID": "20222023",
        "name": "猫",
        "qq": "1120222023",
        "phone": "18100000007",
        "major": "计算机科学与技术",
        "className": "二班",
        "wills": [
          {
            "organization": "科技协会",
            "department": "科技协会",
            "reason": "我要学技术！"
          },
          {
            "organization": "学生会",
            "department": "学习部",
            "reason": "学生会厉害！"
          }
        ],
        "isDispensing": false
      }
    ]
  }
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

## POST 登录

POST /login

> Body 请求参数

```json
{
  "studentID": "20222022",
  "name": "咩酱",
  "qq": "1120222022",
  "phone": "18100000006",
  "major": "计算机科学与技术",
  "className": "一班",
  "wills": [
    {
      "organization": "科技协会",
      "department": "科技协会",
      "reason": "我要学技术！"
    },
    {
      "organization": "学生会",
      "department": "学习部",
      "reason": "学生会厉害！"
    }
  ],
  "isDispensing": true
}
```

### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明 |
| ---- | ---- | ------ | ---- | ---- |
| body | body | object | 否   | none |

> 返回示例

> 成功

```json
{
  "code": "00000",
  "message": "对的",
  "data": {
    "token": "token"
  }
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

## GET 获取用户信息

GET /user/info

### 请求参数

| 名称          | 位置   | 类型   | 必选 | 说明 |
| ------------- | ------ | ------ | ---- | ---- |
| Authorization | header | string | 否   | none |

> 返回示例

> 成功

```json
{
  "code": "00000",
  "message": "对的",
  "data": {
    "username": "user01",
    "role": "admin"
  }
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构
