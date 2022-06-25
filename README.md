# Aplicacion DEMO para UTEL

## Back de consultas para busquedas de articulos en Mercado Libre Argentina


<p>
Creada usando Springboot

### USO
<p>
Para compilar el componente hay que correr la instruccion 

``` batch
mvn clean package -Pjar
```

<p>
Para ejecutar el componente hay que correr la instruccion 

``` batch
java -jar target/BackUtel.jar
```

Consume el servicio publico de mercado libre https://api.mercadolibre.com/sites/MLA/search


### LOGS
<p>
Se genera un archivo llamado back-utel.log (recursivo) en la carpeta logs
Para poder ver los logs generados de la aplicacion, ejecutar la siguiente instruccion


``` batch
tail -999f logs/back-utel.log
```



