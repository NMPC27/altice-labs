# altice-labs

## Project Description
A simple API with a single endpoint where the user can retreive the result of the labseq sequence given an index.

## Prerequisites
- Java JDK (version 17 or above)
- Apache Maven (version 3.6.3 or above)

## How to Run (Development)
To run the project in development mode:

1. Install the dependencies, compile the project and start the development server:
   ```bash
   quarkus dev
   ```

This will start the development server, and you can view the project by navigating to http://localhost:8080 in your browser. (Dont forget to check the endpoint ex. http://localhost:8080/labseq/10)

## How to Build

1. Package the application:

    ```bash
    mvn package
    ```
The production-ready files will be generated in the /target directory.


## Running Tests Locally

1. Run the test command
    
    ```bash
    mvn test
    ```

## Building docker image

1. Build the docker image:

    ```bash
    docker build -f src/main/docker/Dockerfile.jvm -t alticelabs/labseq .
    ```

2. Run the docker image:

    ```bash
    docker run -i --rm -p 8080:8080 alticelabs/labseq
    ```


## CI/CD Pipeline

The CI/CD pipeline is implemented using GitHub Actions. The pipeline is triggered on every push to the main branch. The pipeline consists of the following steps:

1. Checkout the code
2. Set up JDK 17
3. Build the project
4. Run the tests (during build)
5. Build the docker image
6. Push the docker image to Docker Hub

The pipeline also has suport for caching to speed up future builds.

## Docker Image

The docker image is available on Docker Hub. You can pull the image using the following command:

```bash
docker pull alticelabs994/labseq:latest
```
You can also check the Docker Hub repo on:
https://hub.docker.com/repository/docker/alticelabs994/labseq/general


## API Documentation

To access the documentation go to http://localhost:8080/swagger-ui/ while the API is running.