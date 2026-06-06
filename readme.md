# 🏋️ GymManager

Proyecto de prácticas desarrollado con **Spring Boot**. Es una API REST para gestionar un gimnasio: socios, entrenadores y clases.

---

## 🛠️ Tecnologías usadas

- Java 23
- Spring Boot 4.0.6
- Spring Data JPA + Hibernate
- Base de datos H2 (en memoria)
- Lombok
- Maven

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio
2. Abre una terminal en la carpeta del proyecto
3. Ejecuta:

```bash
./mvnw spring-boot:run
```

4. La app estará disponible en `http://localhost:8080`
---

## 📦 Endpoints disponibles

### Entrenadores `/api/v1/entrenadores`

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/api/v1/entrenadores` | Listar todos |
| GET | `/api/v1/entrenadores/{id}` | Buscar por ID |
| POST | `/api/v1/entrenadores` | Crear nuevo |
| PUT | `/api/v1/entrenadores/{id}` | Actualizar |
| DELETE | `/api/v1/entrenadores/{id}` | Eliminar |

### Clases `/api/v1/clases`

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/api/v1/clases` | Listar todas |
| GET | `/api/v1/clases/{id}` | Buscar por ID |
| POST | `/api/v1/clases` | Crear nueva |
| PUT | `/api/v1/clases/{id}` | Actualizar |
| DELETE | `/api/v1/clases/{id}` | Eliminar |
| GET | `/api/v1/clases/buscar?nombre=yoga` | Buscar por nombre |
| GET | `/api/v1/clases/entrenador/{id}` | Clases de un entrenador |

### Socios `/api/v1/socios`

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/api/v1/socios` | Listar todos |
| GET | `/api/v1/socios/{id}` | Buscar por ID |
| POST | `/api/v1/socios` | Crear nuevo |
| PUT | `/api/v1/socios/{id}` | Actualizar |
| DELETE | `/api/v1/socios/{id}` | Eliminar |
| GET | `/api/v1/socios/{id}/total-clases` | Total de clases de un socio |

---

## 🗄️ Base de datos

Usa H2, una base de datos en memoria (se resetea al reiniciar la app). Puedes consultarla visualmente en:

```
http://localhost:8080/h2-console
```

Datos de conexión:
- **JDBC URL:** `jdbc:h2:mem:gymdb`
- **Usuario:** `sa`
- **Contraseña:** *(vacía)*

---

## 📁 Estructura del proyecto

```
src/main/java/com/gymmanager/
├── controller/      # Endpoints REST
├── model/           # Entidades (Socio, Entrenador, Clase)
├── repository/      # Acceso a base de datos
└── service/         # Lógica de negocio
```

---

## 📝 Ejemplos de uso con Postman

**Crear un entrenador:**
```json
POST /api/v1/entrenadores
{
  "nombre": "Carlos López",
  "especialidad": "Yoga"
}
```

**Crear una clase:**
```json
POST /api/v1/clases
{
  "nombre": "Yoga Matutino",
  "duracion": 60,
  "entrenador": { "id": 1 }
}
```

**Crear un socio:**
```json
POST /api/v1/socios
{
  "nombre": "Ana García",
  "edad": 28,
  "email": "ana@email.com"
}
```

---

## 👤 Autor

Gustavo Aythami Mayor Sánchez
Claudia Santana González
