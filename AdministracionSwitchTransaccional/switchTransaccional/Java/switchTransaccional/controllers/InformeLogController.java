//package statement
package switchTransaccional.controllers;

//Salmon import statements
import java.sql.SQLException;

import com.salmonllc.html.events.PageEvent;
import com.salmonllc.jsp.JspLink;
import com.salmonllc.sql.DataStoreException;

import infraestructura.controllers.BaseController;


/**
 * InformeLogController: a SOFIA generated controller
 */
public class InformeLogController extends BaseController {

/**
	 * 
	 */
	private static final long serialVersionUID = -2517789944616741424L;
	//Visual Components
      public com.salmonllc.html.HtmlText _buscarCAP1;
      public com.salmonllc.html.HtmlText _configuracionCAP4;
      public com.salmonllc.html.HtmlText _configuracionTXT4;
      public com.salmonllc.html.HtmlText _descripcionServicioCAP11;
      public com.salmonllc.html.HtmlText _descripcionServicioTXT11;
      public com.salmonllc.html.HtmlText _destinatarioCAP5;
      public com.salmonllc.html.HtmlText _destinatarioTXT5;
      public com.salmonllc.html.HtmlText _servicioCAP2;
      public com.salmonllc.html.HtmlText _servicioTXT2;
      public com.salmonllc.html.HtmlText _solicitadoCAP7;
      public com.salmonllc.html.HtmlText _solicitadoTXT7;
      public com.salmonllc.html.HtmlText _ticketCAP3;
      public com.salmonllc.html.HtmlText _ticketTXT3;
      public com.salmonllc.html.HtmlText _tiempoProveedorCAP10;
      public com.salmonllc.html.HtmlText _tiempoProveedorTXT10;
      public com.salmonllc.html.HtmlText _tiempoSTCAP9;
      public com.salmonllc.html.HtmlText _tiempoSwitchTXT9;
      public com.salmonllc.html.HtmlText _tiempoTotalCAP8;
      public com.salmonllc.html.HtmlText _tiempoTotalTXT8;
      public com.salmonllc.html.HtmlText _tipoCAP6;
      public com.salmonllc.html.HtmlText _tipoTXT6;
      public com.salmonllc.html.HtmlTextEdit _buscarTE1;
      public com.salmonllc.jsp.JspBox _box1;
      public com.salmonllc.jsp.JspBox _box2;
      public com.salmonllc.jsp.JspDataTable _datatable1;
      public com.salmonllc.jsp.JspDetailFormDisplayBox _detailformdisplaybox1;
      public com.salmonllc.jsp.JspListFormDisplayBox _listformdisplaybox1;
      public com.salmonllc.jsp.JspSearchFormDisplayBox _searchformdisplaybox1;
      public com.salmonllc.jsp.JspTable _table2;
      public com.salmonllc.jsp.JspLink _lnkBack;

      private int v_servicio_distribuido_id = -2;

//DataSources
      public com.salmonllc.sql.QBEBuilder _dsQBE;
      public switchTransaccional.models.InformeLogView _dsLog;

      

@Override
	public void initialize() throws Exception {
	
		_lnkBack.setHref("javascript:window.history.back()");
		_lnkBack.setTitle("Regresar");
		_detailformdisplaybox1.add(_lnkBack, JspLink.TYPE_COMP);
		super.initialize();
	}



@Override
public void pageRequested(PageEvent p) {
	// verifico parámetros y seteo criterio de búsqueda
	// si la página es requerida por si misma no hago nada
	if (!isReferredByCurrentPage()) {
		int tmp_servicio_distribuido_id = getIntParameter("servicio_distribuido_id",-1);
		
		if (tmp_servicio_distribuido_id != -1) {
			// verifica si cambión el contexto
			if (tmp_servicio_distribuido_id != v_servicio_distribuido_id) {
				// cambió contexto, actualizo información
				v_servicio_distribuido_id = tmp_servicio_distribuido_id;
				_dsLog.setCriteria("informe_log.servicio_distribuido_id = "
								+ Integer.toString(v_servicio_distribuido_id));
				try {
					_dsLog.retrieve();
					_dsLog.gotoFirst();
				} catch (SQLException e) {
					displayErrorMessage(e.getMessage());
					e.printStackTrace();
				} catch (DataStoreException e) {
					displayErrorMessage(e.getMessage());
					e.printStackTrace();
				}
				
			}
		} else {

			_dsLog.reset();
			_dsLog.setCriteria(null);
			
			try {
				_dsLog.retrieve();
				_dsLog.gotoFirst();
			} catch (SQLException e) {
				displayErrorMessage(e.getMessage());
				e.printStackTrace();
			} catch (DataStoreException e) {
				displayErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}
	super.pageSubmitted(p);
}

}
