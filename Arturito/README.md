# ArturitoV1.0.0
## Configuración Inicial 
Lo primero qué tenés que hacer (*antes de descargar el código del robot*) es visitar esta [página](https://docs.wpilib.org/en/stable/), esta va a ser tu referencia para todo lo relacionado con desarollo de software para este y otros robots de FIRST Robotics Competition. 
Más específicamente tenés que seguir las instrucciones que figuran [acá](https://docs.wpilib.org/en/stable/docs/getting-started/getting-started-frc-control-system/wpilib-setup.html) para instalar el entorno de desarrollo. No te olvides que este robot esta desarrollado en Java y tenés que seguir las instrucciones para ese lenguaje.
## ¿Cómo obtengo el código?
Hay tres formas de obtener el código, ordenado por la posibilidad de hacer macanas resulta la siguiente:
  - Extensión de VS Code para integrar con GitHub. Sabe más [acá](https://code.visualstudio.com/docs/editor/github)
  - Usar GitHub Desktop. Descargalo [acá](https://desktop.github.com/)
  - Usar la interfaz de línea de comandos CLI de [Git](https://git-scm.com/). _miedo_ 
  - Descargar como ZIP. Directamente en el repositiorio hay una opción para hacer eso en la esquina derecha.
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
A nosotros nos interesa particularmente la carpeta _java/frc/robot_ porque es ahí donde vamos a encontrar el código del robot. Pero eso no significa que el resto de las carpetas y archivos no cumplan funciones importantes.
Es por eso que te conviene mirar algunos vídeos para interiorizarte más en el funcionamiento de algunas herramientas que estamos utilizando.
- (What are Build Tools | What is Gradle | Step by Step)[https://www.youtube.com/watch?v=Nabjqv8KDgc] un vídeo cortito en inglés que nos explica que es Gradle, la build tool que usamos en este caso y porqué es importante.
- [¿Qué es la WPILIB?](https://docs.wpilib.org/en/stable/docs/software/wpilib-overview/what-is-wpilib.html)
## Archivos importantes
### Robot.java
Acá vas a encontrar nuestra clase ```Robot```que contiene toda la lógica básica para el funcionamiento del robot. Vas a ver el uso de la keyword ```@Override``` y el uso de ```extends```. Aunque tal vez hayas usado anteriormente estos términos, entender porqué los usas es clave para desarrollar código Java.
Para eso podés buscar en Google o ver este [vídeo](https://www.youtube.com/watch?v=CWYv7xlKydw). 
### Susbsistemas
#### ¿Qué es un subsistema?
Nuestros subsistemas o _subsystems_ son las distintas partes del robot que cumplen diferentes funciones. Vas a poder encontrar la implementación de cada uno en la carpeta ```subsystems```.
#### ¿Por qué dividimos el código en susbsistemas?
Dividir el código en subsistemas nos permite implementar uno de los principios más importantes del desarrollo de software, especialmente cuando uno encara grandes proyectos. La *abstracción*, para saber más sobre este interesante concepto y por qué resulta tan importante mirá este [vídeo](https://www.youtube.com/watch?v=L1-zCdrx8Lk).
### Comandos
#### ¿Qué es un comando?
Es una instrucción o conjunto de instrucciones a ejecutar. No tiene mucho misterio realmente
#### ¿Por qué usamos comandos?
En primer lugar porque la documentación de la WPILIB lo [recomienda](https://docs.wpilib.org/en/stable/docs/software/commandbased/what-is-command-based.html). En segundo lugar nos permite aprovechar mejor la separación en subsistemas y tener un código más conciso y claro.
### Otros recursos útiles para poder entender el código que existe y desarrollar nuevas funciones
- Object-oriented Programming in 7 minutes - [Mosh](https://www.youtube.com/watch?v=pTB0EiLXUC8)
- Entendiendo el controlador PID - Understanding [PID Controller](https://www.youtube.com/watch?v=wkfEZmsQqiA)
- ¿Cómo se ejecutan y programan los comandos? - [CommandScheduler WPILIB](https://docs.wpilib.org/en/stable/docs/software/commandbased/command-scheduler.html)
- ¿Se te ocurre algún otro recurso que te pareció útil? Agregalo
### ¿Cómo hago para contribuir modificaciones al código

_SECCIÓN EN DESARROLLO_
