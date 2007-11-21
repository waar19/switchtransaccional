package switchTransaccional.models;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * InformeLogView: A SOFIA generated model
 */
public class InformeLogView extends DataStore {

     /**
	 * 
	 */
	private static final long serialVersionUID = 3443143705917075271L;
	//constants for columns
     public static final String INFORME_LOG_TICKET_ID="informe_log.ticket_id";
     public static final String INFORME_LOG_SERVICIO="informe_log.servicio";
     public static final String INFORME_LOG_DESCRIPCION_SERVICIO="informe_log.descripcion_servicio";
     public static final String INFORME_LOG_CONFIGURACION="informe_log.configuracion";
     public static final String INFORME_LOG_DESCRIPCION_CONFIGURACION="informe_log.descripcion_configuracion";
     public static final String INFORME_LOG_DESTINATARIO="informe_log.destinatario";
     public static final String INFORME_LOG_SOLICITADO="informe_log.solicitado";
     public static final String INFORME_LOG_TIPO="informe_log.tipo";
     public static final String INFORME_LOG_TIEMPO_ST="informe_log.tiempo_st";
     public static final String INFORME_LOG_TIEMPO_PROVEEDOR="informe_log.tiempo_proveedor";
     public static final String INFORME_LOG_TIEMPO_TOTAL="informe_log.tiempo_total";
     public static final String INFORME_LOG_SERVICIO_DISTRIBUIDO_ID="informe_log.servicio_distribuido_id";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new InformeLogView object.
      * @param appName The SOFIA application name
      */
     public InformeLogView (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new InformeLogView object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public InformeLogView (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("informe_log"),null);

          //add columns
          addColumn(computeTableName("informe_log"),"ticket_id",DataStore.DATATYPE_INT,false,false,INFORME_LOG_TICKET_ID);
          addColumn(computeTableName("informe_log"),"servicio",DataStore.DATATYPE_STRING,false,false,INFORME_LOG_SERVICIO);
          addColumn(computeTableName("informe_log"),"descripcion_servicio",DataStore.DATATYPE_STRING,false,false,INFORME_LOG_DESCRIPCION_SERVICIO);
          addColumn(computeTableName("informe_log"),"configuracion",DataStore.DATATYPE_STRING,false,false,INFORME_LOG_CONFIGURACION);
          addColumn(computeTableName("informe_log"),"descripcion_configuracion",DataStore.DATATYPE_STRING,false,false,INFORME_LOG_DESCRIPCION_CONFIGURACION);
          addColumn(computeTableName("informe_log"),"destinatario",DataStore.DATATYPE_STRING,false,false,INFORME_LOG_DESTINATARIO);
          addColumn(computeTableName("informe_log"),"solicitado",DataStore.DATATYPE_DATETIME,false,false,INFORME_LOG_SOLICITADO);
          addColumn(computeTableName("informe_log"),"tipo",DataStore.DATATYPE_STRING,false,false,INFORME_LOG_TIPO);
          addColumn(computeTableName("informe_log"),"tiempo_st",DataStore.DATATYPE_DOUBLE,false,false,INFORME_LOG_TIEMPO_ST);
          addColumn(computeTableName("informe_log"),"tiempo_proveedor",DataStore.DATATYPE_DOUBLE,false,false,INFORME_LOG_TIEMPO_PROVEEDOR);
          addColumn(computeTableName("informe_log"),"tiempo_total",DataStore.DATATYPE_DOUBLE,false,false,INFORME_LOG_TIEMPO_TOTAL);
          addColumn(computeTableName("informe_log"),"servicio_distribuido_id",DataStore.DATATYPE_INT,false,false,INFORME_LOG_SERVICIO_DISTRIBUIDO_ID);

          //set order by
          setOrderBy(computeTableAndFieldName("informe_log.solicitado") + " DESC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the informe_log.ticket_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getInformeLogTicketId() throws DataStoreException {
          return  getInt(INFORME_LOG_TICKET_ID);
     }

     /**
      * Retrieve the value of the informe_log.ticket_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getInformeLogTicketId(int row) throws DataStoreException {
          return  getInt(row,INFORME_LOG_TICKET_ID);
     }

     /**
      * Set the value of the informe_log.ticket_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTicketId(int newValue) throws DataStoreException {
          setInt(INFORME_LOG_TICKET_ID, newValue);
     }

     /**
      * Set the value of the informe_log.ticket_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTicketId(int row,int newValue) throws DataStoreException {
          setInt(row,INFORME_LOG_TICKET_ID, newValue);
     }

     /**
      * Retrieve the value of the informe_log.servicio column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogServicio() throws DataStoreException {
          return  getString(INFORME_LOG_SERVICIO);
     }

     /**
      * Retrieve the value of the informe_log.servicio column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogServicio(int row) throws DataStoreException {
          return  getString(row,INFORME_LOG_SERVICIO);
     }

     /**
      * Set the value of the informe_log.servicio column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogServicio(String newValue) throws DataStoreException {
          setString(INFORME_LOG_SERVICIO, newValue);
     }

     /**
      * Set the value of the informe_log.servicio column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogServicio(int row,String newValue) throws DataStoreException {
          setString(row,INFORME_LOG_SERVICIO, newValue);
     }

     /**
      * Retrieve the value of the informe_log.descripcion_servicio column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogDescripcionServicio() throws DataStoreException {
          return  getString(INFORME_LOG_DESCRIPCION_SERVICIO);
     }

     /**
      * Retrieve the value of the informe_log.descripcion_servicio column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogDescripcionServicio(int row) throws DataStoreException {
          return  getString(row,INFORME_LOG_DESCRIPCION_SERVICIO);
     }

     /**
      * Set the value of the informe_log.descripcion_servicio column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogDescripcionServicio(String newValue) throws DataStoreException {
          setString(INFORME_LOG_DESCRIPCION_SERVICIO, newValue);
     }

     /**
      * Set the value of the informe_log.descripcion_servicio column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogDescripcionServicio(int row,String newValue) throws DataStoreException {
          setString(row,INFORME_LOG_DESCRIPCION_SERVICIO, newValue);
     }

     /**
      * Retrieve the value of the informe_log.configuracion column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogConfiguracion() throws DataStoreException {
          return  getString(INFORME_LOG_CONFIGURACION);
     }

     /**
      * Retrieve the value of the informe_log.configuracion column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogConfiguracion(int row) throws DataStoreException {
          return  getString(row,INFORME_LOG_CONFIGURACION);
     }

     /**
      * Set the value of the informe_log.configuracion column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogConfiguracion(String newValue) throws DataStoreException {
          setString(INFORME_LOG_CONFIGURACION, newValue);
     }

     /**
      * Set the value of the informe_log.configuracion column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogConfiguracion(int row,String newValue) throws DataStoreException {
          setString(row,INFORME_LOG_CONFIGURACION, newValue);
     }

     /**
      * Retrieve the value of the informe_log.descripcion_configuracion column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogDescripcionConfiguracion() throws DataStoreException {
          return  getString(INFORME_LOG_DESCRIPCION_CONFIGURACION);
     }

     /**
      * Retrieve the value of the informe_log.descripcion_configuracion column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogDescripcionConfiguracion(int row) throws DataStoreException {
          return  getString(row,INFORME_LOG_DESCRIPCION_CONFIGURACION);
     }

     /**
      * Set the value of the informe_log.descripcion_configuracion column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogDescripcionConfiguracion(String newValue) throws DataStoreException {
          setString(INFORME_LOG_DESCRIPCION_CONFIGURACION, newValue);
     }

     /**
      * Set the value of the informe_log.descripcion_configuracion column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogDescripcionConfiguracion(int row,String newValue) throws DataStoreException {
          setString(row,INFORME_LOG_DESCRIPCION_CONFIGURACION, newValue);
     }

     /**
      * Retrieve the value of the informe_log.destinatario column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogDestinatario() throws DataStoreException {
          return  getString(INFORME_LOG_DESTINATARIO);
     }

     /**
      * Retrieve the value of the informe_log.destinatario column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogDestinatario(int row) throws DataStoreException {
          return  getString(row,INFORME_LOG_DESTINATARIO);
     }

     /**
      * Set the value of the informe_log.destinatario column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogDestinatario(String newValue) throws DataStoreException {
          setString(INFORME_LOG_DESTINATARIO, newValue);
     }

     /**
      * Set the value of the informe_log.destinatario column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogDestinatario(int row,String newValue) throws DataStoreException {
          setString(row,INFORME_LOG_DESTINATARIO, newValue);
     }

     /**
      * Retrieve the value of the informe_log.solicitado column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getInformeLogSolicitado() throws DataStoreException {
          return  getDateTime(INFORME_LOG_SOLICITADO);
     }

     /**
      * Retrieve the value of the informe_log.solicitado column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getInformeLogSolicitado(int row) throws DataStoreException {
          return  getDateTime(row,INFORME_LOG_SOLICITADO);
     }

     /**
      * Set the value of the informe_log.solicitado column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogSolicitado(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(INFORME_LOG_SOLICITADO, newValue);
     }

     /**
      * Set the value of the informe_log.solicitado column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogSolicitado(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,INFORME_LOG_SOLICITADO, newValue);
     }

     /**
      * Retrieve the value of the informe_log.tipo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogTipo() throws DataStoreException {
          return  getString(INFORME_LOG_TIPO);
     }

     /**
      * Retrieve the value of the informe_log.tipo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getInformeLogTipo(int row) throws DataStoreException {
          return  getString(row,INFORME_LOG_TIPO);
     }

     /**
      * Set the value of the informe_log.tipo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTipo(String newValue) throws DataStoreException {
          setString(INFORME_LOG_TIPO, newValue);
     }

     /**
      * Set the value of the informe_log.tipo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTipo(int row,String newValue) throws DataStoreException {
          setString(row,INFORME_LOG_TIPO, newValue);
     }

     /**
      * Retrieve the value of the informe_log.tiempo_st column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getInformeLogTiempoSt() throws DataStoreException {
          return  getDouble(INFORME_LOG_TIEMPO_ST);
     }

     /**
      * Retrieve the value of the informe_log.tiempo_st column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getInformeLogTiempoSt(int row) throws DataStoreException {
          return  getDouble(row,INFORME_LOG_TIEMPO_ST);
     }

     /**
      * Set the value of the informe_log.tiempo_st column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTiempoSt(double newValue) throws DataStoreException {
          setDouble(INFORME_LOG_TIEMPO_ST, newValue);
     }

     /**
      * Set the value of the informe_log.tiempo_st column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTiempoSt(int row,double newValue) throws DataStoreException {
          setDouble(row,INFORME_LOG_TIEMPO_ST, newValue);
     }

     /**
      * Retrieve the value of the informe_log.tiempo_proveedor column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getInformeLogTiempoProveedor() throws DataStoreException {
          return  getDouble(INFORME_LOG_TIEMPO_PROVEEDOR);
     }

     /**
      * Retrieve the value of the informe_log.tiempo_proveedor column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getInformeLogTiempoProveedor(int row) throws DataStoreException {
          return  getDouble(row,INFORME_LOG_TIEMPO_PROVEEDOR);
     }

     /**
      * Set the value of the informe_log.tiempo_proveedor column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTiempoProveedor(double newValue) throws DataStoreException {
          setDouble(INFORME_LOG_TIEMPO_PROVEEDOR, newValue);
     }

     /**
      * Set the value of the informe_log.tiempo_proveedor column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTiempoProveedor(int row,double newValue) throws DataStoreException {
          setDouble(row,INFORME_LOG_TIEMPO_PROVEEDOR, newValue);
     }

     /**
      * Retrieve the value of the informe_log.tiempo_total column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getInformeLogTiempoTotal() throws DataStoreException {
          return  getDouble(INFORME_LOG_TIEMPO_TOTAL);
     }

     /**
      * Retrieve the value of the informe_log.tiempo_total column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getInformeLogTiempoTotal(int row) throws DataStoreException {
          return  getDouble(row,INFORME_LOG_TIEMPO_TOTAL);
     }

     /**
      * Set the value of the informe_log.tiempo_total column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTiempoTotal(double newValue) throws DataStoreException {
          setDouble(INFORME_LOG_TIEMPO_TOTAL, newValue);
     }

     /**
      * Set the value of the informe_log.tiempo_total column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogTiempoTotal(int row,double newValue) throws DataStoreException {
          setDouble(row,INFORME_LOG_TIEMPO_TOTAL, newValue);
     }

     /**
      * Retrieve the value of the informe_log.servicio_distribuido_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getInformeLogServicioDistribuidoId() throws DataStoreException {
          return  getInt(INFORME_LOG_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Retrieve the value of the informe_log.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getInformeLogServicioDistribuidoId(int row) throws DataStoreException {
          return  getInt(row,INFORME_LOG_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Set the value of the informe_log.servicio_distribuido_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogServicioDistribuidoId(int newValue) throws DataStoreException {
          setInt(INFORME_LOG_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Set the value of the informe_log.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setInformeLogServicioDistribuidoId(int row,int newValue) throws DataStoreException {
          setInt(row,INFORME_LOG_SERVICIO_DISTRIBUIDO_ID, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
