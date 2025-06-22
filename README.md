# Ecommerce OOP

## Descripción del proyecto  
**ecommerce-OOP** es el backend de una plataforma de comercio electrónico para la tienda ARCADIA, desarrollada utilizando los principios de la Programación Orientada a Objetos (OOP) e integrando componentes basados en Inteligencia Artificial (IA). 

## Contenido
- [Tecnologías utilizadas](#tecnologías-utilizadas)
- [Implementación](#implementación)
- [Arquitectura](#arquitectura)
  - [Diagrama de clases](#diagrama-de-clases)
  - [Estructura de proyecto](#estructura-de-proyecto)
- [Capturas de pantalla](#capturas-de-pantalla)
- [Instrucciones para Ejecutar](#instrucciones-para-ejecutar)
- [Desafíos Enfrentados](#desafíos-enfrentados)
- [Contacto](#contacto)

## Tecnologías utilizadas  
- **Lenguaje**: Java  
- **IDE**: Eclipse IDE con JDK 23
- **Control de versiones**: Git & GitHub  
- **Build**: Sin framework externo actualmemte (Java SE)  

## Implementación
Las clases que se encuentran en el paquete `com.arcadia.ecommerce`:
- `Product`: atributos comunes (id, name, price…) y métodos para obtener datos generales, activar y desactivar.
- `User`: gestión de perfiles de usuario, login/logout y enum `Role`.
- `Cart`: operaciones de añadir, remover, actualizar cantidad y calcular total del carrito de compras..  
- `ProductCategory`: categorías de producto con estado activo/inactivo.  
- `Stock`: control de cantidad en inventario de productos y fecha de última actualización.  
- `Session`: modelo de sesión de usuario con timestamps de inicio y cierre.  
- `CartItem`: articulos en el carrito, subtotal y cantidad.   
- `TestMain`: ejemplos de uso de las clases para prueba.

## Arquitectura
### Diagrama de clases  
![Diagrama UML de clases](docs/Diagrama-de-clases.jpg)
Nota: Creado con Visual Paradigm Community Edition, por Diana Bello.

### Estructura de proyecto

## Capturas de pantalla 
**Interfaz en Eclipse** 
![Interfaz-en-eclipse](https://github.com/user-attachments/assets/9730e663-14f1-49de-9435-bfc930820af7)

**Ejecución de TestMain** 
![ejecucion-test-main-eclipse](https://github.com/user-attachments/assets/1c6723e6-3b88-405b-9af3-445bc2824eda)

## Instrucciones para Ejecutar
Para ejecutar este proyecto de forma local, siga los pasos a continuación:
1. Clonar repositorio:
   ```bash
   git clone https://github.com/tu-usuario/ecommerce-OOP.git
3. Importar en Eclipse: File → Import → Git → Projects from Git → Clone URI
4. Ejecutar Main.java como Java Application.

## Desafíos Enfrentados
- Asignación 2:
  - El método `removeItem()` de la clase `Cart` no eliminaba correctamente items: Se implementó con `Iterator` para evitar errores de modificación concurrente.

## Contacto
dianabellomejia_@hotmail.com
