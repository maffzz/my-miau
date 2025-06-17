# my-miau 🐱

una aplicación web que te permite registrar tus gatitos y ver los gatos de otras personas 🏠

## descripción 📝

my-miau es una base de datos de gatos donde los usuarios pueden:

- registrarse en la plataforma ✨
- agregar información sobre sus gatos 🐈
- ver los gatos registrados por otros usuarios 👀
- actualizar información de sus gatos ✏️

## tecnologías utilizadas 🛠️

- **backend**: spring boot (java) ☕
- **base de datos**: postgresql 🗄️
- **autenticación**: jwt 🔐
- **seguridad**: spring security 🛡️

## estructura del proyecto 📁

```
src/main/java/com/example/mymiau/
├── config/          # configuración de seguridad y cors 🔧
├── controller/      # controladores rest 🎮
├── domain/         # entidades del dominio 🏗️
├── dto/            # objetos de transferencia de datos 📦
├── exception/      # manejo de excepciones ⚠️
├── mapper/         # mapeadores entre entidades y dtos 🔄
├── repository/     # repositorios de datos 💾
└── service/        # lógica de negocio ⚙️
```

## funcionalidades principales 🌟

### usuarios 👤
- registro de nuevos usuarios 📝
- autenticación con jwt 🔑
- actualización de información personal ✏️

### gatos 🐈
- registro de nuevos gatos 🆕
- visualización de todos los gatos 👀
- actualización de información de gatos ✏️
- asignación de dueños a gatos 👥

## endpoints principales 🔗

- `POST /api/auth/register` - registro de usuario 📝
- `POST /api/auth/login` - inicio de sesión 🔑
- `GET /api/gatitos` - obtener todos los gatos 🐱
- `POST /api/gatitos` - crear nuevo gato 🆕
- `PUT /api/gatitos/{id}/nombre` - actualizar nombre del gato ✏️
- `PUT /api/gatitos/{id}/duenio` - asignar dueño al gato 👥

## licencia 📄

este proyecto está bajo la licencia incluida en el archivo license 📋 