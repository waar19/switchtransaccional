package switchTransaccional.models;

import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * RecuperaAtributoModel: A SOFIA generated model
 */
public class RecuperaAtributoModel extends DataStore {

     /**
	 * 
	 */
	private static final long serialVersionUID = -4222903716049378875L;
	//constants for columns
     public static final String RECUPERA_ATRIBUTO_SERVICIO_DISTRIBUIDO_ID="recupera_atributo.servicio_distribuido_id";
     public static final String RECUPERA_ATRIBUTO_ATRIBUTO_ID="recupera_atributo.atributo_id";
     public static final String RECUPERA_ATRIBUTO_METODO_XML="recupera_atributo.metodo_xml";
     public static final String RECUPERA_ATRIBUTO_CODIGO="recupera_atributo.codigo";
     public static final String SERVICIO_DISTRIBUIDO_NOMBRE="servicio_distribuido.nombre";
     public static final String ATRIBUTOS_ROL_NOMBRE="atributos_rol.nombre";


     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new RecuperaAtributoModel object.
      * @param appName The SOFIA application name
      */
     public RecuperaAtributoModel (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new RecuperaAtributoModel object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public RecuperaAtributoModel (String appName, String profile) { 
          super(appName, profile);

          try {

               //add aliases
               addTableAlias(computeTableName("recupera_atributo"),null);
               addTableAlias(computeTableName("servicio_distribuido"),null);
               addTableAlias(computeTableName("infraestructura.atributos_rol"),"atributos_rol");
               

               //add columns
               addColumn(computeTableName("recupera_atributo"),"servicio_distribuido_id",DataStore.DATATYPE_INT,true,true,RECUPERA_ATRIBUTO_SERVICIO_DISTRIBUIDO_ID);
               addColumn(computeTableName("recupera_atributo"),"atributo_id",DataStore.DATATYPE_INT,true,true,RECUPERA_ATRIBUTO_ATRIBUTO_ID);
               addColumn(computeTableName("recupera_atributo"),"metodo_xml",DataStore.DATATYPE_STRING,false,true,RECUPERA_ATRIBUTO_METODO_XML);
               addColumn(computeTableName("recupera_atributo"),"codigo",DataStore.DATATYPE_STRING,false,true,RECUPERA_ATRIBUTO_CODIGO);
               addColumn(computeTableName("servicio_distribuido"),"nombre",DataStore.DATATYPE_STRING,false,false,SERVICIO_DISTRIBUIDO_NOMBRE);
               addColumn("atributos_rol","nombre",DataStore.DATATYPE_STRING,false,false,ATRIBUTOS_ROL_NOMBRE);

               //add joins
               addJoin(computeTableAndFieldName("recupera_atributo.servicio_distribuido_id"),computeTableAndFieldName("servicio_distribuido.servicio_distribuido_id"),false);
               addJoin(computeTableAndFieldName("recupera_atributo.atributo_id"),"atributos_rol.atributo_id",false);

               //set order by
               setOrderBy(computeTableAndFieldName(ATRIBUTOS_ROL_NOMBRE) + " ASC");

               //add validations
               addRequiredRule(RECUPERA_ATRIBUTO_ATRIBUTO_ID,"El atributo es obligatorio");
               addRequiredRule(RECUPERA_ATRIBUTO_CODIGO,"El código de transformación/recuperación es obligatorio");
               addRequiredRule(RECUPERA_ATRIBUTO_METODO_XML,"El método de recuperación es obligatorio");
               addLookupRule(RECUPERA_ATRIBUTO_ATRIBUTO_ID, "infraestructura.atributos_rol", "'infraestructura.atributos_rol.atributo_id = ' + recupera_atributo.atributo_id" , "nombre", ATRIBUTOS_ROL_NOMBRE, "Atributo inexistente");
          }
          catch (DataStoreException e) {
               com.salmonllc.util.MessageLog.writeErrorMessage(e,this);
          }

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the recupera_atributo.servicio_distribuido_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getRecuperaAtributoServicioDistribuidoId() throws DataStoreException {
          return  getInt(RECUPERA_ATRIBUTO_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Retrieve the value of the recupera_atributo.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getRecuperaAtributoServicioDistribuidoId(int row) throws DataStoreException {
          return  getInt(row,RECUPERA_ATRIBUTO_SERVICIO_DISTRIBUIDO_ID);
     }

     /**
      * Set the value of the recupera_atributo.servicio_distribuido_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoServicioDistribuidoId(int newValue) throws DataStoreException {
          setInt(RECUPERA_ATRIBUTO_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Set the value of the recupera_atributo.servicio_distribuido_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoServicioDistribuidoId(int row,int newValue) throws DataStoreException {
          setInt(row,RECUPERA_ATRIBUTO_SERVICIO_DISTRIBUIDO_ID, newValue);
     }

     /**
      * Retrieve the value of the recupera_atributo.atributo_id column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getRecuperaAtributoAtributoId() throws DataStoreException {
          return  getInt(RECUPERA_ATRIBUTO_ATRIBUTO_ID);
     }

     /**
      * Retrieve the value of the recupera_atributo.atributo_id column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getRecuperaAtributoAtributoId(int row) throws DataStoreException {
          return  getInt(row,RECUPERA_ATRIBUTO_ATRIBUTO_ID);
     }

     /**
      * Set the value of the recupera_atributo.atributo_id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoAtributoId(int newValue) throws DataStoreException {
          setInt(RECUPERA_ATRIBUTO_ATRIBUTO_ID, newValue);
     }

     /**
      * Set the value of the recupera_atributo.atributo_id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoAtributoId(int row,int newValue) throws DataStoreException {
          setInt(row,RECUPERA_ATRIBUTO_ATRIBUTO_ID, newValue);
     }

     /**
      * Retrieve the value of the recupera_atributo.metodo_xml column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getRecuperaAtributoMetodoXml() throws DataStoreException {
          return  getString(RECUPERA_ATRIBUTO_METODO_XML);
     }

     /**
      * Retrieve the value of the recupera_atributo.metodo_xml column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getRecuperaAtributoMetodoXml(int row) throws DataStoreException {
          return  getString(row,RECUPERA_ATRIBUTO_METODO_XML);
     }

     /**
      * Set the value of the recupera_atributo.metodo_xml column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoMetodoXml(String newValue) throws DataStoreException {
          setString(RECUPERA_ATRIBUTO_METODO_XML, newValue);
     }

     /**
      * Set the value of the recupera_atributo.metodo_xml column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoMetodoXml(int row,String newValue) throws DataStoreException {
          setString(row,RECUPERA_ATRIBUTO_METODO_XML, newValue);
     }

     /**
      * Retrieve the value of the recupera_atributo.codigo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getRecuperaAtributoCodigo() throws DataStoreException {
          return  getString(RECUPERA_ATRIBUTO_CODIGO);
     }

     /**
      * Retrieve the value of the recupera_atributo.codigo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getRecuperaAtributoCodigo(int row) throws DataStoreException {
          return  getString(row,RECUPERA_ATRIBUTO_CODIGO);
     }

     /**
      * Set the value of the recupera_atributo.codigo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoCodigo(String newValue) throws DataStoreException {
          setString(RECUPERA_ATRIBUTO_CODIGO, newValue);
     }

     /**
      * Set the value of the recupera_atributo.codigo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setRecuperaAtributoCodigo(int row,String newValue) throws DataStoreException {
          setString(row,RECUPERA_ATRIBUTO_CODIGO, newValue);
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
      * Retrieve the value of the AtributosRol.nombre column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getAtributosRolNombre() throws DataStoreException {
          return  getString(ATRIBUTOS_ROL_NOMBRE);
     }

     /**
      * Retrieve the value of the AtributosRol.nombre column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getAtributosRolNombre(int row) throws DataStoreException {
          return  getString(row,ATRIBUTOS_ROL_NOMBRE);
     }

     /**
      * Set the value of the AtributosRol.nombre column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setAtributosRolNombre(String newValue) throws DataStoreException {
          setString(ATRIBUTOS_ROL_NOMBRE, newValue);
     }

     /**
      * Set the value of the AtributosRol.nombre column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setAtributosRolNombre(int row,String newValue) throws DataStoreException {
          setString(row,ATRIBUTOS_ROL_NOMBRE, newValue);
     }

     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
 	 //$ENDCUSTOMMETHODS$
     
}
