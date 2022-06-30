# ReadMe

## 一、结构介绍

### consul

consul 注册中心，其他地方没有用到，仅用于了解

### eureka01、eureka02

eureka 注册中心，两个注册中心相互注册，应用名相同，端口不同，模拟集群

### consumer-eureka

向 Eureka 注册的 消费者，这里使用 ribbon 实现点对点直连，服务内调用

部署时，没有采用

### consumer-eureka-feign

向 Eureka 注册的消费者，这里 使用 opfeign 进行服务内调用

部署时，采用该服务做消费者

### provider01、provider02

向 Eureka 注册的服务提供者，用于提供服务，这里两个服务应用名相同，端口不同，用于模拟集群

### parent

仅包含 pom.xml，作为所有微服务的 父级 pom，用以对所有微服务的依赖、配置、打包进行统一配置

## 二、配置文件

### 1、根目录 

#### pom.xml

用于整理Spring Cloud 结构，定义了 该项目包含哪些微服务 

#### nginx.conf

用于 nginx 配置

#### docker-compose-up.yml

用于整理 Docker 镜像结构，以及镜像的配置

### 2、微服务根目录

#### Dockerfile 

用于将打包好的Jar文件 整理，为打包为 Docke镜像做准备

