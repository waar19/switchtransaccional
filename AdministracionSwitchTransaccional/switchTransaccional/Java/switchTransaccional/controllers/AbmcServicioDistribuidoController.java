//package statement
package switchTransaccional.controllers;

//Salmon import statements
import infraestructura.controllers.BaseController;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

import com.salmonllc.html.HtmlSubmitButton;
import com.salmonllc.html.events.PageEvent;
import com.salmonllc.html.events.SubmitEvent;
import com.salmonllc.sql.DataStoreBuffer;
import com.salmonllc.sql.DataStoreException;


/**
 * AbmcServicioDistribuidoController: a SOFIA generated controller
 */
public class AbmcServicioDistribuidoController extends BaseController //implements FileUploadListener 
{

/**
	 * 
	 */
	private static final long serialVersionUID = -7346804184918229732L;
	//Visual Components
      public com.salmonllc.html.HtmlDropDownList _tipoValidacionTE7;
      public com.salmonllc.html.HtmlLookUpComponent _valorTE11;
      public com.salmonllc.html.HtmlMultiLineTextEdit _validacionTextoTE8;
      public com.salmonllc.html.HtmlText _activoCAP14;
      public com.salmonllc.html.HtmlText _activoCAP9;
      public com.salmonllc.html.HtmlText _activoTE10;
      public com.salmonllc.html.HtmlText _activoTXT5;
      public com.salmonllc.html.HtmlText _atributoCAP15;
      public com.salmonllc.html.HtmlText _atributoTXT6;
      public com.salmonllc.html.HtmlText _buscarCAP1;
      public com.salmonllc.html.HtmlText _codigoServicioCAP7;
      public com.salmonllc.html.HtmlText _descripcionCAP11;
      public com.salmonllc.html.HtmlText _descripcionCAP4;
      public com.salmonllc.html.HtmlText _descripcionTXT2;
      public com.salmonllc.html.HtmlText _desdeCAP12;
      public com.salmonllc.html.HtmlText _desdeTXT3;
      public com.salmonllc.html.HtmlText _hastaCAP13;
      public com.salmonllc.html.HtmlText _hastaTXT4;
      public com.salmonllc.html.HtmlText _iDCAP8;
      public com.salmonllc.html.HtmlText _idTE9;
      public com.salmonllc.html.HtmlText _nombreCAP10;
      public com.salmonllc.html.HtmlText _nombreCAP2;
      public com.salmonllc.html.HtmlText _nombreTXT1;
      public com.salmonllc.html.HtmlText _observacionesCAP5;
      public com.salmonllc.html.HtmlText _tipoDatoCAP6;
      public com.salmonllc.html.HtmlText _valorCAP16;
      public com.salmonllc.html.HtmlText _vigenciaCAP3;
      public com.salmonllc.html.HtmlTextEdit _buscarTE1;
      public com.salmonllc.html.HtmlTextEdit _codigoServicioTE7;
      public com.salmonllc.html.HtmlTextEdit _descripcionTE5;
      public com.salmonllc.html.HtmlTextEdit _desdeTE3;
      public com.salmonllc.html.HtmlTextEdit _hastaTE4;
      public com.salmonllc.html.HtmlTextEdit _nombreTE2;
      public com.salmonllc.html.HtmlTextEdit _observacionesTE6;
      public com.salmonllc.jsp.JspBox _box1;
      public com.salmonllc.jsp.JspBox _box2;
      public com.salmonllc.jsp.JspBox _box3;
      public com.salmonllc.jsp.JspDataTable _datatable1;
      public com.salmonllc.jsp.JspDataTable _datatable3;
      public com.salmonllc.jsp.JspDetailFormDisplayBox _detailformdisplaybox1;
      public com.salmonllc.jsp.JspListFormDisplayBox _listformdisplaybox1;
      public com.salmonllc.jsp.JspListFormDisplayBox _listformdisplaybox3;
      public com.salmonllc.jsp.JspSearchFormDisplayBox _searchformdisplaybox1;
      public com.salmonllc.jsp.JspTable _table2;

//DataSources
      public com.salmonllc.sql.QBEBuilder _dsQBE;
      public infraestructura.models.AtributosEntidadModel _dsAtributos;
      public switchTransaccional.models.ServicioDistribuidoModel _dsServicio;

//DataSource Column Constants

