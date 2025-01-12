#language: es

@CreateClients
Característica: Inicio de prueba E2E Crear clientes.

  Escenario:Crear cliente con exito atraves del fontend
    Dado que el analista de pruebas inicia sesion en la aplicacion
    E ingresa a la seccion de creacion de clientes
    Cuando diligencian los campos requeridos para crear un nuevo cliente
    Entonces se debe crear un nuevo cliente exitosamente