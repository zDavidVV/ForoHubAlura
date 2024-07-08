
# Alura Foro Hub API

Esta es una API para la gestión de tópicos en un foro, desarrollada con Spring Boot. La API permite registrar, listar, actualizar, eliminar y obtener detalles de tópicos.

## Funcionamiento de la API

La API de Alura Foro Hub cuenta con los siguientes endpoints para la gestión de tópicos:

### Registrar un nuevo tópico

- **URL:** `/Topicos`
- **Método:** `POST`
- **Descripción:** Registra un nuevo tópico.
- **Cuerpo de la solicitud:**
  ```json
  {
        "autor": number,
        "curso": number,
        "estatus": string,
        "fecha": date,
        "mensaje": string,
        "titulo": string  
  }
  ```

### Listar tópicos

- **URL:** `/Topicos`
- **Método:** `GET`
- **Descripción:** Obtiene el listado de tópicos.
- **Parámetros de consulta:**
  - `size` (opcional): Número de tópicos por página (por defecto, 10).
  - `sort` (opcional): Campo por el que se ordenan los tópicos (por defecto, "titulo").

### Actualizar un tópico

- **URL:** `/Topicos`
- **Método:** `PUT`
- **Descripción:** Actualiza la información de un tópico.
- **Cuerpo de la solicitud:**
  ```json
  {
      "id": "Long",
      "titulo": "String",
      "mensaje": "String"
  }
  ```

### Eliminar un tópico

- **URL:** `/Topicos/{id}`
- **Método:** `DELETE`
- **Descripción:** Elimina un tópico a partir del ID.

### Obtener detalles de un tópico

- **URL:** `/Topicos/{id}`
- **Método:** `GET`
- **Descripción:** Obtiene los detalles para el tópico con el ID indicado.

## Seguridad

La API utiliza JWT (JSON Web Tokens) para autenticación y autorización. Para acceder a los endpoints protegidos, debes incluir un token JWT válido en el encabezado de la solicitud.

### Generación de JWT

1. Regístrate o inicia sesión para obtener un token JWT.
2. Incluye el token en el encabezado de tus solicitudes HTTP:

   ```http
   Authorization: Bearer <tu-token-jwt>
   ```

## Documentación de la API

La API está documentada usando Swagger. Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación en:

```
http://localhost:8080/swagger-ui.html
```
