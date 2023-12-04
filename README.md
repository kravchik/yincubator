yincubator
=======
A small pile of stuff somehow survived the years of my professional growth.

No TDD, no best practices. It is left here for nostalgic reasons. I'll not try to clean this up, just will extracting into a separate project If something useful is crystallized.

## Pattern-matching

Flexible way to make 'selects' in your data-structures. Abstract syntax tree analysis, complex pattern matching on structured data.

[wiki](https://github.com/kravchik/jcommon/wiki/pattern-matching)
or
[habrahabr (russian)](http://habrahabr.ru/post/270173/)

## Vector arithmetics

Full set of common functions for 3D mathematics (for each x2/x3/x4 vector and vector/scalar):
 
* max
* min
* reflect
* smoothstep
* ...
* and many more

[look at Vec3f](https://github.com/kravchik/jcommon/blob/master/src/main/java/yk/jcommon/fastgeom/Vec3f.java) 

even more at [senjin](https://github.com/kravchik/senjin/blob/master/src/main/java/yk/senjin/shaders/gshader/ShaderParent.java)


## ANIO
**yk.jcommon.net.anio**

java.nio wrapper with node.js style API (because java.nio's API is not for human beings). Transfer data with just a few lines of code.

```java
    ASocket server = new ASocket(8000, socket -> {
        socket.send("welcome to server");
        socket.onData = data -> {
            System.out.println("server got: " + data);
            socket.send("ping");
        };
    });

    client1 = new ASocket("localhost", 8000, socket -> {
        socket.send("client1 is connected");
        socket.onData = data -> {
            System.out.println("client got: " + data);
            socket.send("pong");
        };
    });

```
* callbacks on connect, callbacks on data
* node.js style
* replaceable serialization engine
* no threads (threading control is on you) 

## mvn artifact
```xml
<repository>
   <id>yk.jcommon</id>
   <url>https://github.com/kravchik/mvn-repo/raw/master</url>
</repository>

<dependency>
    <groupId>yk</groupId>
    <artifactId>yincubator</artifactId>
    <version>0.05</version>
</dependency>
```