   	// botones custom
    public com.salmonllc.html.HtmlSubmitButton _atributosServicioBUT1;
    public com.salmonllc.html.HtmlSubmitButton _entidadesServicioBUT2;
    public com.salmonllc.html.HtmlSubmitButton _configurarServicioBUT3;
   	public com.salmonllc.html.HtmlSubmitButton _activarServicioBUT4;
   	public com.salmonllc.html.HtmlSubmitButton _logTransaccionesBUT5;
   	public com.salmonllc.html.HtmlSubmitButton _grabarAtributoBUT1;
   	public com.salmonllc.html.HtmlSubmitButton _atributoGenerarAtributosBUT11;
   	public com.salmonllc.html.HtmlSubmitButton _atributoEtiquetaBUT1;
   	public com.salmonllc.html.HtmlSubmitButton _atributoEtiquetaBUT2;
   	public com.salmonllc.html.HtmlSubmitButton _atributoEtiquetaBUT3;
   	public com.salmonllc.html.HtmlSubmitButton _atributoEtiquetaBUT4;
   	public com.salmonllc.html.HtmlSubmitButton _atributoEtiquetaBUT5;
   	public com.salmonllc.html.HtmlSubmitButton _atributoEtiquetaBUT6;

   	private int botonSeleccionado = -1;

   	@Override
   	public void initialize() throws Exception {
   		// completo botones a los listform
   		
   		// botones para Entidades externas Listformdisplaybox1
   		_atributosServicioBUT1 = new HtmlSubmitButton("atributosServicioBUT1","Esquema Atributos",this);
   		_listformdisplaybox1.addButton(_atributosServicioBUT1);
   		
   		_entidadesServicioBUT2 = new HtmlSubmitButton("entidadesServicioBUT2","Proveedores",this);
   		_listformdisplaybox1.addButton(_entidadesServicioBUT2);
   		
   		_configurarServicioBUT3 = new HtmlSubmitButton("configurarServicioBUT3","Configuración",this);
   		_listformdisplaybox1.addButton(_configurarServicioBUT3);
   		
   		_logTransaccionesBUT5 = new HtmlSubmitButton("logTransaccionesBUT5","Log Transacciones",this);
   		_listformdisplaybox1.addButton(_logTransaccionesBUT5);
   		
   		_activarServicioBUT4 = new HtmlSubmitButton("activarEntidadBUT4","acTivar",this);
   		_activarServicioBUT4.setAccessKey("T");
   		_detailformdisplaybox1.addButton(_activarServicioBUT4);

   		// botones para atributos
   		_grabarAtributoBUT1 = new HtmlSubmitButton("grabarAtributoBUT1","grabar",this);
   		_listformdisplaybox3.addButton(_grabarAtributoBUT1);

   		_atributoGenerarAtributosBUT11 = new HtmlSubmitButton("atributoGenerarAtributosBUT11", "generar", this);
   		_listformdisplaybox3.addButton(_atributoGenerarAtributosBUT11);
   		
   		_atributoEtiquetaBUT1 = new HtmlSubmitButton("atributoEtiquetaBUT1","etiqueta 1", this);
   		_listformdisplaybox3.addButton(_atributoEtiquetaBUT1);
   		_atributoEtiquetaBUT2 = new HtmlSubmitButton("atributoEtiquetaBUT2","etiqueta 2", this);
   		_listformdisplaybox3.addButton(_atributoEtiquetaBUT2);
   		_atributoEtiquetaBUT3 = new HtmlSubmitButton("atributoEtiquetaBUT3","etiqueta 3", this);
   		_listformdisplaybox3.addButton(_atributoEtiquetaBUT3);
   		_atributoEtiquetaBUT4 = new HtmlSubmitButton("atributoEtiquetaBUT4","etiqueta 4", this);
   		_listformdisplaybox3.addButton(_atributoEtiquetaBUT4);
   		_atributoEtiquetaBUT5 = new HtmlSubmitButton("atributoEtiquetaBUT5","etiqueta 5", this);
   		_listformdisplaybox3.addButton(_atributoEtiquetaBUT5);
   		_atributoEtiquetaBUT6 = new HtmlSubmitButton("atributoEtiquetaBUT6","etiqueta 6", this);
   		_listformdisplaybox3.addButton(_atributoEtiquetaBUT6);

   		// genera el listener para los botones
   		_atributosServicioBUT1.addSubmitListener(this);
   		_entidadesServicioBUT2.addSubmitListener(this);
   		_configurarServicioBUT3.addSubmitListener(this);
   		_activarServicioBUT4.addSubmitListener(this);
   		_logTransaccionesBUT5.addSubmitListener(this);
   		_atributoGenerarAtributosBUT11.addSubmitListener(this);
   		_grabarAtributoBUT1.addSubmitListener(this);
   		_atributoEtiquetaBUT1.addSubmitListener(this);
   		_atributoEtiquetaBUT2.addSubmitListener(this);
   		_atributoEtiquetaBUT3.addSubmitListener(this);
   		_atributoEtiquetaBUT4.addSubmitListener(this);
   		_atributoEtiquetaBUT5.addSubmitListener(this);
   		_atributoEtiquetaBUT6.addSubmitListener(this);
   		
   		// Genera listener para el fileUpload
   		//_validacionTE8.addFileUploadListener(this);
   		
   		// setea la validación para lso datasources
   		_dsServicio.setAutoValidate(true);
   		_dsAtributos.setAutoValidate(true);
   		
   		// setea primera visualización
   		seteaBotonesAtributos(-1);
   		seteaNuevoBoton(-1);

   		super.initialize();
   	}
   	
   	
 
