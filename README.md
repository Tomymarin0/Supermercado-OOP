# Supermercado-OOP
Projecto Supermercado Programacion orientado a objetos para la materia Introduccion a la orientacion a objetos en UADE

Consigna del proyecto:

Se desea implementar un sistema que permita administrar las ventas de un supermercado. Los requerimientos que el sistema debe cumplir son los siguientes:

Administración de proveedores:
El sistema debe permitir crear, modificar y eliminar proveedores. De cada proveedor se registrará la siguiente información: CUIT, razón social, domicilio, teléfono, mail.
El sistema debe validar que no se creen proveedores con el mismo CUIT.
En la modificación se podrá editar cualquier dato excepto el CUIT.
La eliminación de proveedores será siempre lógica con la excepción de que el proveedor no tenga productos asociados, en ese caso podrá eliminarse físicamente del sistema.

Administración de productos:
El sistema debe permitir crear, modificar y eliminar productos. De cada producto se registrará la siguiente información: código, descripción, marca, proveedor, precio, stock, stock mínimo, pedido reposición.
El sistema debe validar que no se creen productos con el mismo código.
En la modificación se podrá editar cualquier dato excepto el código.
La eliminación de productos será siempre lógica con la excepción de que el producto no este asociado a ninguna venta, en ese caso podrá eliminarse físicamente del sistema.


Productos sin stock:
El sistema debe generar un informe en donde se listen todos los productos cuyo stock es menor o igual al stock mínimo.

Abrir Caja:
El sistema debe permitir abrir una caja diariamente. Una caja registra las transacciones diarias efectuadas por la línea de caja. De cada Caja se registra: Fecha, numero de Caja, nombre cajero, saldo inicial efectivo.

Registrar Venta:
Cada transacción realizada en el supermercado debe registrarse en el sistema. Cuando el cliente se aproxima a la caja con su compra la cajera procede a iniciar la transacción, en ese momento el sistema inicia una nueva venta registrando Fecha, numero de caja, cajero y numero de venta.
A medida que se escanean los productos el sistema va agregando ítems de Venta a la transacción: el sistema recibe código de producto y cantidad, valida que el código sea correcto y lo asocia a la venta creada junto con la cantidad ingresada.
Una vez procesados todos los productos, el cajero solicita el total de la compra. El sistema calcula el total sumando el precio de los productos multiplicados por la cantidad comprada.
El cliente realiza el pago y el cajero registra el monto en efectivo recibido. El sistema calcula el vuelto y lo informa.
Cuando el cajero confirma la transacción el sistema: actualiza el stock de los productos vendidos y registra la venta en la Caja agregando una nueva transacción y actualizando el saldo en efectivo.

Cerrar Caja:
Al finalizar el día el cajero cierra la caja. El sistema emite un informe con el listado de las ventas realizadas e informa saldo inicial y saldo final del dinero en efectivo.

Consultar Ventas:
El sistema debe permitir realizar consultar las ventas realizadas, para ello permitirá filtrar por fechas, cajero o número de caja y mostrar un listado con las ventas que cumplan el filtro. Se debe mostrar fecha, Cajero, numero de caja, numero de venta y total

Informe Diario de Caja:
El sistema debe permitir realizar una consulta sobre los informes diarios de caja. El sistema permitirá filtrar por fecha, cajero y numero de caja.
El informe mostrara fecha, cajero, numero de caja, saldo inicial, Ventas, saldo final.

Detalles extra:
El programa esta Hecho con Swing, y por cuestiones de compatibilidad con swing se uso java 1.8

Autor:
Tomas Muguerza

