##### 对项目中对细节的总结和对疑惑的地方记录
在sprintboot中,对中文编码的设置
```
在application.properties中添加必要的设置

server.servlet.encoding.charset=utf-8
server.servlet.encoding.force=true
server.servlet.encoding.enabled=true

```

很多的资料会有些旧，但是编辑器会进行提示，如果使用yml的文件格式，可以在网站 https://www.toyaml.com/index.html
进行转化,比如如下，使用缩紧进行处理层级

```
server:
  servlet:
    encoding:
      charset: utf-8
      enabled: true
      force: true

```
