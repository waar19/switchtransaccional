<%@ taglib uri="/WEB-INF/taglib.tld" prefix="salmon"%>
<%@ page errorPage="ErrorPage.jsp"
   extends="com.salmonllc.jsp.JspServlet"%>
<salmon:page
   controller="switchTransaccional.controllers.InformeLogController" />
<jsp:include page="templateBefore.jsp" flush="true"></jsp:include>
<salmon:form name="PageForm">
   <%@include file="message.jsp"%>
   </td>
   <!-- ********************************************************************************************* -->
   <!-- Agregar definición de DataSource aquí -->
   <salmon:datasource name="dsQBE" type="QBE">
      <salmon:qbecriteria name="buscar" type="complex" columns="*" />
   </salmon:datasource>
   <salmon:datasource name="dsLog" type="MODEL"
      model="switchTransaccional.models.InformeLogView"
      autoretrieve="Never">
   </salmon:datasource>
   <!-- ********************************************************************************************* -->
   <!-- Agregar código de la página aquí -->
   <!-- ********************************************************************************************* -->
   <salmon:box name="box1" width="100%">
      <salmon:table name="table2" width="100%" border="0">
         <salmon:tr>
            <salmon:td valign="Top">
               <salmon:searchformdisplaybox name="searchformdisplaybox1"
                  caption="Log de Servicios del Switch Transaccional"
                  qbebuilder="dsQBE" addbuttonvisible="false">
                  <table width="100%">
                     <tr>
                        <td><salmon:text name="buscarCAP1"
                           text="Buscar" font="ColumnCaptionFont" /></td>
                        <td><salmon:input type="text"
                           name="buscarTE1" size="60" maxlength="255"
                           datasource="dsQBE:buscar"></salmon:input></td>
                     </tr>
                  </table>
               </salmon:searchformdisplaybox>
            </salmon:td>
            <salmon:td valign="top">
               <salmon:detailformdisplaybox name="detailformdisplaybox1"
                  caption="Detalle de la Transacción" datasource="dsLog"
                  listformdisplaybox="listformdisplaybox1"
                  savebuttonvisible="false" addbuttonvisible="false"
                  deletebuttonvisible="false"
                  cancelbuttonvisible="false">
                  <table width="100%">
                     <tr>
                        <td><salmon:text
                           name="descripcionServicioCAP11"
                           text="Descripción Servicio"
                           font="TableHeadingFont" /></td>
                        <td><salmon:text
                           name="descripcionServicioTXT11"
                           text="Goes Here" font="DefaultFont"
                           datasource="dsLog:informe_log.descripcion_servicio" />
                        </td>
                        <td><salmon:text name="configuracionCAP4"
                           text="Configuración" font="TableHeadingFont" />
                        </td>
                        <td><salmon:text name="configuracionTXT4"
                           text="Goes Here" font="DefaultFont"
                           datasource="dsLog:informe_log.configuracion" />
                        </td>
                     </tr>
                  </table>
                  <table width="100%">
                     <tr>
                        <td><salmon:text name="destinatarioCAP5"
                           text="Destinatario" font="TableHeadingFont" />
                        </td>
                        <td><salmon:text name="destinatarioTXT5"
                           text="Goes Here" font="DefaultFont"
                           datasource="dsLog:informe_log.destinatario" />
                        </td>
                     </tr>
                  </table>
               </salmon:detailformdisplaybox>
            </salmon:td>
         </salmon:tr>
      </salmon:table>
   </salmon:box>
   <salmon:box name="box2" width="100%">
      <salmon:listformdisplaybox name="listformdisplaybox1"
         mode="Display_single_page" caption="Registro de Transacciones"
         width="100%" datasource="dsLog"
         searchformdisplaybox="searchformdisplaybox1"
         detailformdisplaybox="detailformdisplaybox1">
         <salmon:datatable name="datatable1" width="100%"
            rowsperpage="20" datasource="dsLog">
            <salmon:datatableheader>
               <salmon:tr>
                  <salmon:td nowrap="true">
                     <salmon:text name="servicioCAP2" text="Servicio"
                        font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="ticketCAP3" text="Ticket"
                        font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="tipoCAP6" text="Tipo"
                        font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="solicitadoCAP7"
                        text="Solicitado" font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="tiempoTotalCAP8"
                        text="Tiempo total" font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="tiempoSTCAP9"
                        text="Tiempo Switch" font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="tiempoProveedorCAP10"
                        text="Tiempo Proveedor" font="TableHeadingFont" />
                  </salmon:td>
               </salmon:tr>
            </salmon:datatableheader>
            <salmon:datatablerows>
               <salmon:tr>
                  <salmon:td nowrap="true">
                     <salmon:text name="servicioTXT2" text="Goes Here"
                        font="DefaultFont"
                        datasource="dsLog:informe_log.servicio" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="ticketTXT3" text="Goes Here"
                        font="DefaultFont" displayformat="####0"
                        datasource="dsLog:informe_log.ticket_id" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="tipoTXT6" text="Goes Here"
                        font="DefaultFont"
                        datasource="dsLog:informe_log.tipo" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="solicitadoTXT7" text="Goes Here"
                        font="DefaultFont"
                        displayformat="dd/MM/yyyy hh:mm:ss"
                        datasource="dsLog:informe_log.solicitado" />
                  </salmon:td>
                  <salmon:td align="right">
                     <salmon:text name="tiempoTotalTXT8"
                        text="Goes Here" font="DefaultFont"
                        displayformat="###0"
                        datasource="dsLog:informe_log.tiempo_total" />
                  </salmon:td>
                  <salmon:td align="right">
                     <salmon:text name="tiempoSwitchTXT9"
                        text="Goes Here" font="DefaultFont"
                        displayformat="###0"
                        datasource="dsLog:informe_log.tiempo_st" />
                  </salmon:td>
                  <salmon:td align="right">
                     <salmon:text name="tiempoProveedorTXT10"
                        text="Goes Here" font="DefaultFont"
                        displayformat="###0"
                        datasource="dsLog:informe_log.tiempo_proveedor" />
                  </salmon:td>
               </salmon:tr>
            </salmon:datatablerows>
         </salmon:datatable>
      </salmon:listformdisplaybox>
   </salmon:box>
   <!-- Fin de código agregado -->
</salmon:form>
<jsp:include page="templateAfter.jsp" flush="true"></jsp:include>
<salmon:endpage />
