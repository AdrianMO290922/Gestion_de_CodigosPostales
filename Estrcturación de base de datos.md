# Planificación de la db y del proyecto

**13-15** Dic. Planificación detallada de la estructura de la base de datos y del proyecto.

**13 Dic->** Investigación sobre la normalización de DB y diseño de la DB segun las reglas de normalización, revisión de buenas practicas de para mejorar los commits, revisión de formato MD.

**14 Dic->** Repaso de Git y Fithub para llevar una estructura organizada.

**15 Dic->** ~~pendiente~~

## Diseño de la estructura de la DB

|**ID_Estado**|**Estado**|
|-------------|----------|
|     1       |   Mich   |
|     2       |  Jalisco |

Conectada con...

|**ID_Municipio**|**Municipio**|**ID_Estado**|
|----------------|-------------|-------------|
|     1          |   Morelia   |1            |
|     2          |  Zitacuaro  |1            |

Conectada con...

|**ID_CP**|**CP**|**ID_Municipio**|
|---------|------|----------------|
|     1   |58230 |1               |
|     2   |58200 |2               |

Conectada con...

|**ID_Colonnia**|**Colonia**|**ID_CP**|
|---------------|-----------|---------|
|     1         | Obrera    |2        |
|     2         |Vasco de Q.|1        |







