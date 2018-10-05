# Сar Info application
## Описание
REST-сервис для CRUD-операций с данными определенного формата. Данные сохраняются в MongoDB. Предоставляются следующие эндпоинты:
```
GET /cars/{serialNumber}
PUT /cars
DELETE /cars/{serialNumber}

GET /centers/{centerId}/cars
POST /centers/{centerId}/cars
```
В качестве тела запроса для POST и PUT методов используется данные следующего формата:
```
{
  "ownerName": "Aleksei",
  "serialNumber": 123456789,
  "modelYear": 1998,
  "code": "A456VBH78",
  "vehicleCode": "12344GDVT",
  "engine": {
    "capacity": 16,
    "numCylinders": 2,
    "maxRpm": 5,
    "manufacturerCode": "C"
  },
  "fuelFigures": {
    "speed": 256,
    "mpg": 14.3,
    "usageDescription": "Usage Description"
  },

  "performanceFigures": {
    "octaneRating": 95,
    "acceleration": {
      "mph": 280,
      "seconds": 56.3
    }
  },
  "manufacturer": "Honda",
  "model": "Odyssey",
  "activationCode": "MBJ5648FR8"
}
```
В базе данных используются 2 коллекции: carCenters и cars. По умолчанию в коллекции carCenter имеется запись с _id="123456789"

## Идеи для масштабирования
1. В зависимости от того, насколько большая будет нагрузка на REST-эндпоинты (количество запросов от клиента), или на базу данных (количество транзакций), можно выделить REST и DAO-сервисы в отдельные ноды, которые можно легко горизонтально масштабировать и связывать между собой, например, посредством асинхронных сервисов обмена сообщениями (например, RabbitMQ)
2. Можно текущее приложение не делить, а целиком клонировать на несколько нод, и над ними поставить отдельный REST-модуль, который будет принимать все входящие запросы в систему и разпределять нагрузку между нодами.