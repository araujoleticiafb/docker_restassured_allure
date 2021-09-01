## APIs Automation

This project contains the structure of APIs automation.

### 🔧 Tools & Technologies

The project applies the framework [RestAssured](https://rest-assured.io/) used with [Docker](https://hub.docker.com/r/rodolpheche/wiremock). Also, tests results are displayed in [Allure](https://docs.qameta.io/allure/).
> **NOTE 1:** [Click here to convert json to schema](https://www.liquid-technologies.com/online-json-to-schema-converter)

### 📦 Project organization

The project has the following structure:

  ```
    ├──src/test/java
    │  ├──[name]
    │  │  ├──constants
    │  │  │  ├──[file]
    │  │  ├──service
    │  │  │  ├──[service_name_one]
    │  │  │  ├──[TestFiles]
    ├──src/test/resources
    │  ├──[schemas]
    |  |  ├──[name]
    │  │  |  ├──[schemaFiles.json]
  ```

## 🚀 Running with Docker
Download and install [Docker](https://www.docker.com/products/docker-desktop).

### Build
```sh
$ docker build -t YOUR_IMAGE_NAME .
```
### Run http
```sh
$ docker run -it -p 8787:8787 YOUR_IMAGE_NAME
```
> **NOTE 2:** Replace **YOUR_IMAGE_NAME**.

### View Allure Reports
```sh
$ http://localhost:8787
```
> **NOTE 3:** When running tests using Docker you could not click on the URL, which is displayed. So you must change http://172.17.0.3:8787 to http://localhost:8787.

## ✨Running locally

### Install allure
```sh
$ brew install allure
```

### Run tests
```sh
$ mvn clean test
```

### Generate report
```sh
$ allure serve allure-results
```

### View Allure Reports
Click on the URL, which is displayed.