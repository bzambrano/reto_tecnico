#language: es
@UserOperations
Característica:Operaciones con usuario
  Como analista de calidad  del sistema
  Quiero poder Crear, Actualizar y Eliminar usuarios mediante la API reqres.in
  Para validar el correcto funcionamiento de las operaciones realizadas sobre el usuario.

  Escenario: Crear, actualizar y eliminar un usuario mediante la API reqres.in
    Dado que el analista de calidad cuenta con datos validos para la creacion de un usuario
    Cuando envia una solicitud para crear un nuevo usuario
    Entonces la respuesta debe tener el codigo de estado 201
    Y el cuerpo de la respuesta debe incluir el id del usuario creado

    Cuando envia una solicitud para actualizar el usuario creado
    Entonces la respuesta debe tener el codigo de estado 200
    Y el cuerpo de la respuesta debe reflejar los datos actualizados

    Cuando envia una solicitud eliminar el usuario creado
    Entonces la respuesta debe tener el codigo de estado 204