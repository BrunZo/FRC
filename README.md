# Arturito v1.0.0
## Configuración inicial 
Lo primero que vas a tener que hacer *antes de descargar el código del robot* es visitar [esta página](https://docs.wpilib.org/en/stable/), que va a ser tu guía en todo lo relacionado con desarrollo de software para este y otros robots de FIRST Robotics Competition. 
Más específicamente, vas a tener que seguir las instrucciones que figuran [acá](https://docs.wpilib.org/en/stable/docs/getting-started/getting-started-frc-control-system/wpilib-setup.html) para instalar el entorno de desarrollo. No te olvides que este robot está desarrollado en Java y vas a tener que seguir las instrucciones para ese lenguaje.
## ¿Cómo obtengo el código?
Hay cuatro formas de obtener el código, que listamos a continuación: *(ordenadas por probabilidad de mandarse macanas)*
  - Instalar la extensión de Visual Studio Code para integrar con GitHub. Más información [acá](https://code.visualstudio.com/docs/editor/github).
  - Usar GitHub Desktop, que se puede descargar [acá](https://desktop.github.com/).
  - Usar la interfaz de línea de comandos [CLI de Git](https://git-scm.com/). *(miedo)*
  - Descargar el código como ZIP, lo cual se puede hacer directamente desde el botón en la esquina derecha.
## ¿Qué vas a encontrar en la carpeta? 
Cuando abras por primera vez la carpeta te vas a encontrar con una estructura parecida a esta:
````
ArturitoV[código de versión]
  - .gradle
  - .src
  - .wpilib
  - build
  - gradle
  - src/main
    - deploy
    - java/frc/robot
  - vendordeps
  - .gitignore
  - build.gradle
  - gradlew
  - gradlew.bat
  - settings.gradle
````
A nosotros nos interesa particularmente la carpeta _java/frc/robot_ porque es ahí donde vamos a encontrar el código del robot, pero esto tampoco significa que el resto de las carpetas y archivos no cumplan funciones importantes. Es por esto que quizás te convenga ojear algunos de estos recursos para poder familiarizarte con las herramientas que estamos utilizando:
- [What are Build Tools | What is Gradle | Step by Step](https://www.youtube.com/watch?v=Nabjqv8KDgc) es un vídeo cortito en inglés que nos explica qué son Gradle y la Build Tool que usamos en este caso, y por qué son importantes.
- [¿Qué es la WPILIB?](https://docs.wpilib.org/en/stable/docs/software/wpilib-overview/what-is-wpilib.html)
## Archivos importantes
### Robot.java
Acá vas a encontrar nuestra clase ```Robot``` que contiene toda la lógica básica para el funcionamiento del robot. En esta clase, vas a notar la presencia de las keywords ```@Override``` y ```extends```, y entender cómo y por qué se usan es clave para empezar a desarrollar código Java. Si querés aprender un poco, podés buscar en Google o ver [este vídeo](https://www.youtube.com/watch?v=CWYv7xlKydw). 
### Subsistemas
#### ¿Qué es un subsistema?
Los subsistemas o _subsystems_ son las distintas partes del robot que cumplen diferentes funciones. Vas a poder encontrar la implementación de cada uno de ellos en la carpeta ```subsystems```.
#### ¿Por qué dividimos el código en susbsistemas?
Dividir el código en subsistemas nos permite implementar uno de los principios más importantes del desarrollo de software, la *abstracción*, la cual es especialmente útil cuando uno encara proyectos más grandes. Para saber más, podés mirar [este vídeo](https://www.youtube.com/watch?v=L1-zCdrx8Lk).
### Comandos
#### ¿Qué es un comando?
Un comando o *command* es una instrucción o conjunto de instrucciones a ejecutar. No tiene mucho misterio realmente.
#### ¿Por qué usamos comandos?
En primer lugar, porque la documentación de la WPILIB [lo recomienda](https://docs.wpilib.org/en/stable/docs/software/commandbased/what-is-command-based.html). En segundo lugar, porque nos permite aprovechar mucho mejor la separación en subsistemas y ayuda a tener un código más conciso y claro.
### Otros recursos útiles para poder entender el código que existe y desarrollar nuevas funciones
- [Object-oriented Programming in 7 minutes - Mosh](https://www.youtube.com/watch?v=pTB0EiLXUC8).
- Entendiendo el controlador PID - [Understanding PID Controller](https://www.youtube.com/watch?v=wkfEZmsQqiA).
- ¿Cómo se ejecutan y programan los comandos? - [CommandScheduler WPILIB](https://docs.wpilib.org/en/stable/docs/software/commandbased/command-scheduler.html).
- ¿Se te ocurre algún otro recurso que te pareció útil? Agregalo.
### ¿Cómo hago para contribuir modificaciones al código?
_SECCIÓN EN DESARROLLO_
