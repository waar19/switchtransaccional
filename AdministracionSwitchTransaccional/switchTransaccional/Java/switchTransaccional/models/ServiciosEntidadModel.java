package switchTransaccional.models;

import java.sql.SQLException;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * ServiciosEntidadModel: A SOFIA generated model
 */
public class ServiciosEntidadModel extends DataStore {

     /**
	 * 
	 */
	private static final long serialVersionUID = -8079399454766693002L;
	//constants for columns
     public static final String SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID="servicios_entidad.servicio_distribuido_id";
     public static final String SERVICIOS_ENTIDAD_ENTIDAD_ID="servicios_entidad.entidad_id";
     public static final String SERVICIOS_ENTIDAD_ANULADO="servicios_entidad.anulado";
     public static final String SERVICIOS_ENTIDAD_VIGENCIA_DESDE="servicios_entidad.vigencia_desde";
     public static final String SERVICIOS_ENTIDAD_VIGENCIA_HASTA="servicios_entidad.vigencia_hasta";
     public static final String SERVICIO_DISTRIBUIDO_NOMBRE="servicio_distribuido.nombre";
     public static final String ENTIDAD_EXTERNA_CODIGO="entidad_externa.codigo";
     public static final String ENTIDAD_EXTERNA_NOMBRE="entidad_externa.nombre";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new ServiciosEntidadModel object.
      * @param appName The SOFIA application name
      */
     public ServiciosEntidadModel (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new ServiciosEntidadModel object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public ServiciosEntidadModel (String appName, String profile) { 
          super(appName, profile);

          try {

               //add aliases
               addTableAlias(computeTableName("servicio_distribuido"),null);
               addTableAlias(computeTableName("servicios_entidad"),null);
               addTableAlias(computeTableName("infraestructura.entidad_externa"),"entidad_externa");

               //add columns
               addColumn(computeTableName("servicios_entidad"),"servicio_distribuido_id",DataStore.DATATYPE_INT,true,true,SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID);
               addColumn(computeTableName("servicios_entidad"),"entidad_id",DataStore.DATATYPE_INT,true,true,SERVICIOS_ENTIDAD_ENTIDAD_ID);
               addColumn(computeTableName("servicios_entidad"),"anulado",DataStore.DATATYPE_STRING,true,true,SERVICIOS_ENTIDAD_ANULADO);
               addColumn(computeTableName("servicios_entidad"),"vigencia_desde",DataStore.DATATYPE_DATE,false,true,SERVICIOS_ENTIDAD_VIGENCIA_DESDE);
               addColumn(computeTableName("servicios_entidad"),"vigencia_hasta",DataStore.DATATYPE_DATE,false,true,SERVICIOS_ENTIDAD_VIGENCIA_HASTA);
               addColumn(computeTableName("servicio_distribuido"),"nombre",DataStore.DATATYPE_STRING,false,false,SERVICIO_DISTRIBUIDO_NOMBRE);
               addColumn("entidad_externa","codigo",DataStore.DATATYPE_STRING,false,false,ENTIDAD_EXTERNA_CODIGO);
               addColumn("entidad_externa","nombre",DataStore.DATATYPE_STRING,false,false,ENTIDAD_EXTERNA_NOMBRE);

               //add joins
               addJoin(computeTableAndFieldName("servicios_entidad.servicio_distribuido_id"),computeTableAndFieldName("servicio_distribuido.servicio_distribuido_id"),false);
               addJoin(computeTableAndFieldName("servicios_entidad.entidad_id"),"entidad_externa.entidad_id",false);

               //add validations
               addRequiredRule(SERVICIOS_ENTIDAD_ANULADO,"El indicador de baja lógica es obligatorio");
               addRequiredRule(SERVICIOS_ENTIDAD_ENTIDAD_ID,"La entidad es obligatoria");
               addRequiredRule(SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID,"El servicio es obligatorio");
               addRequiredRule(SERVICIOS_ENTIDAD_VIGENCIA_DESDE,"La fecha de vigencia es obligatoria");
               addLookupRule(SERVICIOS_ENTIDAD_ENTIDAD_ID, "infraestructura.entidad_externa", "'infraestructura.entidad_externa.entidad_id = ' + servicios_entidad.entidad_id" , "nombre", ENTIDAD_EXTERNA_NOMBRE, "Entidad inexistente");
          }
          catch (DataStoreException e) {
               com.salmonllc.util.MessageLog.writeErrorMessage(e,this);
          }

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the servicios_entidad.servicio_distribuido_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getServiciosEntidadServicioDistribuidoId() throws DataStoreException {
          return  getInt(SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Retrieve the value of the servicios_entidad.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getServiciosEntidadServicioDistribuidoId(int row) throws DataStoreException {
          return  getInt(row,SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Set the value of the servicios_entidad.servicio_distribuido_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadServicioDistribuidoId(int newValue) throws DataStoreException {
          setInt(SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Set the value of the servicios_entidad.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadServicioDistribuidoId(int row,int newValue) throws DataStoreException {
          setInt(row,SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Retrieve the value of the servicios_entidad.entidad_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getServiciosEntidadEntidadId() throws DataStoreException {
          return  getInt(SERVICIOS_ENTIDAD_ENTIDAD_ID);
     }

     /**
      * Retrieve the value of the servicios_entidad.entidad_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getServiciosEntidadEntidadId(int row) throws DataStoreException {
          return  getInt(row,SERVICIOS_ENTIDAD_ENTIDAD_ID);
     }

     /**
      * Set the value of the servicios_entidad.entidad_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadEntidadId(int newValue) throws DataStoreException {
          setInt(SERVICIOS_ENTIDAD_ENTIDAD_ID, newValue);
     }

     /**
      * Set the value of the servicios_entidad.entidad_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadEntidadId(int row,int newValue) throws DataStoreException {
          setInt(row,SERVICIOS_ENTIDAD_ENTIDAD_ID, newValue);
     }

     /**
      * Retrieve the value of the servicios_entidad.anulado column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServiciosEntidadAnulado() throws DataStoreException {
          return  getString(SERVICIOS_ENTIDAD_ANULADO);
     }

     /**
      * Retrieve the value of the servicios_entidad.anulado column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServiciosEntidadAnulado(int row) throws DataStoreException {
          return  getString(row,SERVICIOS_ENTIDAD_ANULADO);
     }

     /**
      * Set the value of the servicios_entidad.anulado column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadAnulado(String newValue) throws DataStoreException {
          setString(SERVICIOS_ENTIDAD_ANULADO, newValue);
     }

     /**
      * Set the value of the servicios_entidad.anulado column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadAnulado(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIOS_ENTIDAD_ANULADO, newValue);
     }

     /**
      * Retrieve the value of the servicios_entidad.vigencia_desde column for the current row.
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServiciosEntidadVigenciaDesde() throws DataStoreException {
          return  getDate(SERVICIOS_ENTIDAD_VIGENCIA_DESDE);
     }

     /**
      * Retrieve the value of the servicios_entidad.vigencia_desde column for the specified row.
      * @param row which row in the table
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServiciosEntidadVigenciaDesde(int row) throws DataStoreException {
          return  getDate(row,SERVICIOS_ENTIDAD_VIGENCIA_DESDE);
     }

     /**
      * Set the value of the servicios_entidad.vigencia_desde column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadVigenciaDesde(java.sql.Date newValue) throws DataStoreException {
          setDate(SERVICIOS_ENTIDAD_VIGENCIA_DESDE, newValue);
     }

     /**
      * Set the value of the servicios_entidad.vigencia_desde column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadVigenciaDesde(int row,java.sql.Date newValue) throws DataStoreException {
          setDate(row,SERVICIOS_ENTIDAD_VIGENCIA_DESDE, newValue);
     }

     /**
      * Retrieve the value of the servicios_entidad.vigencia_hasta column for the current row.
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServiciosEntidadVigenciaHasta() throws DataStoreException {
          return  getDate(SERVICIOS_ENTIDAD_VIGENCIA_HASTA);
     }

     /**
      * Retrieve the value of the servicios_entidad.vigencia_hasta column for the specified row.
      * @param row which row in the table
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServiciosEntidadVigenciaHasta(int row) throws DataStoreException {
          return  getDate(row,SERVICIOS_ENTIDAD_VIGENCIA_HASTA);
     }

     /**
      * Set the value of the servicios_entidad.vigencia_hasta column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadVigenciaHasta(java.sql.Date newValue) throws DataStoreException {
          setDate(SERVICIOS_ENTIDAD_VIGENCIA_HASTA, newValue);
     }

     /**
      * Set the value of the servicios_entidad.vigencia_hasta column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServiciosEntidadVigenciaHasta(int row,java.sql.Date newValue) throws DataStoreException {
          setDate(row,SERVICIOS_ENTIDAD_VIGENCIA_HASTA, newValue);
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
      * Retrieve the value of the EntidadExterna.nombre column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEntidadExternaNombre() throws DataStoreException {
          return  getString(ENTIDAD_EXTERNA_NOMBRE);
     }

     /**
      * Retrieve the value of the EntidadExterna.nombre column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEntidadExternaNombre(int row) throws DataStoreException {
          return  getString(row,ENTIDAD_EXTERNA_NOMBRE);
     }

     /**
      * Set the value of the EntidadExterna.nombre column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEntidadExternaNombre(String newValue) throws DataStoreException {
          setString(ENTIDAD_EXTERNA_NOMBRE, newValue);
     }

     /**
      * Set the value of the EntidadExterna.nombre column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEntidadExternaNombre(int row,String newValue) throws DataStoreException {
          setString(row,ENTIDAD_EXTERNA_NOMBRE, newValue);
     }

     /**
      * Retrieve the value of the EntidadExterna.Codigo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEntidadExternaCodigo() throws DataStoreException {
          return  getString(ENTIDAD_EXTERNA_CODIGO);
     }

     /**
      * Retrieve the value of the EntidadExterna.Codigo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEntidadExternaCodigo(int row) throws DataStoreException {
          return  getString(row,ENTIDAD_EXTERNA_CODIGO);
     }

     /**
      * Set the value of the EntidadExterna.Codigo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEntidadExternaCodigo(String newValue) throws DataStoreException {
          setString(ENTIDAD_EXTERNA_CODIGO, newValue);
     }

     /**
      * Set the value of the EntidadExterna.Codigo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEntidadExternaCodigo(int row,String newValue) throws DataStoreException {
          setString(row,ENTIDAD_EXTERNA_CODIGO, newValue);
     }

     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
 	@Override
	public void retrieve(DBConnection conn, String criteria)
			throws SQLException {

		String criterioAdicional = "servicios_entidad.anulado = \"F\"";

		if (criteria == null || criteria.length() == 0) {
			criteria = criterioAdicional;
		} else {
			criteria = criteria + " and " + criterioAdicional;
		}

		super.retrieve(conn, criteria);
	}

     //$ENDCUSTOMMETHODS$
     
}
