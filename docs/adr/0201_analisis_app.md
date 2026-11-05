# A2.1 · Análisis de una app de código abierto

Objetivo: identificar en un proyecto real los componentes y clases que se han presentado en este tema.

## Cuántas Activities tiene y qué destinos de navegación (pantallas) contiene, siguiendo el enfoque moderno visto en clase.

Tiene solo una Activity, la MainActivity, que es el enfoque moderno recomendado en Compose. 
En cuanto los destinos de navegación estan definidos en JetnewsApp que recibe appContainer, isBackEnabled e initialBackStack y son
HomeKey y handleDeepLink

## Si usa Services, Broadcast Receivers o Content Providers, y para qué.

SegÚn el AndroidManifest tiene un Receiver .glance.JetnewsGlanceAppWidgetReceiver, no veo que utilice Service ni Content Provider.


```kotlin
<receiver
android:name=".glance.JetnewsGlanceAppWidgetReceiver"
android:exported="false"
android:enabled="@bool/glance_appwidget_available">
<intent-filter>
<action android:name="android.appwidget.action.APPWIDGET_UPDATE" />
</intent-filter>
<meta-data
android:name="android.appwidget.provider"
android:resource="@xml/jetnews_glance_appwidget_info" />
</receiver>
```

## Qué contiene su AndroidManifest.xml: componentes declarados, permisos solicitados, cuál es la actividad de arranque.

Un Activity (MainActivity), un BroadcastReceiver (JetnewsGlanceAppWidgetReceiver). Sin Services ni ContentProviders.

Permisos: ninguno.

Actividad de arranque: MainActivity


## Cómo está organizada la estructura de paquetes.

Utiliza una estructura de paquetes organizada por características feature-based combinada con capas de arquitectura.

data: Contiene la lógica de datos (repositorios, contenedor de dependencias y manejo de resultados).

model: Define las clases de datos principales (Post, PostsFeed).

ui: Es el paquete más grande y está dividido por pantallas (home, interests, post) y componentes reutilizables (components, theme). En su raíz se encuentran los archivos clave como MainActivity, JetnewsApp (componente raíz) y la configuración de navegación.

deeplink y glance: Paquetes aislados para gestionar los enlaces profundos y el widget de la pantalla de inicio.
