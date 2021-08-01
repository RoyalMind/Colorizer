# Instalación

```xml
<dependency>
    <groupId>net.royalmind.minecraft.library</groupId>
    <artifactId>Colorizer</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

# Uso
Para agregar un degradado, simplemente use las etiquetas <GRADIENT>

### DEGRADADO
```java
Colorizer.translate("<GRADIENT:2C08BA>Texto genial con un gradiente.</GRADIENT:028A97>");
```
### ARCOIRIS 1
```java
Colorizer.translate("<RAINBOW1>Este es un arcoiris mamalon</RAINBOW>");
```
### ARCOIRIS 2
El número después del arcoiris representa la saturación.
```java
Colorizer.translate("<RAINBOW100>Este es otro arcoiris mamalon</RAINBOW>");
```
### COLORES SOLIDOS
```java
Colorizer.translate("<SOLID:FF0080>Texto RGB Clasico");
```

Si se usa la version legacy se asignará el color al valor admitido más cercano (esto también funciona con degradado).