	@Override
	public boolean submitPerformed(SubmitEvent e) throws Exception {
		
		// define el esquema de recuperación de atributos para el servicio
		if (e.getComponent() == _atributosServicioBUT1) {
			
			int servicio = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (servicio < 1) {
				displayErrorMessage("Debe seleccionar un servicio para ver/definir la lista de proveedores");
				return false;
			}
			
			gotoSiteMapPage("AbmcRecuperaAtributos","?servicio_distribuido_id="+ Integer.toString(servicio));
		}
		
		// Lista de proveedores habilitados para el servicios
		if (e.getComponent() == _entidadesServicioBUT2) {
			int servicio = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (servicio < 1) {
				displayErrorMessage("Debe seleccionar un servicio para ver/definir la lista de proveedores");
				return false;
			}
			
			gotoSiteMapPage("AbmcServiciosEntidad","?servicio_distribuido_id="+ Integer.toString(servicio));
		}

		// Configura el copmportamiento del servicio
		if (e.getComponent() == _configurarServicioBUT3) {
			int servicio = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (servicio < 1) {
				displayErrorMessage("Debe seleccionar un servicio para configurar su comportamiento");
				return false;
			}
			
			gotoSiteMapPage("AbmcConfiguracionServicio","?servicio_distribuido_id="+ Integer.toString(servicio));
		}

		// va al log de transacciones
		if (e.getComponent() == _logTransaccionesBUT5) {
			int servicio = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (servicio < 1) {
				displayErrorMessage("Debe seleccionar un servicio para ver el log de transacciones");
				return false;
			}
			
			gotoSiteMapPage("InformeLog","?servicio_distribuido_id="+ Integer.toString(servicio));
		}

		// Activa servicio -- este propceso garantiza que esté todo en orden con el servicio
		if (e.getComponent() == _activarServicioBUT4) {
			int row = _dsServicio.getRow();
			
			if (row == -1) {
				displayErrorMessage("Debe seleccionar un servicio para poder activarlo");
				return false;
			}
			
			// controles sobre la coluna activo
			String estado = _dsServicio.getServicioDistribuidoActivo(row);
			if (estado == "V") {
				displayErrorMessage("El servicio YA está activo");
				return false;
			}
			
			// ahora si activo
			try {
				_dsServicio.activarServicio(row);
			} catch (DataStoreException ex) {
				displayErrorMessage(ex.getMessage());
				return false;
			}
		}

		// graba atributos de entidad
		if (e.getComponent() == _grabarAtributoBUT1) {
			try {
				_dsAtributos.update();
			} catch (DataStoreException ex) {
				displayErrorMessage(ex.getMessage());
				return false;
			}
		}
		
		//genera atributos, por si faltan
		if (e.getComponent() == _atributoGenerarAtributosBUT11){
			// primero determina contexto
			int v_objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_objeto_id < 1){
				displayErrorMessage("Debe seleccionar un servoicio para poder generar sus atributos");
				return false;
			}
			
			// manda a generar los atributos de la entidad
			try {
				_dsAtributos.generaAtributosObjetoAplicacion(v_objeto_id, "servicio_distribuido");
			} catch (DataStoreException ex) {
				displayErrorMessage(ex.getMessage());
				return false;
			}
			seteaBotonesAtributos(v_objeto_id);
			recuperaAtributosBotonSeleccionado(v_objeto_id);
		}
		
