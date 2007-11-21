<%@ taglib uri="/WEB-INF/taglib.tld" prefix="salmon"%>
<%@ page errorPage="ErrorPage.jsp"
   extends="com.salmonllc.jsp.JspServlet"%>
<salmon:page
   controller="switchTransaccional.controllers.AbmcConfiguracionServicioController" />
<jsp:include page="templateBefore.jsp" flush="true"></jsp:include>
<salmon:form name="PageForm">
   <%@include file="message.jsp"%>
   </td>
   <!-- ********************************************************************************************* -->
   <!-- Agregar definición de DataSource aquí -->
   <salmon:datasource name="dsServicio" type="MODEL"
      model="switchTransaccional.models.ServicioDistribuidoModel"
      dbprofile="switchTransaccional" autoretrieve="Never">
   </salmon:datasource>
   <salmon:datasource name="dsConf" type="MODEL"
      model="switchTransaccional.models.ConfiguracionServicioModel"
      dbprofile="switchTransaccional" autoretrieve="Never">
   </salmon:datasource>
   <!-- ********************************************************************************************* -->
   <!-- Agregar código de la página aquí -->
   <!-- ********************************************************************************************* -->
   <salmon:box name="box1" width="100%">
      <salmon:displaybox name="displaybox1" width="100%"
         datasource="dsServicio" caption="Servicio">
         <salmon:displayboxheader>
            <salmon:a href="javascript:window.history.back()"
               name="lnkBack">
               <salmon:text name="back" text="Regresar"
                  font="ColumnCaptionFont" />
            </salmon:a>
         </salmon:displayboxheader>
         <salmon:displayboxcontents>
            <table width="100%">
               <tr>
                  <td><salmon:text name="idServicioCAP1" text="ID"
                     font="ColumnCaptionFont" />
                  <td>
                  <td><salmon:text name="idServicioTE1"
                     text="id goes here" font="ColumnCaptionFont"
                     datasource="dsServicio:servicio_distribuido.servicio_distribuido_id" />
                  </td>
                  <td><salmon:text name="nombreServicioCAP2"
                     text="Nombre" font="ColumnCaptionFont" />
                  <td>
                  <td><salmon:text name="nombreServicioTE2"
                     text="nombre goes here" font="ColumnCaptionFont"
                     datasource="dsServicio:servicio_distribuido.nombre" />
                  </td>
                  <td><salmon:text name="descripcionServicioTE3"
                     text="descripcion goes here"
                     font="ColumnCaptionFont"
                     datasource="dsServicio:servicio_distribuido.descripcion" />
                  </td>
               <tr>
            </table>
         </salmon:displayboxcontents>
      </salmon:displaybox>
   </salmon:box>
   <salmon:box name="box2" width="100%">
      <salmon:displaybox name="displaybox2" width="100%"
         caption="Configura Comportamiento del Servicio">
         <salmon:displayboxheader>
            <salmon:input name="agregarBUT2" type="submit"
               value="Agregar" accesskey="A"></salmon:input>
            <salmon:input name="eliminarBUT3" type="submit"
               value="Eliminar" accesskey="E"></salmon:input>
            <salmon:input name="actualizarBUT4" type="submit"
               value="Grabar" accesskey="G"></salmon:input>
            <salmon:input name="cancelarBUT5" type="submit"
               value="Cancelar" accesskey="C"></salmon:input>
         </salmon:displayboxheader>
         <salmon:displayboxcontents>
            <salmon:datatable name="datatable1" width="100%"
               datasource="dsConf" rowsperpage="5">
               <salmon:datatableheader>
                  <salmon:tr>
                     <salmon:td>
                        <salmon:text name="selCAP3" text="-X-"
                           font="TableHeadingFont" />
                     </salmon:td>
                     <salmon:td>
                        <salmon:text name="configuracionCAP4"
                           text="Configuracion" font="TableHeadingFont" />
                     </salmon:td>
                     <salmon:td>
                        <salmon:text name="namespaceUriCAP6"
                           text="Namespace URI" font="TableHeadingFont" />
                     </salmon:td>
                     <salmon:td>
                        <salmon:text name="nombreServicioCAP7" text="Servicio"
                           font="TableHeadingFont" />
                     </salmon:td>
                     <salmon:td>
                        <salmon:text name="nombrePuertoCAP8" text="Puerto"
                           font="TableHeadingFont" />
                     </salmon:td>
                     <salmon:td>
                        <salmon:text name="endpointAddressCAP9" text="Endpoint Address"
                           font="TableHeadingFont" />
                     </salmon:td>
                  </salmon:tr>
               </salmon:datatableheader>
               <salmon:datatablerows>
                  <salmon:tr>
                     <salmon:td>
                        <salmon:input type="checkbox" name="seleccion"
                           checkedtruevalue="1"></salmon:input>
                     </salmon:td>
                     <salmon:td>
                        <salmon:lookup
                           browseimage="%ImageDirectory/Browse.gif"
                           lookupurl="%LkpConfiguracionesServicios"
                           name="ConfiguracionTE4" size="6"
                           maxlength="15"
                           descriptiondatasource="dsConf:configuracion.nombre"
                           datasource="dsConf:configuracion_servicio.configuracion_id"
                           popupheight="450" popupwidth="500"
                           usepopup="true" showdescription="true"></salmon:lookup>
                        <salmon:text name="guionCAPTE4" text=" - "/>
                        <salmon:text name="descripcionConfTE4"
                           text="descripcion goes here"
                           datasource="dsConf:configuracion.descripcion" />
                     </salmon:td>
                     <salmon:td>
                        <salmon:input name="namespaceUriTE6" type="text"
                           size="40" maxlength="255" datasource="dsConf:configuracion_servicio.namespace_URI">
                        </salmon:input>
                     </salmon:td>
                     <salmon:td>
                        <salmon:input name="nombreServicioTE7" type="text"
                           size="20" maxlength="255" datasource="dsConf:configuracion_servicio.nombre_servicio">
                        </salmon:input>
                     </salmon:td>
                     <salmon:td>
                        <salmon:input name="nombrePuertoTE8" type="text"
                           size="20" maxlength="255" datasource="dsConf:configuracion_servicio.nombre_puerto">
                        </salmon:input>
                     </salmon:td>
                     <salmon:td>
                        <salmon:input name="endpointAddressTE8" type="text"
                           size="40" maxlength="255" datasource="dsConf:configuracion_servicio.endpoint_address">
                        </salmon:input>
                     </salmon:td>
                  </salmon:tr>
               </salmon:datatablerows>
            </salmon:datatable>
         </salmon:displayboxcontents>
      </salmon:displaybox>
   </salmon:box>
   <!-- Fin de código agregado -->
</salmon:form>
<jsp:include page="templateAfter.jsp" flush="true"></jsp:include>
<salmon:endpage />
