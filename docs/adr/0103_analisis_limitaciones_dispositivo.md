A1.3 · Análisis de limitaciones de un dispositivo
Objetivo: relacionar las limitaciones del hardware con decisiones concretas de diseño de software.

Sobre un dispositivo real (el tuyo o uno del departamento), documenta:

Especificaciones: procesador, RAM, almacenamiento libre, pantalla (tamaño, resolución, densidad), versión de Android y nivel de API.
Sensores disponibles. Puedes usar una app de diagnóstico para listarlos.
Estado de la batería y consumo por aplicación (Ajustes → Batería).

--------------------------------------------------------------------------------------------

Para realizar este ejercicio he utilizado como dispositivo de referencia un Samsung Galaxy S9+.

1. Especificaciones del dispositivo

Procesador: Octa-Core, hasta 2,7/2,8 GHz dependiendo de la versión.
RAM: 6 GB.
Almacenamiento: 64 GB. En este caso, aproximadamente 20 GB libres.
Pantalla: 6,2 pulgadas, Super AMOLED.
Resolución: 2960 x 1440 píxeles.
Densidad: 529 ppp.
Sistema operativo: Android 10.
Nivel de API: API 29.
Batería: 3500 mAh.

El Galaxy S9+ originalmente se comercializó con Android 8 y dispone de 6 GB de RAM y 
diferentes capacidades de almacenamiento. La pantalla es de 6,2 pulgadas con resolución 2960 x 1440 y 
529 ppp.

2. Sensores disponibles

Según las especificaciones del dispositivo, dispone de varios sensores:

Acelerómetro.
Giroscopio.
Barómetro.
Sensor geomagnético.
Sensor de proximidad.
Sensor de luz RGB.
Sensor de huellas dactilares.
Sensor Hall.
Sensor de frecuencia cardíaca.
Sensor de iris.
Sensor de presión.
También dispone de GPS, que permite obtener la ubicación del dispositivo.

3. Estado de la batería y consumo

La batería del Galaxy S9+ es de 3500 mAh. En el apartado Ajustes → Batería, se puede comprobar el porcentaje de batería y qué aplicaciones están realizando un mayor consumo.
En el dispositivo utilizado como ejemplo, se podría observar algo como:

Batería restante: 
Pantalla: 
Aplicaciones en segundo plano: 
Wi-Fi y datos móviles:

4. Conclusiones de diseño

Optimizar el consumo de batería.
   Como la batería es de 3500 mAh y la pantalla Quad HD+ es uno de los elementos que más batería puede consumir, evitaría animaciones excesivas y procesos innecesarios en segundo plano. La aplicación debería consumir recursos solamente cuando sean necesarios.

Diseñar pensando en una pantalla de 6,2 pulgadas.
   Al tener una resolución de 2960 x 1440 y una densidad de 529 ppp, utilizaría diseños adaptables y tamaños de texto adecuados para que los elementos sean fáciles de leer y pulsar. No colocaría botones demasiado pequeños.

Aprovechar los sensores sin hacerlos obligatorios.
   El dispositivo dispone de acelerómetro, giroscopio, GPS, sensor de luz y otros sensores. Por ejemplo, podría utilizar el acelerómetro para detectar la orientación, pero la aplicación debería seguir funcionando aunque una función concreta relacionada con un sensor no esté disponible o esté desactivada.