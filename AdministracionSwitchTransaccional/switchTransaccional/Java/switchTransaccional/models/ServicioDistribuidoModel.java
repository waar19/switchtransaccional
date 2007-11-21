package switchTransaccional.models;

import java.sql.SQLException;

import infraestructura.reglasNegocio.ConvierteMayusculasValidation;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * ServicioDistribuidoModel: A SOFIA generated model
 */
public class ServicioDistribuidoModel extends DataStore {

     /**
	 * 
	 */
	private static final long serialVersionUID = 2404190277772128291L;
	//constants for columns
     public static final String SERVICIO_DISTRIBUIDO_SERVICIO_DISTRIBUIDO_ID="servicio_distribuido.servicio_distribuido_id";
     public static final String SERVICIO_DISTRIBUIDO_NOMBRE="servicio_distribuido.nombre";
     public static final String SERVICIO_DISTRIBUIDO_DESCRIPCION="servicio_distribuido.descripcion";
     public static final String SERVICIO_DISTRIBUIDO_OBSERVACIONES="servicio_distribuido.observaciones";
     public static final String SERVICIO_DISTRIBUIDO_ACTIVO="servicio_distribuido.activo";
     public static final String SERVICIO_DISTRIBUIDO_ANULADO="servicio_distribuido.anulado";
     public static final String SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE="servicio_distribuido.vigencia_desde";
     public static final String SERVICIO_DISTRIBUIDO_VIGENCIA_HASTA="servicio_distribuido.vigencia_hasta";
     public static final String SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML="servicio_distribuido.tipo_validacion_xml";
     public static final String SERVICIO_DISTRIBUIDO_VALIDACION="servicio_distribuido.validacion";
     public static final String SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO="servicio_distribuido.codigo_servicio";

     //$CUSTOMVARS$

//$ENDCUSTOMVARS$
     
