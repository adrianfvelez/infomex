# Correcciones a la primera itreación:

## Correcciones en todos los casos:

- Validar los campos, tanto en el sistema como en la interfaz (HTML5). Así la validación de campos vacíos. 
- En todas las vistas poner un botón que nos regrese a la pantalla principal
- Si se tiene que ingresar texto para buscar/filtrar/eliminar hay que ir mostrando las coincidencias de la subcadena ingresada con las que se tienen en la BD

## Registrar Comentarista:

[ ] Especificar formato de la fecha
[ ] Si se registra a un mismo usuario, especificar que dicho usuario ya existe
[ ] No tiene caso tener "Nombre" y "Usuario", dejar solo uno
[ ] Quitar fecha de nacimiento, no se necesita esa información
[ ] Cifrar la contraseña
[ ] Poner dos campos para la  contraseña, confirmación (los dos campos deben coincidir) 

## Iniciar sesión:

[ ] Si estamos pidiendo un nombre de usuario => iniciar sesión con  eso... O con el correo. A consideración.  
[ ] Después de iniciar sesión, redirigir a la página del usuario correspondiente
[ ] Mostrar (en algún lado de la vista) que la sesión está iniciada. Posiblemente mostrando el nombre del usuario

## Cerrar sesión:

[ ] Al cerrar sesión redirigir a la página principal
[ ] Especificar que la sesión se ha cerrado y que se pueda notar en la vista que así es 

## Agregar Informador:

- [ ] Corroborar que solo administradores puedan agregar informadores
- [ ] Generar la contraseña automáticamente 
- [ ] Verificar que no se agregue a un informador ya existente
- [ ] Enviar los datos, de registro, al informador pertinente

## Agregar Tema:

- [ ] Obligar a agregar un marcador al terminar de agregar el tema
- [ ] Enviar los mensajes adecuados para los errores y éxitos en el sistema

## Eliminar Tema:

- [ ] Mostrar la lista de los temas que se pueden eliminar.

## Buscar Tema:

- [ ] Filtrar los marcadores que existen dado el tema a buscar. Así como todas las características que dichos marcadores.

## Agregar Marcador:

- [ ] Al agregar un marcador con los campos vacíos manda error pero aun así agrega el marcador (temporalmente).
- [ ] Validar al usuario al eliminar marcador.

## Ver Marcador:

- [ ] Desplegar los comentarios del marcador.

## Eliminar Marcador:

- [ ] Permitir eliminar solo los marcadores del usuario en cuestión 

## Agregar Comentario:

- [ ] Al terminar de agregar el comentario redireccionar a la pagina principal.
- [ ] Asociar el marcador al tema y marcador correspondientes
- [ ] La calificación no tiene que ser un campo obligatorio. Especificar el rango de la calificación.

## Editar Comentario:

- [ ] Permitir editar solo los comentarios del usuario que ha iniciado sesión 
- [ ] Mostrar la lista de los comentarios del marcador que son editables por el usuario

## Eliminar Comentario:

- [ ] Permitir eliminar solo los comentarios del usuario que ha iniciado sesión 
- [ ] Mostrar la lista de los comentarios del marcador que son eliminables por el usuario
