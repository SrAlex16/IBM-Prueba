<h1>Proyecto de consulta de proveedores</h1>
<p align="left">
Este proyecto de Java tiene como objetivo consultar una base de datos de proveedores y guardar la información en archivos JSON y de texto plano.</br>
La clase Main es la clase principal que se ejecuta cuando se inicia la aplicación. En su método main(), se intenta obtener un argumento de línea de comandos, que debe ser un valor numérico. Si el argumento es "1", se llama al método estático getTodos() de la clase Proveedores, que consulta una base de datos de proveedores y guarda la información en archivos JSON y de texto plano.</br>
La clase Proveedores es una clase que representa a los proveedores y tiene varios atributos (id_proveedor, nombre, fecha_alta e id_cliente) y métodos. El método getTodos() es el que realiza la consulta a la base de datos de proveedores, crea una lista de objetos Proveedores a partir de los resultados de la consulta y guarda la información en archivos JSON y de texto plano. Además, el método lanza una excepción NoDataException si no se encuentran datos en la base de datos de proveedores.</br>
En la carpeta raíz del proyecto se ubica el archivo script.sql donde encontramos el script de base de datos utilizado.</br>
</p>
<em>Requisitos</em>
<p>
Para ejecutar este proyecto, necesitarás tener instalado lo siguiente:</br>
</br>
- Java Development Kit (JDK) versión 8 o superior</br>
- MySQL Server versión 5.7 o superior</br>
- Gson versión 2.8.5 o superior</br>
</p>
<em>Instalación</em>
<p>
Para instalar este proyecto, siga los siguientes pasos:</br>
</br>
1 Descargue o clone el repositorio en su máquina local.</br>
2 Abra el proyecto en su IDE preferido (recomiendo Eclipse para evitar problemas).</br>
3 Configure los detalles de conexión de su base de datos en la clase Proveedores</br>
4 Compile el proyecto.</br>
5 Ejecute la clase `Main` y proporcione el argumento "1" en la línea de comandos para iniciar la consulta a la base de datos.</br>
</p>
