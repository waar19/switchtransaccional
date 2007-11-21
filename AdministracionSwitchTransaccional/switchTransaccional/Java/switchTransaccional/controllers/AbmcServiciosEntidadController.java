//package statement
package switchTransaccional.controllers;

//Salmon import statements
import infraestructura.controllers.BaseController;

import java.sql.SQLException;

import com.salmonllc.html.events.PageEvent;
import com.salmonllc.html.events.SubmitEvent;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

/**
 * AbmcServiciosEntidadController: a SOFIA generated controller
 */
public class AbmcServiciosEntidadController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6561285242730806404L;

	// Visual Components
	public com.salmonllc.html.HtmlCheckBox _seleccion;
	public com.salmonllc.html.HtmlLookUpComponent _entidadIdTE4;
	public com.salmonllc.html.HtmlText _descripcionServicioTE3;
	public com.salmonllc.html.HtmlText _entidadCAP4;
	public com.salmonllc.html.HtmlText _idServicioCAP1;
	public com.salmonllc.html.HtmlText _idServicioTE1;
	public com.salmonllc.html.HtmlText _nombreServicioCAP2;
	public com.salmonllc.html.HtmlText _nombreServicioTE2;
	public com.salmonllc.html.HtmlText _selCAP3;
	public com.salmonllc.html.HtmlText _vigenciaCAP5;
	public com.salmonllc.html.HtmlTextEdit _desdeTE5;
	public com.salmonllc.html.HtmlTextEdit _hastaTE6;
	public com.salmonllc.jsp.JspBox _box1;
	public com.salmonllc.jsp.JspBox _box2;
	public com.salmonllc.jsp.JspDataTable _datatable1;
	public com.salmonllc.jsp.JspDisplayBox _displaybox1;
	public com.salmonllc.jsp.JspDisplayBox _displaybox2;

	// DataSources
	public switchTransaccional.models.ServicioDistribuidoModel _dsServicio;
	public switchTransaccional.models.ServiciosEntidadModel _dsServEnt;

	// DataSource Column Constants
	public static final String DSSERVENT_SERVICIOS_ENTIDAD_SERVICIO_DISTRIBUIDO_ID = "servicios_entidad.servicio_distribuido_id";
	public static final String DSSERVENT_SERVICIOS_ENTIDAD_ENTIDAD_ID = "servicios_entidad.entidad_id";
	public static final String DSSERVENT_SERVICIOS_ENTIDAD_ANULADO = "servicios_entidad.anulado";
	public static final String DSSERVENT_SERVICIOS_ENTIDAD_VIGENCIA_DESDE = "servicios_entidad.vigencia_desde";
	public static final String DSSERVENT_SERVICIOS_ENTIDAD_VIGENCIA_HASTA = "servicios_entidad.vigencia_hasta";
	public static final String DSSERVENT_SERVICIO_DISTRIBUIDO_NOMBRE = "servicio_distribuido.nombre";
	public static final String DSSERVENT_ENTIDAD_EXTERNA_CODIGO = "entidad_externa.codigo";
	public static final String DSSERVENT_ENTIDAD_EXTERNA_NOMBRE = "entidad_externa.nombre";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_SERVICIO_DISTRIBUIDO_ID = "servicio_distribuido.servicio_distribuido_id";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_NOMBRE = "servicio_distribuido.nombre";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_DESCRIPCION = "servicio_distribuido.descripcion";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_OBSERVACIONES = "servicio_distribuido.observaciones";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_ACTIVO = "servicio_distribuido.activo";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_ANULADO = "servicio_distribuido.anulado";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_VIGENCIA_DESDE = "servicio_distribuido.vigencia_desde";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_VIGENCIA_HASTA = "servicio_distribuido.vigencia_hasta";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_TIPO_VALIDACION_XML = "servicio_distribuido.tipo_validacion_xml";
	public static final String DSSERVICIO_SERVICIO_DISTRIBUIDO_VALIDACION = "servicio_distribuido.validacion";
	public static final String DSSERVICIO_PATH_VALIDACION = "path_validacion";
	
    private String SELECCION_FLAG = "SELECCION_FLAG";

	// botones custom
    public com.salmonllc.html.HtmlSubmitButton _agregarBUT2;
    public com.salmonllc.html.HtmlSubmitButton _eliminarBUT3;
    public com.salmonllc.html.HtmlSubmitButton _actualizarBUT4;
    public com.salmonllc.html.HtmlSubmitButton _cancelarBUT5;

	
	private int v_servicio_distribuido_id = -2;

	@Override
	public void initialize() throws Exception {
   		
		
		// completo botones a los listform
		_agregarBUT2.addSubmitListener(this);
		_eliminarBUT3.addSubmitListener(this);
		_actualizarBUT4.addSubmitListener(this);
		_cancelarBUT5.addSubmitListener(this);
		
		// prepara datastores para validar constraints
		_dsServEnt.setAutoValidate(true);
		
		// agrega los flags de seleccion para entidades y roles
		// Agrega columna de seleccion al datasource de informes
		_dsServEnt.addBucket(SELECCION_FLAG, DataStore.DATATYPE_INT);
		_seleccion.setColumn(_dsServEnt, SELECCION_FLAG);
		_seleccion.setFalseValue(null);

		
		//completa la invocación de BaseController
		super.initialize();
	}


	@Override
	public boolean submitPerformed(SubmitEvent e) throws Exception {
		
		// Nuevo registro de proveedor
		if (e.getComponent() == _agregarBUT2){
			
			if (_dsServicio.getRow() == -1) {
				displayErrorMessage("Debe estar en el contexto de un servicio para insertar (agregar) un proveedor");
				return false;
			}
			
			int v_servicio_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_servicio_id < 1) {
				displayErrorMessage("Debe existir un servicio para insertar (agregar) un proveedor");
				return false;
			}
			
			int row = _dsServEnt.insertRow(0);

			// completa default de las columnas
			_dsServEnt.setServiciosEntidadServicioDistribuidoId(row,v_servicio_id);
			_dsServEnt.setServiciosEntidadAnulado(row, "F");

			// hace foco en el registro
			int nroPagerow = _datatable1.getPage(row);
			int nroPageActual = _datatable1.getPage(_dsServEnt.getRow());
			if (nroPagerow != nroPageActual)
				_datatable1.setPage(_datatable1.getPage(row));
		}
		
		// graba los datos del datastore
		if (e.getComponent() == _actualizarBUT4) {
			try {
				_dsServEnt.update();
			} catch (DataStoreException ex) {
				displayErrorMessage(ex.getMessage());
				return false;
			}
		}
		
		// borro registros (baja lógica)
		if (e.getComponent() == _eliminarBUT3){
			// recorro el datastore y seteo como anulado a los registros
			for (int i = 0 ; i < _dsServEnt.getRowCount() ; i++) {
				if (_dsServEnt.getInt(i, SELECCION_FLAG) == 1) {
					// Entidad marcado para selección
					_dsServEnt.setServiciosEntidadAnulado(i, "V");
					// dessetea el flag
					_dsServEnt.setInt(i, SELECCION_FLAG, 0);
					try {
						_dsServEnt.update();
					} catch (DataStoreException ex) {
						displayErrorMessage(ex.getMessage());
						return false;
					}
					
					// elimina al registro del datastore
					_dsServEnt.removeRow(i);
				}

			}
		}
		
		// cancela operación de registro de proveedores para el servicio
		if (e.getComponent() == _cancelarBUT5) {
			_dsServEnt.resetStatus();
			_dsServEnt.reset();
			_dsServEnt.retrieve();
			_dsServEnt.gotoFirst();
		}
		
		return super.submitPerformed(e);
	}


	@Override
	public void pageRequested(PageEvent p) {
		// verifico parámetros y seteo criterio de búsqueda
		// si la página es requerida por si misma no hago nada
		if (!isReferredByCurrentPage()) {
			int tmp_servicio_distribuido_id = getIntParameter("servicio_distribuido_id",-1);
			
			if (tmp_servicio_distribuido_id == -1) {
				// debe venir con parámetro
				displayErrorMessage("La página debe ser invocada con un parámetro");
				_dsServEnt.reset();
				_dsServicio.reset();
			} else {
				// verifica si cambión el contexto
				if (tmp_servicio_distribuido_id != v_servicio_distribuido_id) {
					// cambió contexto, actualizo información
					v_servicio_distribuido_id = tmp_servicio_distribuido_id;
					_dsServicio.setCriteria("servicio_distribuido.servicio_distribuido_id = "
									+ Integer.toString(v_servicio_distribuido_id));
					_dsServEnt.setCriteria("servicios_entidad.servicio_distribuido_id = "
									+ Integer.toString(v_servicio_distribuido_id));
					try {
						_dsServicio.retrieve();
						// controla que se recupera estrictamente 1 registro y luego se para en el
						_dsServicio.waitForRetrieve();
						if (_dsServicio.getRowCount() != 1) {
							displayErrorMessage("Recuperó mas de un servicio...Llame a su adminsitrador de sistema");
							return;
						}
						_dsServicio.gotoFirst();
						_dsServEnt.retrieve();
						_dsServEnt.gotoFirst();
					} catch (SQLException e) {
						displayErrorMessage(e.getMessage());
						e.printStackTrace();
					} catch (DataStoreException e) {
						displayErrorMessage(e.getMessage());
						e.printStackTrace();
					}
					
				}
			}
			
		}
		super.pageSubmitted(p);
	}

}
