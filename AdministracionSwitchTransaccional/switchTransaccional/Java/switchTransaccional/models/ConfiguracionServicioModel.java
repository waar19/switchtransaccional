package switchTransaccional.models;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * ConfiguracionServicioModel: A SOFIA generated model
 */
public class ConfiguracionServicioModel extends DataStore {

     /**
	 * 
	 */
	private static final long serialVersionUID = 1499977396698382578L;
	//constants for columns
     public static final String CONFIGURACION_SERVICIO_CONFIGURACION_SERVICIO_ID="configuracion_servicio.configuracion_servicio_id";
     public static final String CONFIGURACION_SERVICIO_SERVICIO_DISTRIBUIDO_ID="configuracion_servicio.servicio_distribuido_id";
     public static final String CONFIGURACION_SERVICIO_CONFIGURACION_ID="configuracion_servicio.configuracion_id";
     public static final String SERVICIO_DISTRIBUIDO_NOMBRE="servicio_distribuido.nombre";
     public static final String CONFIGURACION_NOMBRE="configuracion.nombre";
     public static final String CONFIGURACION_DESCRIPCION="configuracion.descripcion";
     public static final String CONFIGURACION_SERVICIO_NAMESPACE_URI="configuracion_servicio.namespace_URI";
     public static final String CONFIGURACION_SERVICIO_NOMBRE_SERVICIO="configuracion_servicio.nombre_servicio";
     public static final String CONFIGURACION_SERVICIO_NOMBRE_PUERTO="configuracion_servicio.nombre_puerto";
     public static final String CONFIGURACION_SERVICIO_ENDPOINT_ADDRESS="configuracion_servicio.endpoint_address";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new ConfiguracionServicioModel object.
      * @param appName The SOFIA application name
      */
     public ConfiguracionServicioModel (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new ConfiguracionServicioModel object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public ConfiguracionServicioModel (String appName, String profile) { 
          super(appName, profile);

          try {

               //add aliases
               addTableAlias(computeTableName("configuracion_servicio"),"configuracion_servicio");
               addTableAlias(computeTableName("servicio_distribuido"),"servicio_distribuido");
               addTableAlias(computeTableName("infraestructura.configuracion"),"configuracion");

               //add columns
               addColumn(computeTableName("configuracion_servicio"),"configuracion_servicio_id",DataStore.DATATYPE_INT,true,true,CONFIGURACION_SERVICIO_CONFIGURACION_SERVICIO_ID);
               addColumn(computeTableName("configuracion_servicio"),"servicio_distribuido_id",DataStore.DATATYPE_INT,false,true,CONFIGURACION_SERVICIO_SERVICIO_DISTRIBUIDO_ID);
               addColumn(computeTableName("configuracion_servicio"),"configuracion_id",DataStore.DATATYPE_INT,false,true,CONFIGURACION_SERVICIO_CONFIGURACION_ID);
               addColumn(computeTableName("servicio_distribuido"),"nombre",DataStore.DATATYPE_STRING,false,false,SERVICIO_DISTRIBUIDO_NOMBRE);
               addColumn(computeTableName("configuracion"),"nombre",DataStore.DATATYPE_STRING,false,false,CONFIGURACION_NOMBRE);
               addColumn(computeTableName("configuracion"),"descripcion",DataStore.DATATYPE_STRING,false,false,CONFIGURACION_DESCRIPCION);
               addColumn(computeTableName("configuracion_servicio"),"namespace_URI",DataStore.DATATYPE_STRING,false,true,CONFIGURACION_SERVICIO_NAMESPACE_URI);
               addColumn(computeTableName("configuracion_servicio"),"nombre_servicio",DataStore.DATATYPE_STRING,false,true,CONFIGURACION_SERVICIO_NOMBRE_SERVICIO);
               addColumn(computeTableName("configuracion_servicio"),"nombre_puerto",DataStore.DATATYPE_STRING,false,true,CONFIGURACION_SERVICIO_NOMBRE_PUERTO);
               addColumn(computeTableName("configuracion_servicio"),"endpoint_address",DataStore.DATATYPE_STRING,false,true,CONFIGURACION_SERVICIO_ENDPOINT_ADDRESS);

               //add joins
               addJoin(computeTableAndFieldName("configuracion_servicio.servicio_distribuido_id"),computeTableAndFieldName("servicio_distribuido.servicio_distribuido_id"),false);
               addJoin(computeTableAndFieldName("configuracion_servicio.configuracion_id"),computeTableAndFieldName("configuracion.configuracion_id"),false);

               //add validations
               addRequiredRule(CONFIGURACION_SERVICIO_SERVICIO_DISTRIBUIDO_ID,"El servicio es obligatorio");
               addRequiredRule(CONFIGURACION_SERVICIO_CONFIGURACION_ID,"La configuración es obligatoria");
          }
          catch (DataStoreException e) {
               com.salmonllc.util.MessageLog.writeErrorMessage(e,this);
          }

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the configuracion_servicio.configuracion_servicio_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getConfiguracionServicioConfiguracionServicioId() throws DataStoreException {
          return  getInt(CONFIGURACION_SERVICIO_CONFIGURACION_SERVICIO_ID);
     }

     /**
      * Retrieve the value of the configuracion_servicio.configuracion_servicio_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getConfiguracionServicioConfiguracionServicioId(int row) throws DataStoreException {
          return  getInt(row,CONFIGURACION_SERVICIO_CONFIGURACION_SERVICIO_ID);
     }

     /**
      * Set the value of the configuracion_servicio.configuracion_servicio_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioConfiguracionServicioId(int newValue) throws DataStoreException {
          setInt(CONFIGURACION_SERVICIO_CONFIGURACION_SERVICIO_ID, newValue);
     }

     /**
      * Set the value of the configuracion_servicio.configuracion_servicio_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioConfiguracionServicioId(int row,int newValue) throws DataStoreException {
          setInt(row,CONFIGURACION_SERVICIO_CONFIGURACION_SERVICIO_ID, newValue);
     }

     /**
      * Retrieve the value of the configuracion_servicio.servicio_distribuido_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getConfiguracionServicioServicioDistribuidoId() throws DataStoreException {
          return  getInt(CONFIGURACION_SERVICIO_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Retrieve the value of the configuracion_servicio.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getConfiguracionServicioServicioDistribuidoId(int row) throws DataStoreException {
          return  getInt(row,CONFIGURACION_SERVICIO_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Set the value of the configuracion_servicio.servicio_distribuido_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioServicioDistribuidoId(int newValue) throws DataStoreException {
          setInt(CONFIGURACION_SERVICIO_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Set the value of the configuracion_servicio.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioServicioDistribuidoId(int row,int newValue) throws DataStoreException {
          setInt(row,CONFIGURACION_SERVICIO_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Retrieve the value of the configuracion_servicio.configuracion_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getConfiguracionServicioConfiguracionId() throws DataStoreException {
          return  getInt(CONFIGURACION_SERVICIO_CONFIGURACION_ID);
     }

     /**
      * Retrieve the value of the configuracion_servicio.configuracion_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getConfiguracionServicioConfiguracionId(int row) throws DataStoreException {
          return  getInt(row,CONFIGURACION_SERVICIO_CONFIGURACION_ID);
     }

     /**
      * Set the value of the configuracion_servicio.configuracion_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioConfiguracionId(int newValue) throws DataStoreException {
          setInt(CONFIGURACION_SERVICIO_CONFIGURACION_ID, newValue);
     }

     /**
      * Set the value of the configuracion_servicio.configuracion_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioConfiguracionId(int row,int newValue) throws DataStoreException {
          setInt(row,CONFIGURACION_SERVICIO_CONFIGURACION_ID, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.nombre column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoNombre() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_NOMBRE);
     }

     /**
      * Retrieve the value of the servicio_distribuido.nombre column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoNombre(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_NOMBRE);
     }

     /**
      * Set the value of the servicio_distribuido.nombre column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoNombre(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_NOMBRE, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.nombre column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoNombre(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_NOMBRE, newValue);
     }

     /**
      * Retrieve the value of the configuracion.nombre column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionNombre() throws DataStoreException {
          return  getString(CONFIGURACION_NOMBRE);
     }

     /**
      * Retrieve the value of the configuracion.nombre column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionNombre(int row) throws DataStoreException {
          return  getString(row,CONFIGURACION_NOMBRE);
     }

     /**
      * Set the value of the configuracion.nombre column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionNombre(String newValue) throws DataStoreException {
          setString(CONFIGURACION_NOMBRE, newValue);
     }

     /**
      * Set the value of the configuracion.nombre column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionNombre(int row,String newValue) throws DataStoreException {
          setString(row,CONFIGURACION_NOMBRE, newValue);
     }

     /**
      * Retrieve the value of the configuracion.descripcion column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionDescripcion() throws DataStoreException {
          return  getString(CONFIGURACION_DESCRIPCION);
     }

     /**
      * Retrieve the value of the configuracion.descripcion column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionDescripcion(int row) throws DataStoreException {
          return  getString(row,CONFIGURACION_DESCRIPCION);
     }

     /**
      * Set the value of the configuracion.descripcion column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionDescripcion(String newValue) throws DataStoreException {
          setString(CONFIGURACION_DESCRIPCION, newValue);
     }

     /**
      * Set the value of the configuracion.descripcion column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionDescripcion(int row,String newValue) throws DataStoreException {
          setString(row,CONFIGURACION_DESCRIPCION, newValue);
     }

     /**
      * Retrieve the value of the configuracion_servicio.namespace_URI column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioNamespaceUri() throws DataStoreException {
          return  getString(CONFIGURACION_SERVICIO_NAMESPACE_URI);
     }

     /**
      * Retrieve the value of the configuracion_servicio.namespace_URI column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioNamespaceUri(int row) throws DataStoreException {
          return  getString(row,CONFIGURACION_SERVICIO_NAMESPACE_URI);
     }

     /**
      * Set the value of the configuracion_servicio.namespace_URI column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioNamespaceUri(String newValue) throws DataStoreException {
          setString(CONFIGURACION_SERVICIO_NAMESPACE_URI, newValue);
     }

     /**
      * Set the value of the configuracion_servicio.namespace_URI column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioNamespaceUri(int row,String newValue) throws DataStoreException {
          setString(row,CONFIGURACION_SERVICIO_NAMESPACE_URI, newValue);
     }

     /**
      * Retrieve the value of the configuracion_servicio.nombre_servicio column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioNombreServicio() throws DataStoreException {
          return  getString(CONFIGURACION_SERVICIO_NOMBRE_SERVICIO);
     }

     /**
      * Retrieve the value of the configuracion_servicio.nombre_servicio column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioNombreServicio(int row) throws DataStoreException {
          return  getString(row,CONFIGURACION_SERVICIO_NOMBRE_SERVICIO);
     }

     /**
      * Set the value of the configuracion_servicio.nombre_servicio column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioNombreServicio(String newValue) throws DataStoreException {
          setString(CONFIGURACION_SERVICIO_NOMBRE_SERVICIO, newValue);
     }

     /**
      * Set the value of the configuracion_servicio.nombre_servicio column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioNombreServicio(int row,String newValue) throws DataStoreException {
          setString(row,CONFIGURACION_SERVICIO_NOMBRE_SERVICIO, newValue);
     }

     /**
      * Retrieve the value of the configuracion_servicio.nombre_puerto column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioNombrePuerto() throws DataStoreException {
          return  getString(CONFIGURACION_SERVICIO_NOMBRE_PUERTO);
     }

     /**
      * Retrieve the value of the configuracion_servicio.nombre_puerto column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioNombrePuerto(int row) throws DataStoreException {
          return  getString(row,CONFIGURACION_SERVICIO_NOMBRE_PUERTO);
     }

     /**
      * Set the value of the configuracion_servicio.nombre_puerto column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioNombrePuerto(String newValue) throws DataStoreException {
          setString(CONFIGURACION_SERVICIO_NOMBRE_PUERTO, newValue);
     }

     /**
      * Set the value of the configuracion_servicio.nombre_puerto column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioNombrePuerto(int row,String newValue) throws DataStoreException {
          setString(row,CONFIGURACION_SERVICIO_NOMBRE_PUERTO, newValue);
     }

     /**
      * Retrieve the value of the configuracion_servicio.endpoint_address column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioEndpointAddress() throws DataStoreException {
          return  getString(CONFIGURACION_SERVICIO_ENDPOINT_ADDRESS);
     }

     /**
      * Retrieve the value of the configuracion_servicio.endpoint_address column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getConfiguracionServicioEndpointAddress(int row) throws DataStoreException {
          return  getString(row,CONFIGURACION_SERVICIO_ENDPOINT_ADDRESS);
     }

     /**
      * Set the value of the configuracion_servicio.endpoint_address column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioEndpointAddress(String newValue) throws DataStoreException {
          setString(CONFIGURACION_SERVICIO_ENDPOINT_ADDRESS, newValue);
     }

     /**
      * Set the value of the configuracion_servicio.endpoint_address column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setConfiguracionServicioEndpointAddress(int row,String newValue) throws DataStoreException {
          setString(row,CONFIGURACION_SERVICIO_ENDPOINT_ADDRESS, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