     /**
      * Create a new ServicioDistribuidoModel object.
      * @param appName The SOFIA application name
      */
     public ServicioDistribuidoModel (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new ServicioDistribuidoModel object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public ServicioDistribuidoModel (String appName, String profile) { 
          super(appName, profile);

          try {

               //add aliases
               addTableAlias(computeTableName("servicio_distribuido"),null);

               //add columns
               addColumn(computeTableName("servicio_distribuido"),"servicio_distribuido_id",DataStore.DATATYPE_INT,true,true,SERVICIO_DISTRIBUIDO_SERVICIO_DISTRIBUIDO_ID);
               addColumn(computeTableName("servicio_distribuido"),"nombre",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_NOMBRE);
               addColumn(computeTableName("servicio_distribuido"),"descripcion",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_DESCRIPCION);
               addColumn(computeTableName("servicio_distribuido"),"observaciones",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_OBSERVACIONES);
               addColumn(computeTableName("servicio_distribuido"),"activo",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_ACTIVO);
               addColumn(computeTableName("servicio_distribuido"),"anulado",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_ANULADO);
               addColumn(computeTableName("servicio_distribuido"),"vigencia_desde",DataStore.DATATYPE_DATE,false,true,SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE);
               addColumn(computeTableName("servicio_distribuido"),"vigencia_hasta",DataStore.DATATYPE_DATE,false,true,SERVICIO_DISTRIBUIDO_VIGENCIA_HASTA);
               addColumn(computeTableName("servicio_distribuido"),"tipo_validacion_xml",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML);
               addColumn(computeTableName("servicio_distribuido"),"validacion",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_VALIDACION);
               addColumn(computeTableName("servicio_distribuido"),"codigo_servicio",DataStore.DATATYPE_STRING,false,true,SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO);

               //add validations
               addRequiredRule(SERVICIO_DISTRIBUIDO_NOMBRE,"El nombre del servicio es obligatorio");
               addRequiredRule(SERVICIO_DISTRIBUIDO_ACTIVO,"El indicador de activo es obligatorio");
               addRequiredRule(SERVICIO_DISTRIBUIDO_ANULADO,"EL indicador de anulado es obligatorio");
               addRequiredRule(SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE,"La fecha de vigencia es obligatoria");
               addRequiredRule(SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML,"El tipo de validación es obligatoria");
               addRequiredRule(SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO,"El Código de Servicio es obligatorio");
   			   addExpressionRule(SERVICIO_DISTRIBUIDO_NOMBRE,new ConvierteMayusculasValidation(SERVICIO_DISTRIBUIDO_NOMBRE), "", false);
   			   addExpressionRule(SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO,new ConvierteMayusculasValidation(SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO), "", false);

          }
          catch (DataStoreException e) {
               com.salmonllc.util.MessageLog.writeErrorMessage(e,this);
          }

          //$CUSTOMCONSTRUCTOR$

//$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the servicio_distribuido.servicio_distribuido_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getServicioDistribuidoServicioDistribuidoId() throws DataStoreException {
          return  getInt(SERVICIO_DISTRIBUIDO_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Retrieve the value of the servicio_distribuido.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getServicioDistribuidoServicioDistribuidoId(int row) throws DataStoreException {
          return  getInt(row,SERVICIO_DISTRIBUIDO_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Set the value of the servicio_distribuido.servicio_distribuido_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoServicioDistribuidoId(int newValue) throws DataStoreException {
          setInt(SERVICIO_DISTRIBUIDO_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoServicioDistribuidoId(int row,int newValue) throws DataStoreException {
          setInt(row,SERVICIO_DISTRIBUIDO_SERVICIO_DISTRIBUIDO_ID, newValue);
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
      * Retrieve the value of the servicio_distribuido.descripcion column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoDescripcion() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_DESCRIPCION);
     }

     /**
      * Retrieve the value of the servicio_distribuido.descripcion column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoDescripcion(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_DESCRIPCION);
     }

     /**
      * Set the value of the servicio_distribuido.descripcion column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoDescripcion(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_DESCRIPCION, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.descripcion column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoDescripcion(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_DESCRIPCION, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.observaciones column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoObservaciones() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_OBSERVACIONES);
     }

     /**
      * Retrieve the value of the servicio_distribuido.observaciones column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoObservaciones(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_OBSERVACIONES);
     }

     /**
      * Set the value of the servicio_distribuido.observaciones column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoObservaciones(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_OBSERVACIONES, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.observaciones column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoObservaciones(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_OBSERVACIONES, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.activo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoActivo() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_ACTIVO);
     }

     /**
      * Retrieve the value of the servicio_distribuido.activo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoActivo(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_ACTIVO);
     }

     /**
      * Set the value of the servicio_distribuido.activo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoActivo(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_ACTIVO, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.activo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoActivo(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_ACTIVO, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.anulado column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoAnulado() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_ANULADO);
     }

     /**
      * Retrieve the value of the servicio_distribuido.anulado column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoAnulado(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_ANULADO);
     }

     /**
      * Set the value of the servicio_distribuido.anulado column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoAnulado(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_ANULADO, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.anulado column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoAnulado(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_ANULADO, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.vigencia_desde column for the current row.
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServicioDistribuidoVigenciaDesde() throws DataStoreException {
          return  getDate(SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE);
     }

     /**
      * Retrieve the value of the servicio_distribuido.vigencia_desde column for the specified row.
      * @param row which row in the table
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServicioDistribuidoVigenciaDesde(int row) throws DataStoreException {
          return  getDate(row,SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE);
     }

     /**
      * Set the value of the servicio_distribuido.vigencia_desde column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoVigenciaDesde(java.sql.Date newValue) throws DataStoreException {
          setDate(SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.vigencia_desde column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoVigenciaDesde(int row,java.sql.Date newValue) throws DataStoreException {
          setDate(row,SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.vigencia_hasta column for the current row.
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServicioDistribuidoVigenciaHasta() throws DataStoreException {
          return  getDate(SERVICIO_DISTRIBUIDO_VIGENCIA_HASTA);
     }

     /**
      * Retrieve the value of the servicio_distribuido.vigencia_hasta column for the specified row.
      * @param row which row in the table
      * @return java.sql.Date
      * @throws DataStoreException
      */ 
     public java.sql.Date getServicioDistribuidoVigenciaHasta(int row) throws DataStoreException {
          return  getDate(row,SERVICIO_DISTRIBUIDO_VIGENCIA_HASTA);
     }

     /**
      * Set the value of the servicio_distribuido.vigencia_hasta column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoVigenciaHasta(java.sql.Date newValue) throws DataStoreException {
          setDate(SERVICIO_DISTRIBUIDO_VIGENCIA_HASTA, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.vigencia_hasta column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoVigenciaHasta(int row,java.sql.Date newValue) throws DataStoreException {
          setDate(row,SERVICIO_DISTRIBUIDO_VIGENCIA_HASTA, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.tipo_validacion_xml column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoTipoValidacionXml() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML);
     }

     /**
      * Retrieve the value of the servicio_distribuido.tipo_validacion_xml column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoTipoValidacionXml(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML);
     }

     /**
      * Set the value of the servicio_distribuido.tipo_validacion_xml column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoTipoValidacionXml(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.tipo_validacion_xml column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoTipoValidacionXml(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.validacion column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoValidacion() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_VALIDACION);
     }

     /**
      * Retrieve the value of the servicio_distribuido.validacion column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoValidacion(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_VALIDACION);
     }

     /**
      * Set the value of the servicio_distribuido.validacion column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoValidacion(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_VALIDACION, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.validacion column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoValidacion(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_VALIDACION, newValue);
     }

     /**
      * Retrieve the value of the servicio_distribuido.codigo_servicio column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoCodigoServicio() throws DataStoreException {
          return  getString(SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO);
     }

     /**
      * Retrieve the value of the servicio_distribuido.codigo_servicio column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getServicioDistribuidoCodigoServicio(int row) throws DataStoreException {
          return  getString(row,SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO);
     }

     /**
      * Set the value of the servicio_distribuido.codigo_servicio column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoCodigoServicio(String newValue) throws DataStoreException {
          setString(SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO, newValue);
     }

     /**
      * Set the value of the servicio_distribuido.codigo_servicio column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setServicioDistribuidoCodigoServicio(int row,String newValue) throws DataStoreException {
          setString(row,SERVICIO_DISTRIBUIDO_CODIGO_SERVICIO, newValue);
     }
     
     //$CUSTOMMETHODS$
     /** 
      * Completa las columnas por default para evitar probelmas con la base de datos
      * Sólo setea el default si no está definido aún 
      * @author demian
      * @param row indica sobre que fila del datastor se realiza la operación
      */
     public void setColumnasDefault(int row) throws DataStoreException {
    	 // solo setea las columnas si son null
    	 String col = getServicioDistribuidoActivo(row);
    	 if (col == null)
    		 setServicioDistribuidoActivo(row, "F");
    	 col = getServicioDistribuidoAnulado(row);
    	 if (col == null)
    		 setServicioDistribuidoAnulado(row, "F");
     }
     
     /**
      * Realiza el proceso de activación de una entidad
      * @param row registro dentro del datastor que se desea activar
      * @throws DataStoreException
      * @throws SQLException
      */
     public void activarServicio(int row) throws DataStoreException, SQLException {
 		String estado = getServicioDistribuidoActivo(row);
 		if (estado == "V") {
 			throw new DataStoreException("El servicio YA está activo");
 		}
 		
 		//TODO: Se debe completar con las validaciones "reglas de negocio" para activar a una entidad
 		
 		setServicioDistribuidoActivo(row, "V");
 		update();
 	}

 	
 	@Override
 	public void retrieve(DBConnection conn, String criteria)
 			throws SQLException {

 		String criterioAdicional = "servicio_distribuido.anulado = \"F\"";

 		if (criteria == null || criteria.length() == 0) {
 			criteria = criterioAdicional;
 		} else {
 			criteria = criteria + " and " + criterioAdicional;
 		}

 		super.retrieve(conn, criteria);
 	}


//$ENDCUSTOMMETHODS$
     
}
