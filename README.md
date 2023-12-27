# Mosstures

![banner](pictures/banner.png)

My first simple Spring Boot project.
This application is dedicated to managing vanilla Minecraft textures.


## Docker

To run the application, you need to build a Docker image and run a container based on it.

```
docker build -t mosstures .
```

```
docker run --name mosstures -d -p 8080:8080 mosstures
```


## Usage

Get texture in base size (16x16)

```
GET http://localhost:8080/texture/moss_block
```

Get a texture with a given resolution

```
GET http://localhost:8080/texture/moss_block/512
```
