#Changelog

###1.2.0
- Se actualizó la versión de serenity-cucumber 2.4.24 a 3.2.0
- Se actualizó Selenium de la versión 3.141.59 a 4.1.2
- Se modificó el método implicitlyWait(int, TimeUnit) a implicitlyWait(Duration) debido a deprecación en selenium 4

###1.1.0
- Eliminado el método importTestResultExecution(..., String user, String password)
- Agregado el método importTestResultExecutionBasic(..., String basicAuth)