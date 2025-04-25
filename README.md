UNIVERSIDAD AUTÓNOMA METROPOLITANA 
UNIDAD CUAJIMALPA




-REPORTE 
TÉCNICO-





 Daniel Monroy Marcelo
Matrícula: 2203065803
Profesor: Guillermo Monroy
25-I INTEGRACIÓN DE SISTEMAS - DH01T



1. Introducción
Objetivo:
Desarrollar un sistema backend para gestión de productos y facturación electrónica usando Spring Boot, con documentación automatizada y despliegue en GitHub. 
tema basado en el último dígito de mi matricula : 3. Gestión de productos Facturación electrónica
Tecnologías principales:

Java + Spring Boot para la implementación de los servicios. Swagger/OpenAPI para documentar la API. PostgreSQL / MySQL como base de datos. Postman o cURL para pruebas. GitHub para la entrega del código

2. Arquitectura del Sistema
Diagrama de Componentes
![Diagrama de Componentes](https://github.com/user-attachments/assets/42a7a855-8f23-4787-ac80-7ff02f660f6c)



Estructura de Paquetes
com.example/
├── config/          # Configuraciones (Swagger, seguridad)
├── controller/      # Endpoints REST
├── model/           # Entidades (Producto, Factura)
├── repository/      # Interfaces JPA
└── service/         # Lógica de negocio




3. Implementación Clave
Endpoints Principales


Método
Ruta
Funcion
POST
/api/productos
Crear producto
GET
/api/facturas
Listar facturas
POST
/api/facturas
Generar factura con items



4. Base de Datos
Modelo Entidad-Relación

![mer](https://github.com/user-attachments/assets/f275f9a5-475d-49ae-a125-3374f6ed4af1)




5. Pruebas
Unitarias
@Test
void crearProducto_RetornaProductoConId() {
    when(repository.save(any())).thenReturn(productoMock);
    Producto resultado = service.crearProducto(new Producto());
    assertEquals(1L, resultado.getId());
}

Postman:  Ejemplo : 
{
  "cliente": "Juan Pérez",
  "items": [{"productoId": 1, "cantidad": 2}]
}


Repositorio GitHub: 
URL:      https://github.com/danielMonroy2203065803/proyectfinal


7. Conclusiones
Logros
API REST funcional con Spring Boot.
Documentación automatizada con Swagger.
Integración exitosa con GitHub.
Dificultades y Soluciones
Problema : Error en conexión a PostgreSQL
Solución: Uso de variables de entorno (${DB_PASSWORD})
Problema : Conflicto con dependencias  
Solución : Limpieza de pom.xml y uso de springdoc-openapi

EXPERIENCIA POR APRENDER:
Además que en sí hice el proyecto yo solo lo hizo sin equipo  tuve dificultades y tuve unos que otros detalles los cuales tendre que solucionar más adelante además esto fue un reto grande para mi ya que no tenía el conocimiento alto sobre los servicios de restful es un tema que me gustaría pulirlo mucho más para nutrir mi conocimiento.
