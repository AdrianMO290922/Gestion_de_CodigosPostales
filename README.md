# Gestion_de_CodigosPostales
Proyecto donde se desarrollara una API rest, donde se podran solicitar informacion de los codigos postales de Mexico, asi como municipios, estados y colonias
# Introducción
La siguiente documentación se hizo a partir de la creación de una API creada en micronaut, la cual maneja los siguientes bloques con información de los estados pertenecientes a al País de México :
1. **Estados**.
2. **Municipios**.
3. **Codigos Postales**.
4. **Colonias.**

Por medio de esta API se pueden hacer varios tipos de consultas, teniendo relaciones entre cada uno de sus bloques, la información presentada es la que actualmente se tiene. Todo el tipo de consultas que se hacen son de tipo GET, ya que la información no se puede manipular, solo consultar, se podrán realizar las siguientes consultas(se dividen en los bloques mencionados) :
### 1. Estados.
 _Obtencion de todos los estados._
- Endpoint: `/api/v1/estados`
- Descripción: Mediante un petición GET, extrae todos los estados de la base de datos creada.
- Respuesta:(Respuesta reducida por exceso de datos)
```json
 "error": false,
    "mensaje": "Estados cargados 32",
    "estados": [
        {
            "id_estado": 1,
            "estado": "Aguascalientes"
        },
        {
            "id_estado": 2,
            "estado": "Baja_California"
        },
        {
            "id_estado": 3,
            "estado": "Baja_California_Sur"
        },
        {
            "id_estado": 4,
            "estado": "Campeche"
        },
        {
            "id_estado": 5,
            "estado": "Coahuila_de_Zaragoza"
        },
        {
            "id_estado": 6,
            "estado": "Colima"
        },
        {
            "id_estado": 7,
            "estado": "Chiapas"
        },
    ]
```

_Obtención de un estado y su información a partir de su id._
- Endpoint:`/api/v1/estado/{id}`
- Descripción: Mediante una petición GET se filtra el ID y de esta forma se puede extraer un objeto tipo estado y brindarnos información sobre este.
- Ejemplo: `/api/v1/estado/16`
- Respuesta:
```json
{
    "error": false,
    "mensaje": "Estado caragado 1",
    "estado": {
        "id_estado": 16,
        "estado": "Michoacan_de_Ocampo"
    }
}
```


### 2. Municipios.
_Obtención de todos los municipios._
- Endpoint: `/api/v1/municipios` 
- Descripción: Mediante una petición GET, extrae todos los municipios de la base de datos creada.
- Respuesta: (Respuesta reducida por exceso de datos)
```json
{
    "error": false,
    "mensaje": "Municipios cargados 2475",
    "municipios": [
        {
            "id_estados": 1,
            "id_municipios": "1",
            "municipio": "Aguascalientes"
        },
        {
            "id_estados": 1,
            "id_municipios": "2",
            "municipio": "San Francisco de los Romo"
        },
        {
            "id_estados": 1,
            "id_municipios": "3",
            "municipio": "El Llano"
        },
        {
            "id_estados": 1,
            "id_municipios": "4",
            "municipio": "Rincon de Romos"
        },
        {
            "id_estados": 1,
            "id_municipios": "5",
            "municipio": "Cosio"
        },
        {
            "id_estados": 1,
            "id_municipios": "6",
            "municipio": "San Jose de Gracia"
        },
    ]
}

```


_Obtención de municipios dependiendo su estado._
- Endpoint: `/api/v1/municipios/estado/{id}`
- Descripción: Mediante una petición GET, se filtra el id de un Estado, del cual se listaran todos los municipios que tengan relación al ID del estado solicitado.
- Ejemplo: `/api/v1/municipios/estado/16`
- Respuesta:
```json
 "error": false,
    "mensaje": "Municipios cargados 113",
    "municipios": [
        {
            "id_estados": 16,
            "id_municipios": "814",
            "municipio": "Cuitzeo"
        },
        {
            "id_estados": 16,
            "id_municipios": "822",
            "municipio": "Querendaro"
        },
        {
            "id_estados": 16,
            "id_municipios": "901",
            "municipio": "Salvador Escalante"
        },
        {
            "id_estados": 16,
            "id_municipios": "861",
            "municipio": "Tepalcatepec"
        },
    ]
```
### 3. Codigos postales.
_Obtención de todos los códigos postales._
- Endpoint: `/api/v1/codigos_postales`
- Descripción: Mediante una petición GET se listaran todos los códigos postales que se encuentren en la base de datos creada.
- Respuesta: (Respuesta reducida por exceso de datos)
```json
 "error": false,
    "mensaje": "Se encontraron 31984 que pertenecen",
    "codigo_postal": [
        {
            "estado_id": 1,
            "municipio_id": 1,
            "estado": "Aguascalientes",
            "municipio": "Aguascalientes",
            "codigo_postal": 20000
        },
        {
            "estado_id": 1,
            "municipio_id": 1,
            "estado": "Aguascalientes",
            "municipio": "Aguascalientes",
            "codigo_postal": 20010
        },
        {
            "estado_id": 1,
            "municipio_id": 1,
            "estado": "Aguascalientes",
            "municipio": "Aguascalientes",
            "codigo_postal": 20016
        },
        {
            "estado_id": 1,
            "municipio_id": 1,
            "estado": "Aguascalientes",
            "municipio": "Aguascalientes",
            "codigo_postal": 20018
        },
    ]
```

