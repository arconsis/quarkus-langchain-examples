# Examples for the Quarkus LangChain Extension

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

In this tutorial series, we take a close look into the Quarkus LangChain extension ([Docs](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html), [GitHub](https://github.com/quarkiverse/quarkus-langchain4j)).
This is the example code to the video tutorials linked below

## Video Tutorials

The following videos demonstrate and explain this code.

* [Video 1: Integrating ChatGPT and Hugging Face with Quarkus](https://youtu.be/u4SZMIlrvfs)
  * [Medium Post: Integrating ChatGPT & Hugging Face with Quarkus the LangChain Extension](https://medium.com/arconsis/unleashing-llms-integrating-chatgpt-hugging-face-with-quarkus-using-the-langchain-extension-022716d5f232) 
  * [Direct Link to the Code](https://github.com/arconsis/quarkus-langchain-examples/tree/basic-quarkus-langchain-integration)
* [Video 2: Managing Chat Memory with Stateless LLMs](https://youtu.be/L71nbLY2_5Q)
  * [Direct Link to the Code](https://github.com/arconsis/quarkus-langchain-examples/tree/with-memory-management)
* [Video 3: Enhancing ChatGPT with Retrieval Augmented Generation](https://youtu.be/hbPuRA525U0)
  * [Direct Link to the Code](https://github.com/arconsis/quarkus-langchain-examples/tree/retrieval-augmented-generation)


# Standard Quarkus README

## Prerequisites

This project example uses JDK 21. So please make sure you have a JDK 21 selected when building this project.

## To get started
* create a `.env` file by copying the `.env.template` file
* enter either your OpenAI API key or your HuggingFace API key


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/quarkus-llms-java-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- SmallRye Health ([guide](https://quarkus.io/guides/smallrye-health)): Monitor service health

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

### SmallRye Health

Monitor your application's health using SmallRye Health

[Related guide section...](https://quarkus.io/guides/smallrye-health)
