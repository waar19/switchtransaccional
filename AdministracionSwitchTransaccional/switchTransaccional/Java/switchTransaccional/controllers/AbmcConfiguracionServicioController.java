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
 * AbmcConfiguracionServicioController: a SOFIA generated controller
 */
public class AbmcConfiguracionServicioController extends BaseController {

/**
	 * 
	 */
	private static final long serialVersionUID = 7393789044307265092L;
	//Visual Components
      public com.salmonllc.html.HtmlCheckBox _seleccion;
      public com.salmonllc.html.HtmlLookUpComponent _configuracionTE4;
      public com.salmonllc.html.HtmlSubmitButton _actualizarBUT4;
      public com.salmonllc.html.HtmlSubmitButton _agregarBUT2;
      public com.salmonllc.html.HtmlSubmitButton _cancelarBUT5;
      public com.salmonllc.html.HtmlSubmitButton _eliminarBUT3;
      public com.salmonllc.html.HtmlText _back;
      public com.salmonllc.html.HtmlText _configuracionCAP4;
      public com.salmonllc.html.HtmlText _descripcionServicioTE3;
      public com.salmonllc.html.HtmlText _endpointAddressCAP9;
      public com.salmonllc.html.HtmlText _idServicioCAP1;
      public com.salmonllc.html.HtmlText _idServicioTE1;
      public com.salmonllc.html.HtmlText _namespaceUriCAP6;
      public com.salmonllc.html.HtmlText _nombrePuertoCAP8;
      public com.salmonllc.html.HtmlText _nombreServicioCAP2;
      public com.salmonllc.html.HtmlText _nombreServicioCAP7;
      public com.salmonllc.html.HtmlText _nombreServicioTE2;
      public com.salmonllc.html.HtmlText _selCAP3;
      public com.salmonllc.html.HtmlTextEdit _namespaceUriTE6;
      public com.salmonllc.html.HtmlTextEdit _nombreServicioTE7;
      public com.salmonllc.html.HtmlTextEdit _nombrePuertoTE8;
      public com.salmonllc.html.HtmlTextEdit _endpointAddressTE8;
      public com.salmonllc.jsp.JspBox _box1;
      public com.salmonllc.jsp.JspBox _box2;
      public com.salmonllc.jsp.JspDataTable _datatable1;
      public com.salmonllc.jsp.JspDisplayBox _displaybox1;
      public com.salmonllc.jsp.JspDisplayBox _displaybox2;
      public com.salmonllc.jsp.JspLink _lnkBack;

//DataSources
      public switchTransaccional.models.ConfiguracionServicioModel _dsConf;
      public switchTransaccional.models.ServicioDistribuidoModel _dsServicio;

       private String SELECCION_FLAG = "SELECCION_FLAG";

       private int v_servicio_distribuido_id = -2;

	@Override
	public void initialize() throws Exception {
		// completo botones a los listform
		_agregarBUT2.addSubmitListener(this);
		_eliminarBUT3.addSubmitListener(this);
		_actualizarBUT4.addSubmitListener(this);
		_cancelarBUT5.addSubmitListener(this);
		
		// prepara datastores para validar constraints
		_dsConf.setAutoValidate(true);
		
		// agrega los flags de seleccion para entidades y roles
		// Agrega columna de seleccion al datasource de informes
		_dsConf.addBucket(SELECCION_FLAG, DataStore.DATATYPE_INT);
		_seleccion.setColumn(_dsConf, SELECCION_FLAG);
		_seleccion.setFalseValue(null);

		
		//completa la invocación de BaseController
		super.initialize();
	}

	@Override
	public void pageRequested(PageEvent p) throws Exception {
		// verifico parámetros y seteo criterio de búsqueda
		// si la página es requerida por si misma no hago nada
		if (!isReferredByCurrentPage()) {
			int tmp_servicio_distribuido_id = getIntParameter("servicio_distribuido_id",-1);
			
			if (tmp_servicio_distribuido_id == -1) {
				// debe venir con parámetro
				displayErrorMessage("La página debe ser invocada con un parámetro");
				_dsConf.reset();
				_dsServicio.reset();
			} else {
				// verifica si cambión el contexto
				if (tmp_servicio_distribuido_id != v_servicio_distribuido_id) {
					// cambió contexto, actualizo información
					v_servicio_distribuido_id = tmp_servicio_distribuido_id;
					_dsServicio.setCriteria("servicio_distribuido.servicio_distribuido_id = "
									+ Integer.toString(v_servicio_distribuido_id));
					_dsConf.setCriteria("configuracion_servicio.servicio_distribuido_id = "
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
						_dsConf.retrieve();
						_dsConf.gotoFirst();
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
		super.pageRequested(p);
	}

	@Override
	public boolean submitPerformed(SubmitEvent e) throws Exception {

		// Nuevo registro de configuracion
		if (e.getComponent() == _agregarBUT2){
			
			if (_dsServicio.getRow() == -1) {
				displayErrorMessage("Debe estar en el contexto de un servicio para agregar configuración al servicio");
				return false;
			}
			
			int v_servicio_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_servicio_id < 1) {
				displayErrorMessage("Debe existir un servicio para agregar una configuración");
				return false;
			}
			
			int row = _dsConf.insertRow(0);

			// completa default de las columnas
			_dsConf.setConfiguracionServicioServicioDistribuidoId(row,v_servicio_id);

			// hace foco en el registro
			int nroPagerow = _datatable1.getPage(row);
			int nroPageActual = _datatable1.getPage(_dsConf.getRow());
			if (nroPagerow != nroPageActual)
				_datatable1.setPage(_datatable1.getPage(row));
		}
		
		// graba los datos del datastore
		if (e.getComponent() == _actualizarBUT4) {
			try {
				_dsConf.update();
			} catch (DataStoreException ex) {
				displayErrorMessage(ex.getMessage());
				return false;
			}
		}
		
		// borro registros (baja física)
		if (e.getComponent() == _eliminarBUT3){
			// recorro el datastore y seteo como anulado a los registros
			for (int i = 0 ; i < _dsConf.getRowCount() ; i++) {
				if (_dsConf.getInt(i, SELECCION_FLAG) == 1) {
					// Entidad marcado para selección
					_dsConf.deleteRow(i);
					// dessetea el flag
					_dsConf.setInt(i, SELECCION_FLAG, 0);
					try {
						_dsConf.update();
					} catch (DataStoreException ex) {
						displayErrorMessage(ex.getMessage());
						return false;
					}
				}

			}
		}
		
		// cancela operación de la configuración para el servicio
		if (e.getComponent() == _cancelarBUT5) {
			_dsConf.resetStatus();
			_dsConf.reset();
			_dsConf.retrieve();
			_dsConf.gotoFirst();
		}
		
		return super.submitPerformed(e);
	}
      	
 

}
