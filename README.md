Telecom: Evamp & Saanga Java Test
===================================
A backend service to help the telecommunication operator to manage these functionalist's.

1. `Create Customer.`
2. `Create Sim.`
3. `Link sim to Customer.`
4. `Retrieve Customer Sims.`
5. `Retrieve all Sims.`
5. `Email notification to be sent 7 days before the customer's birthday.`
5. `Daily export having the list of customers having their birthday on the day.`

Decisions that i made
=====================
1. I used `docker-compose` to compose `2` services (`maildev`  `telecom-service`) `maildev` 
is the smtp server and `telecom-service` is spring backend service. 
This will help me to reduce clint side configurations.
2. Clean directory structure for code quality and understanding.
3. As i am new at java that's why i haven't implemented the java unit test. i am learning them using LinkedIn Learning.

`NOTE: first buid jar and then run docker-compose given command`

Step 1: Instructions to build the JAR file
=====================

1. Clone the repository or download and extract the archive file to your local directory.
2. Run `mvn clean`.
3. Run `mvn compile`.
4. Run `mvn package`.

Step 2: Instructions to run using docker-compose
===================================================

NOTE: Install docker first `https://docs.docker.com/docker-for-windows/install/`

1. Clone `https://github.com/mashood05/Telecom.git`.
2. Run   `docker-compose up -d --build --force-recreate`.

Step 3: Important Endpoints
==================================================

`mailDev web-interface is running at this endpoint you can check all mail related to birthday here `http://localhost:1080``

`1`. `Create customer: http://localhost:8080/v1/customer`

````
Body

{
    "name":"Loop",
    "email":"Loop@gmail.com",
    "date":"1999-02-12"
}

Responce

{
    "id": 1,
    "name": "Loop",
    "email": "Loop@gmail.com",
    "date": "1999-02-18"
}

````

`2`. `Create Sim: http://localhost:8080/v1/sim`

```
Body

{
    "simNumber":"55882237766",
    "simPin":"55555"
}

Responce

{
    "id": 5,
    "simNumber": "55882237766",
    "simPin": "55555"
}

```

`3`. `Get Customer by id : http://localhost:8080/v1/customer/1`

```
Body:none

Responce

{
    "id": 1,
    "name": "max",
    "email": "Hellow@gmail.com",
    "date": "1999-02-11",
    "sim": []
}

```

`4`. `Link Sim to Customer: http://localhost:8080/v1/link/1`

```
Body

{
    "id":[5] # sim id
}

Responce

{
    "id": 1,
    "name": "Loop",
    "email": "Loop@gmail.com",
    "date": "1999-02-18",
    "sim": [
        {
            "id": 5,
            "simNumber": "55882237766",
            "simPin": "55555"
        }
    ]
}

```

`5`. `Get all customer: http://localhost:8080/v1/customer`

```
Body:none

Responce

[
    {
        "id": 1,
        "name": "max",
        "email": "Hellow@gmail.com",
        "date": "1999-02-11",
        "sim": []
    },
    {
        "id": 2,
        "name": "Loop",
        "email": "Loop@gmail.com",
        "date": "1999-02-10",
        "sim": []
    },
    {
        "id": 6,
        "name": "Loop",
        "email": "Loop@gmail.com",
        "date": "1999-02-18",
        "sim": [
            {
                "id": 5,
                "simNumber": "55882237766",
                "simPin": "55555"
            }
        ]
    }
]

```

`6`. `Get Sim By Customer Id: http://localhost:8080/v1/sim/1`

```
Body:none

Responce

{
    "id": 5,
    "simNumber": "55882237766",
    "simPin": "55555"
}

```
`7`. `Get all Sim: http://localhost:8080/v1/sim`

```
Body:none

Responce

[
    {
        "id": 3,
        "simNumber": "55882237766",
        "simPin": "55555"
    },
    {
        "id": 4,
        "simNumber": "55882237766",
        "simPin": "55555"
    },
    {
        "id": 5,
        "simNumber": "55882237766",
        "simPin": "55555"
    }
]

```
