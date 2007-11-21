<%@ taglib uri="/WEB-INF/taglib.tld" prefix="salmon"%>
<%@ page errorPage="ErrorPage.jsp"
   extends="com.salmonllc.jsp.JspServlet"%>
<salmon:page
   controller="switchTransaccional.controllers.AbmcServicioDistribuidoController" />
<jsp:include page="templateBefore.jsp" flush="true"></jsp:include>
<salmon:form name="PageForm">
   <%@include file="message.jsp"%>
   </td>
   <!-- ********************************************************************************************* -->
   <!-- Agregar definición de DataSource aquí -->
   <salmon:datasource name="dsQBE" type="QBE">
      <salmon:qbecriteria name="buscar" type="complex" columns="*" />
   </salmon:datasource>
   <salmon:datasource name="dsServicio" type="MODEL"
      model="switchTransaccional.models.ServicioDistribuidoModel"
      dbprofile="switchTransaccional" autoretrieve="Never">
   </salmon:datasource>
   <salmon:datasource name="dsAtributos" type="MODEL"
      model="infraestructura.models.AtributosEntidadModel"
      dbprofile="infraestructura" autoretrieve="Never">
   </salmon:datasource>
   <!-- ********************************************************************************************* -->
   <!-- Agregar código de la página aquí -->
   <!-- ********************************************************************************************* -->
   <salmon:box name="box1" width="100%">
      <salmon:table name="table2" width="100%" border="0">
         <salmon:tr>
            <salmon:td valign="Top">
               <salmon:searchformdisplaybox name="searchformdisplaybox1"
                  caption="Registro de Servicios Distribuidos"
                  qbebuilder="dsQBE">
                  <table width="100%">
                     <tr>
                        <td><salmon:text name="buscarCAP1"
                           text="Buscar" font="ColumnCaptionFont" /></td>
                        <td><salmon:input type="text"
                           name="buscarTE1" size="30" maxlength="90"
                           datasource="dsQBE:buscar"></salmon:input></td>
                     </tr>
                  </table>
               </salmon:searchformdisplaybox>
            </salmon:td>
            <salmon:td valign="Top">
               <salmon:detailformdisplaybox name="detailformdisplaybox1"
                  caption="Editar Servicio Distribuido" width="100%"
                  datasource="dsServicio"
                  listformdisplaybox="listformdisplaybox1">
                  <table width="100%">
                     <tr>
                        <td><salmon:text name="nombreCAP2"
                           text="Nombre" font="ColumnCaptionFont" /></td>
                        <td><salmon:input type="text"
                           name="nombreTE2" size="30" maxlength="90"
                           datasource="dsServicio:servicio_distribuido.nombre"></salmon:input></td>
                        <td><salmon:text name="vigenciaCAP3"
                           text="Vigencia" font="ColumnCaptionFont" /></td>
                        <td><salmon:input name="desdeTE3"
                           type="text" size="10" maxlength="10"
                           displayformat="dd/MM/yyyy"
                           datasource="dsServicio:servicio_distribuido.vigencia_desde"></salmon:input>
                        <salmon:input name="hastaTE4" type="text"
                           size="10" maxlength="10"
                           displayformat="dd/MM/yyyy"
                           datasource="dsServicio:servicio_distribuido.vigencia_hasta"></salmon:input></td>
                        <td><salmon:text name="IDCAP8" text="ID"
                           font="ColumnCaptionFont" /></td>
                        <td><salmon:text name="idTE9"
                           text="id goes here"
                           datasource="dsServicio:servicio_distribuido.servicio_distribuido_id" /></td>
                     </tr>
                     <tr>
                        <td><salmon:text name="descripcionCAP4"
                           text="Descripción" font="ColumnCaptionFont" /></td>
                        <td><salmon:input type="text"
                           name="descripcionTE5" size="30"
                           maxlength="255"
                           datasource="dsServicio:servicio_distribuido.descripcion"></salmon:input></td>
                        <td><salmon:text name="observacionesCAP5"
                           text="Obs." font="ColumnCaptionFont" /></td>
                        <td><salmon:input type="text"
                           name="observacionesTE6" size="40"
                           maxlength="255"
                           datasource="dsServicio:servicio_distribuido.observaciones"></salmon:input></td>
                        <td><salmon:text name="activoCAP9"
                           text="Activo" font="ColumnCaptionFont" /></td>
                        <td><salmon:text name="activoTE10"
                           text="activo goes here"
                           datasource="dsServicio:servicio_distribuido.activo" /></td>
                     </tr>
                     <tr>
                        <td><salmon:text name="tipoDatoCAP6"
                           text="Tipo Validación"
                           font="ColumnCaptionFont" /></td>
                        <td><salmon:input name="tipoValidacionTE7"
                           type="select"
                           datasource="dsServicio:servicio_distribuido.tipo_validacion_xml">
                           <salmon:option display="DTD" key="DTD"></salmon:option>
                           <salmon:option display="XSD" key="XSD"></salmon:option>
                        </salmon:input></td>
                        <td><salmon:text name="codigoServicioCAP7"
                           text="Código" font="ColumnCaptionFont" /></td>
                        <td><salmon:input type="text"
                           name="codigoServicioTE7" size="10" maxlength="15"
                           datasource="dsServicio:servicio_distribuido.codigo_servicio"></salmon:input></td>
                     </tr>
                  </table>
                  <p><salmon:text name="validacionTextoCAP7"
                     text="Texto Validación" font="ColumnCaptionFont" />
                  <p><salmon:input name="validacionTextoTE8"
                     type="textarea" cols="140" rows="5"
                     datasource="dsServicio:servicio_distribuido.validacion"></salmon:input>
               </salmon:detailformdisplaybox>
            </salmon:td>
         </salmon:tr>
      </salmon:table>
   </salmon:box>
   <salmon:box name="box2" width="100%">
      <salmon:listformdisplaybox name="listformdisplaybox1"
         mode="Display_single_page" caption="Servicios Distribuidos"
         width="100%" datasource="dsServicio" addbuttonvisible="True"
         detailformdisplaybox="detailformdisplaybox1"
         searchformdisplaybox="searchformdisplaybox1">
         <salmon:datatable name="datatable1" width="100%"
            datasource="dsServicio" rowsperpage="5">
            <salmon:datatableheader>
               <salmon:tr>
                  <salmon:td>
                     <salmon:text name="nombreCAP10" text="Nombre"
                        font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="descripcionCAP11"
                        text="Descripción" font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="desdeCAP12" text="Desde"
                        font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="hastaCAP13" text="hasta"
                        font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="activoCAP14" text="Activo"
                        font="TableHeadingFont" />
                  </salmon:td>
               </salmon:tr>
            </salmon:datatableheader>
            <salmon:datatablerows>
               <salmon:tr>
                  <salmon:td>
                     <salmon:text name="nombreTXT1"
                        text="nombre Goes Here" font="DefaultFont"
                        datasource="dsServicio:servicio_distribuido.nombre" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="descripcionTXT2"
                        text="descripcion Goes Here" font="DefaultFont"
                        datasource="dsServicio:servicio_distribuido.descripcion" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="desdeTXT3"
                        text="Desde Goes Here"
                        displayformat="dd/MM/yyyy" font="DefaultFont"
                        datasource="dsServicio:servicio_distribuido.vigencia_desde" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="hastaTXT4"
                        text="Hasta Goes Here"
                        displayformat="dd/MM/yyyy" font="DefaultFont"
                        datasource="dsServicio:servicio_distribuido.vigencia_hasta" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="activoTXT5"
                        text="activo Goes Here" font="DefaultFont"
                        datasource="dsServicio:servicio_distribuido.activo" />
                  </salmon:td>
               </salmon:tr>
            </salmon:datatablerows>
         </salmon:datatable>
      </salmon:listformdisplaybox>
   </salmon:box>
   <salmon:box name="box3" width="100%">
      <salmon:listformdisplaybox name="listformdisplaybox3"
         mode="Display_single_page" caption="Atributos del Servicio"
         width="100%" datasource="dsAtributos" addbuttonvisible="false"
         savebuttonvisible="true">
         <salmon:datatable name="datatable3" width="100%"
            datasource="dsAtributos" rowsperpage="5">
            <salmon:datatableheader>
               <salmon:tr>
                  <salmon:td>
                     <salmon:text name="atributoCAP15" text="Atributo"
                        font="TableHeadingFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:text name="valorCAP16" text="Valor"
                        font="TableHeadingFont" />
                  </salmon:td>
               </salmon:tr>
            </salmon:datatableheader>
            <salmon:datatablerows>
               <salmon:tr>
                  <salmon:td>
                     <salmon:text name="atributoTXT6"
                        text="atributo Goes Here"
                        datasource="dsAtributos:atributos_rol.nombre"
                        font="DefaultFont" />
                  </salmon:td>
                  <salmon:td>
                     <salmon:lookup
                        browseimage="%ImageDirectory/Browse.gif"
                        lookupurl="%LkpValoresAtributos?p_clase_lov="
                        name="valorTE11" size="40" maxlength="255"
                        datasource="dsAtributos:atributos_entidad.valor"
                        popupheight="450" popupwidth="500"
                        usepopup="true" showdescription="true"></salmon:lookup>
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
