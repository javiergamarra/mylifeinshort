Un proyecto de formación en Hibernate/CDI.

Necesita una base de datos H2 lanzada en modo server y el servidor de aplicaciones JBoss 7.1

PASOS PARA LA INSTALACIÓN

- Clone in desktop
- En eclipse utilizar la siguiente opción para la creación del proyecto: "Import existing project into workspace." eligiendo la ruta donde tengáis el proyecto que habéis clonado en el paso anterior.
- Descargaros JBOSS 7.1 desde: http://download.jboss.org/jbossas/7.1/jboss-as-7.1.1.Final/jboss-as-7.1.1.Final.zip Descomprimir el archivo
- Instalar H2 desde: http://www.h2database.com/html/main.html y lanzar la base de datos
- Configurar el servidor en eclipse con "Create runtime" en la pestaña de "Servers" (Windows/Preferences)
- Si os da errores de compilación comprobad las librerias dentro de WEB-INF/lib
