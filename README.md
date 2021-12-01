# Instalación

#### Repositorio
```xml
<repository>
    <id>royalmind-snapshots</id>
    <url>https://packages.royalmind.net/repository/maven-snapshots/</url>
</repository>
```

#### Dependencia
```xml
<dependency>
    <groupId>net.royalmind.minecraft.library</groupId>
    <artifactId>Colorizer</artifactId>
    <version>1.0.2-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

# Uso
Para agregar un degradado, simplemente use las etiquetas 
```java
<G:#HEX></G> <RB:#HEX></RB> <S:#HEX>
```

### DEGRADADO
```java
Colorizer.translate("<G:2C08BA>Texto genial con un gradiente.</G:028A97>");
```
### ARCOIRIS 1
```java
Colorizer.translate("<RB1>Este es un arcoiris mamalon</RB>");
```
### ARCOIRIS 2
El número después del arcoiris representa la saturación.
```java
Colorizer.translate("<RB100>Este es otro arcoiris mamalon</RB>");
```
### COLORES SOLIDOS
```java
Colorizer.translate("<S:FF0080>Texto RGB Clasico");
```

Si se usa la version legacy se asignará el color al valor admitido más cercano (esto también funciona con degradado y arcoíris).