		// controla el efecto de solapa de los botones y recupera los atributos
		// correspondientes
		if (e.getComponent() == _atributoEtiquetaBUT1) {
			// toma acciones de solapa de atributos
			int v_objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_objeto_id > 0) {
				seteaNuevoBoton(1);
				recuperaAtributosBotonSeleccionado(v_objeto_id);
			}
			else {
				// no está en contexto de nungún proyecto reseteo las vistas
				_dsAtributos.reset();
			}
		}

		// controla el efecto de solapa de los botones y recupera los atributos
		// correspondientes
		if (e.getComponent() == _atributoEtiquetaBUT2) {
			// toma acciones de solapa de atributos
			int v_objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_objeto_id > 0) {
				seteaNuevoBoton(2);
				recuperaAtributosBotonSeleccionado(v_objeto_id);
			}
			else {
				// no está en contexto de nungún proyecto reseteo las vistas
				_dsAtributos.reset();
			}
		}

		// controla el efecto de solapa de los botones y recupera los atributos
		// correspondientes
		if (e.getComponent() == _atributoEtiquetaBUT3) {
			// toma acciones de solapa de atributos
			int v_objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_objeto_id > 0) {
				seteaNuevoBoton(3);
				recuperaAtributosBotonSeleccionado(v_objeto_id);
			}
			else {
				// no está en contexto de nungún proyecto reseteo las vistas
				_dsAtributos.reset();
			}
		}

		// controla el efecto de solapa de los botones y recupera los atributos
		// correspondientes
		if (e.getComponent() == _atributoEtiquetaBUT4) {
			// toma acciones de solapa de atributos
			int v_objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_objeto_id > 0) {
				seteaNuevoBoton(4);
				recuperaAtributosBotonSeleccionado(v_objeto_id);
			}
			else {
				// no está en contexto de nungún proyecto reseteo las vistas
				_dsAtributos.reset();
			}
		}

		// controla el efecto de solapa de los botones y recupera los atributos
		// correspondientes
		if (e.getComponent() == _atributoEtiquetaBUT5) {
			// toma acciones de solapa de atributos
			int v_objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_objeto_id > 0) {
				seteaNuevoBoton(5);
				recuperaAtributosBotonSeleccionado(v_objeto_id);
			}
			else {
				// no está en contexto de nungún proyecto reseteo las vistas
				_dsAtributos.reset();
			}
		}

		// controla el efecto de solapa de los botones y recupera los atributos
		// correspondientes
		if (e.getComponent() == _atributoEtiquetaBUT6) {
			// toma acciones de solapa de atributos
			int v_objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
			if (v_objeto_id > 0) {
				seteaNuevoBoton(6);
				recuperaAtributosBotonSeleccionado(v_objeto_id);
			}
			else {
				// no está en contexto de nungún proyecto reseteo las vistas
				_dsAtributos.reset();
			}
		}
		
		return super.submitPerformed(e);
	}



	@Override
	public void pageSubmitEnd(PageEvent p) {
		// ante cada requerimiento verifica contexto y determina detalle de
		// atributos y completa FK's
		// Es row de rol válida?
		try {
			boolean actualizar = false;
			int row = _dsServicio.getRow();
			int objeto_id = 0;
			int objeto_id_atributos = 0;
			if (row != -1) {

				// completa default de las columnas
				_dsServicio.setColumnasDefault(row);

				// recupera el id del servicio de contexto
				objeto_id = _dsServicio.getServicioDistribuidoServicioDistribuidoId();
				// si se está insertando un nuevo registro de rol, no se actualiza
				if (!(_dsAtributos.getRowStatus() ==  DataStoreBuffer.STATUS_NEW || 
						_dsAtributos.getRowStatus() == DataStoreBuffer.STATUS_NEW_MODIFIED))
				{
					// Ya existe detalle de atributos?
					if (_dsAtributos.getRowCount() > 0 ) {
						// es el mismo contexto? --> recupero la entidad del detalle para verificación, siempre del primer registro
						objeto_id_atributos = _dsAtributos.getAtributosEntidadObjetoId(0);
						if (objeto_id_atributos == 0)
							actualizar = true;
						if (objeto_id_atributos != objeto_id) {
							// Es distinto el contexto del rol de atributo
							actualizar = true;
						}
					}
					else {
						actualizar = true;
					}
				}
			}
			if (actualizar) {
				actualizarDetalles(objeto_id);
			}
			
		} catch (DataStoreException e) {
			displayErrorMessage(e.getMessage());
		} catch (SQLException e) {
			displayErrorMessage(e.getMessage());
		}

		super.pageSubmitEnd(p);
	}


	public void actualizarDetalles(int p_servicio_id) throws SQLException, DataStoreException{
		_dsAtributos.reset();
		seteaBotonesAtributos(p_servicio_id);
		recuperaAtributosBotonSeleccionado(p_servicio_id);
	}
	
	private void seteaBotonesAtributos(int p_servicio_id) {

		Hashtable et = null;

		// resetea la botonera
		_atributoEtiquetaBUT1.setVisible(false);
		_atributoEtiquetaBUT2.setVisible(false);
		_atributoEtiquetaBUT3.setVisible(false);
		_atributoEtiquetaBUT4.setVisible(false);
		_atributoEtiquetaBUT5.setVisible(false);
		_atributoEtiquetaBUT6.setVisible(false);
		
		//si no hay seteado servicio termina
		if (p_servicio_id < 1)
			return;
		
		// setea los botones de los atributos según las etiquetas
		try {
			et = _dsAtributos.recuperaEtiquetasAtributosObjetoAplicacion("servicio_distribuido");
		} catch (SQLException e) {
			displayErrorMessage(e.getLocalizedMessage());
			return;
		}
		if (et != null) {
			final Enumeration etiquetas = et.elements();
			for (int i = 0; i < et.size(); i++) {
				switch (i) {
				case 0:
					_atributoEtiquetaBUT1.setDisplayName((String) etiquetas.nextElement());
					if (_atributoEtiquetaBUT1.getDisplayName() == null || _atributoEtiquetaBUT1.getDisplayName().trim().length() == 0)
						_atributoEtiquetaBUT1.setDisplayName("General");
					_atributoEtiquetaBUT1.setVisible(true);
					break;
				case 1:
					_atributoEtiquetaBUT2.setDisplayName((String) etiquetas.nextElement());
					if (_atributoEtiquetaBUT2.getDisplayName() == null || _atributoEtiquetaBUT2.getDisplayName().trim().length() == 0)
						_atributoEtiquetaBUT2.setDisplayName("General");
					_atributoEtiquetaBUT2.setVisible(true);
					break;
				case 2:
					_atributoEtiquetaBUT3.setDisplayName((String) etiquetas.nextElement());
					if (_atributoEtiquetaBUT3.getDisplayName() == null || _atributoEtiquetaBUT3.getDisplayName().trim().length() == 0)
						_atributoEtiquetaBUT3.setDisplayName("General");
					_atributoEtiquetaBUT3.setVisible(true);
					break;
				case 3:
					_atributoEtiquetaBUT4.setDisplayName((String) etiquetas.nextElement());
					if (_atributoEtiquetaBUT4.getDisplayName() == null || _atributoEtiquetaBUT4.getDisplayName().trim().length() == 0)
						_atributoEtiquetaBUT4.setDisplayName("General");
					_atributoEtiquetaBUT4.setVisible(true);
					break;
				case 4:
					_atributoEtiquetaBUT5.setDisplayName((String) etiquetas.nextElement());
					if (_atributoEtiquetaBUT5.getDisplayName() == null || _atributoEtiquetaBUT5.getDisplayName().trim().length() == 0)
						_atributoEtiquetaBUT5.setDisplayName("General");
					_atributoEtiquetaBUT5.setVisible(true);
					break;
				case 5:
					_atributoEtiquetaBUT6.setDisplayName((String) etiquetas.nextElement());
					if (_atributoEtiquetaBUT6.getDisplayName() == null || _atributoEtiquetaBUT6.getDisplayName().trim().length() == 0)
						_atributoEtiquetaBUT6.setDisplayName("General");
					_atributoEtiquetaBUT6.setVisible(true);
					break;
				}
			}
			// seteo el primero 
			seteaNuevoBoton(1);
		}
		else
			seteaNuevoBoton(-1);

	}

	private void recuperaAtributosBotonSeleccionado(int p_objeto_id) throws SQLException, DataStoreException {
		// recupera los atributos asociados al proyectos de acuerdo al boton
		// seleccionado
		switch (botonSeleccionado) {
		case 1:
			if (_atributoEtiquetaBUT1.getDisplayName().equalsIgnoreCase("General"))
				_dsAtributos.recuperaAtributosEtiquetaObjetoAplicacion(null, p_objeto_id, "servicio_distribuido");
			else
				_dsAtributos.recuperaAtributosEtiquetaObjetoAplicacion(_atributoEtiquetaBUT1.getDisplayName(), p_objeto_id,"servicio_distribuido");
			break;
		case 2:
			_dsAtributos.recuperaAtributosEtiquetaObjetoAplicacion(_atributoEtiquetaBUT2.getDisplayName(), p_objeto_id,"servicio_distribuido");
			break;
		case 3:
			_dsAtributos.recuperaAtributosEtiquetaObjetoAplicacion(_atributoEtiquetaBUT3.getDisplayName(), p_objeto_id,"servicio_distribuido");

			break;
		case 4:
			_dsAtributos.recuperaAtributosEtiquetaObjetoAplicacion(_atributoEtiquetaBUT4.getDisplayName(), p_objeto_id,"servicio_distribuido");
			break;
		case 5:
			_dsAtributos.recuperaAtributosEtiquetaObjetoAplicacion(_atributoEtiquetaBUT5.getDisplayName(), p_objeto_id,"servicio_distribuido");
			break;
		case 6:
			_dsAtributos.recuperaAtributosEtiquetaObjetoAplicacion(_atributoEtiquetaBUT6.getDisplayName(), p_objeto_id,"servicio_distribuido");
			break;
		}
	}

	private void seteaNuevoBoton(int nuevoBoton) {
		// resetea el boton actual y setea el nuevo
		if (nuevoBoton == -1) {
			// no hay botón seleccionado, reseteo todos los botones
			botonSeleccionado = nuevoBoton;
			_atributoEtiquetaBUT1.setButtonBgColor("lightGray");
			_atributoEtiquetaBUT2.setButtonBgColor("lightGray");
			_atributoEtiquetaBUT3.setButtonBgColor("lightGray");
			_atributoEtiquetaBUT4.setButtonBgColor("lightGray");
			_atributoEtiquetaBUT5.setButtonBgColor("lightGray");
			_atributoEtiquetaBUT6.setButtonBgColor("lightGray");
		} else {
			// es un boton válido seteo a nuevo botón
			switch (botonSeleccionado) {
			case 1:
				_atributoEtiquetaBUT1.setButtonBgColor("lightGray");
				break;
			case 2:
				_atributoEtiquetaBUT2.setButtonBgColor("lightGray");
				break;
			case 3:
				_atributoEtiquetaBUT3.setButtonBgColor("lightGray");
				break;
			case 4:
				_atributoEtiquetaBUT4.setButtonBgColor("lightGray");
				break;
			case 5:
				_atributoEtiquetaBUT5.setButtonBgColor("lightGray");
				break;
			case 6:
				_atributoEtiquetaBUT6.setButtonBgColor("lightGray");
				break;
			}

			botonSeleccionado = nuevoBoton;

			// enfatiza el nuevo boton
			switch (botonSeleccionado) {
			case 1:
				_atributoEtiquetaBUT1.setButtonBgColor("red");
				break;
			case 2:
				_atributoEtiquetaBUT2.setButtonBgColor("red");
				break;
			case 3:
				_atributoEtiquetaBUT3.setButtonBgColor("red");
				break;
			case 4:
				_atributoEtiquetaBUT4.setButtonBgColor("red");
				break;
			case 5:
				_atributoEtiquetaBUT5.setButtonBgColor("red");
				break;
			case 6:
				_atributoEtiquetaBUT6.setButtonBgColor("red");
				break;
			}
		}
	}



//	public void fileUploaded(FileUploadEvent e) {
//		String nombre = _validacionTE8.getFileName();
//
//		if (nombre == null) {
//			displayErrorMessage("Debe escribir el nombre de un archivo para porder recuperarlo");
//		} else {
//
//			byte[] buf = _validacionTE8.getContent();
//			if (buf == null) {
//				displayErrorMessage("No se recuperó ningún archivo");
//
//			} else {
//				int leido = buf.length;
//				for (int i = 0; i < leido; i++)
//					try {
//						_dsServicio
//								.setServicioDistribuidoValidacion(_dsServicio
//										.getServicioDistribuidoValidacion()
//										+ (char) buf[i]);
//					} catch (DataStoreException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//			}
//		}
//		try {
//			_dsServicio.update();
//		} catch (DataStoreException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}

}
