//package statement
package switchTransaccional.controllers;

//Salmon import statements
import java.sql.SQLException;

import infraestructura.controllers.BaseController;

import com.salmonllc.html.events.PageEvent;
import com.salmonllc.html.events.SubmitEvent;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;


/**
 * AbmcRecuperaAtributosController: a SOFIA generated controller
 */
public class AbmcRecuperaAtributosController extends BaseController {

/**
	 * 
	 */
	private static final long serialVersionUID = 5952580278117853506L;
	//Visual Components
      public com.salmonllc.html.HtmlCheckBox _seleccion;
      public com.salmonllc.html.HtmlDropDownList _metodoXMLTE5;
      public com.salmonllc.html.HtmlLookUpComponent _atributoTE4;
      public com.salmonllc.html.HtmlMultiLineTextEdit _codigoTE7;
      public com.salmonllc.html.HtmlText _atributoCAP4;
      public com.salmonllc.html.HtmlText _codigoCAP7;
      public com.salmonllc.html.HtmlText _descripcionServicioTE3;
      public com.salmonllc.html.HtmlText _idServicioCAP1;
      public com.salmonllc.html.HtmlText _idServicioTE1;
      public com.salmonllc.html.HtmlText _metodoXMLCAP5;
      public com.salmonllc.html.HtmlText _nombreServicioCAP2;
      public com.salmonllc.html.HtmlText _nombreServicioTE2;
      public com.salmonllc.html.HtmlText _selCAP3;
      public com.salmonllc.jsp.JspBox _box1;
      public com.salmonllc.jsp.JspBox _box2;
      public com.salmonllc.jsp.JspDataTable _datatable1;
      public com.salmonllc.jsp.JspDisplayBox _displaybox1;
      public com.salmonllc.jsp.JspDisplayBox _displaybox2;

//DataSources
      public switchTransaccional.models.RecuperaAtributoModel _dsRecup;
      public switchTransaccional.models.ServicioDistribuidoModel _dsServicio;


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
		_dsRecup.setAutoValidate(true);
		
		// agrega los flags de seleccion para entidades y roles
		// Agrega columna de seleccion al datasource de informes
		_dsRecup.addBucket(SELECCION_FLAG, DataStore.DATATYPE_INT);
		_seleccion.setColumn(_dsRecup, SELECCION_FLAG);
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
			
			int row = _dsRecup.insertRow(0);

			// completa default de las columnas
			_dsRecup.setRecuperaAtributoServicioDistribuidoId(row,v_servicio_id);

			// hace foco en el registro
			int nroPagerow = _datatable1.getPage(row);
			int nroPageActual = _datatable1.getPage(_dsRecup.getRow());
			if (nroPagerow != nroPageActual)
				_datatable1.setPage(_datatable1.getPage(row));
		}
		
		// graba los datos del datastore
		if (e.getComponent() == _actualizarBUT4) {
			try {
				_dsRecup.update();
			} catch (DataStoreException ex) {
				displayErrorMessage(ex.getMessage());
				return false;
			}
		}
		
		// borro registros (baja lógica)
		if (e.getComponent() == _eliminarBUT3){
			// recorro el datastore y seteo como anulado a los registros
			for (int i = 0 ; i < _dsRecup.getRowCount() ; i++) {
				if (_dsRecup.getInt(i, SELECCION_FLAG) == 1) {
					// Entidad marcado para selección
					_dsRecup.deleteRow(i);
					// dessetea el flag
					_dsRecup.setInt(i, SELECCION_FLAG, 0);
					try {
						_dsRecup.update();
					} catch (DataStoreException ex) {
						displayErrorMessage(ex.getMessage());
						return false;
					}
				}

			}
		}
		
		// cancela operación de registro de proveedores para el servicio
		if (e.getComponent() == _cancelarBUT5) {
			_dsRecup.resetStatus();
			_dsRecup.reset();
			_dsRecup.retrieve();
			_dsRecup.gotoFirst();
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
				_dsRecup.reset();
				_dsServicio.reset();
			} else {
				// verifica si cambión el contexto
				if (tmp_servicio_distribuido_id != v_servicio_distribuido_id) {
					// cambió contexto, actualizo información
					v_servicio_distribuido_id = tmp_servicio_distribuido_id;
					_dsServicio.setCriteria("servicio_distribuido.servicio_distribuido_id = "
									+ Integer.toString(v_servicio_distribuido_id));
					_dsRecup.setCriteria("recupera_atributo.servicio_distribuido_id = "
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
						_dsRecup.retrieve();
						_dsRecup.gotoFirst();
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