_Obtención de los códigos postales según el municipio._
- Endpoint: `/api/v1/codigos_postales/municipio/{id}`
- Descripción: Mediante una petición GET se filtra el id del municipio, del cual se listaran todos los códigos Postales que tengan relación al ID del municipio solicitado.
- Ejemplo: `/api/v1/codigos_postales/municipio/796`
- Respuesta: (Respuesta reducida por exceso de datos)
```json
 "error": false,
    "mensaje": "Se encontraron 147 que pertenecen",
    "codigo_postal": [
        {
            "municipio": "Morelia",
            "codigo_postal": 58302
        },
        {
            "municipio": "Morelia",
            "codigo_postal": 58085
        },
        {
            "municipio": "Morelia",
            "codigo_postal": 58341
        },
        {
            "municipio": "Morelia",
            "codigo_postal": 58250
        },
        {
            "municipio": "Morelia",
            "codigo_postal": 58020
        },
        {
            "municipio": "Morelia",
            "codigo_postal": 58150
        },
        {
            "municipio": "Morelia",
            "codigo_postal": 58189
        },
```

### 4. Colonias.
_Obtención de colonias según sea  su código postal._
- Endpoint: `/api/v1/colonias/codigo_postal/{cp}`
- Descripción: Mediante una petición GET, se filtra el código postal dado, del cual se listaran todas las colonias que tengan relación con ese código postal.
- Ejemplo: `/api/v1/colonias/codigo_postal/58230`
- Respuesta:
```json
{
    "error": false,
    "mensaje": "Colonias cargadas 2",
    "colonias": [
        {
            "estado_id": 16,
            "municipio_id": 796,
            "estado": "Michoacan_de_Ocampo",
            "municipio": "Morelia",
            "colonia": "Cinco de Mayo",
            "codigo_postal": 58230
        },
        {
            "estado_id": 16,
            "municipio_id": 796,
            "estado": "Michoacan_de_Ocampo",
            "municipio": "Morelia",
            "colonia": "Vasco de Quiroga",
            "codigo_postal": 58230
        }
    ]
}
```

_Obtención de colonias según sea el estado y el municipio._	
- Endpoint: `/api/v1/colonias/estado/{id}/municipio/{id}`
- Descripción: Mediante una petición GET, se filtrara el ID del estado y del municipio, después de esta relación se listaran todas las colonias que pertenezcan a esta
- Ejemplo: `/api/v1/colonias/estado/16/municipio/796`
- Respuesta: (Respuesta reducuida por el exceso de datos)
```json
 "error": false,
    "mensaje": "Se cargaron 1034 colonias",
    "colonias": [
        {
            "estado_id": 16,
            "municipio_id": 796,
            "colonia": "INFONAVIT El Pipila",
            "codigo_postal": 58000,
            "fecha_Act": "2024-01-18"
        },
        {
            "estado_id": 16,
            "municipio_id": 796,
            "colonia": "Centro Historico",
            "codigo_postal": 58000,
            "fecha_Act": "2024-01-18"
        },
        {
            "estado_id": 16,
            "municipio_id": 796,
            "colonia": "INFONAVIT Plan de Ayala",
            "codigo_postal": 58000,
            "fecha_Act": "2024-01-18"
        },
        {
            "estado_id": 16,
            "municipio_id": 796,
            "colonia": "Universidad Michoacana de San Nicolas de Hidalgo",
            "codigo_postal": 58004,
            "fecha_Act": "2024-01-18"
        },
```

