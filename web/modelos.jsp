<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Gestionar Modelos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="ControladorGestionarModelos?menu=modelos" method="POST">
                        <div class="form-group">
                            <label>SKU:</label>
                            <input type="text" value="${modelo.getSku()}" name="txtSKU" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Denominación:</label>
                            <input type="text"  value="${modelo.getDenominacion()}" name="txtDenominacion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Limite Inferior Reproceso:</label>
                            <input type="text" value="${modelo.getLimiteInferiorReproceso()}" name="txtLIR" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Limite Superior Reproceso:</label>
                            <input type="text" value="${modelo.getLimiteSuperiorReproceso()}" name="txtLSR" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Limite Inferior Observado:</label>
                            <input type="text" value="${modelo.getLimiteInferiorObservado()}" name="txtLIO" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Limite Superior Observado:</label>
                            <input type="text" value="${modelo.getLimiteSuperiorObservado()}" name="txtLSO" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
<%-- ----------------------------------------------------------------------------------- --%>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>SKU</th>
                            <th>Denominación</th>
                            <th>Límite Inferior Reproceso</th>
                            <th>Límite Superior Reproceso</th>
                            <th>Límite Inferior Observado</th>
                            <th>Límite Superior Observado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="md" items="${modelos}">
                            <tr>
                                <td>${md.getSku()}</td>
                                <td>${md.getDenominacion()}</td>
                                <td>${md.getLimiteInferiorReproceso()}</td>
                                <td>${md.getLimiteSuperiorReproceso()}</td>
                                <td>${md.getLimiteInferiorObservado()}</td>
                                <td>${md.getLimiteSuperiorObservado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ControladorGestionarModelos?menu=modelos&accion=Editar&sku=${md.getSku()}"><img src="img/editar.png" alt="15" width="15"/></a> <%-- Editar --%>
                                    <a class="btn btn-danger" href="ControladorGestionarModelos?menu=modelos&accion=Eliminar&sku=${md.getSku()}"><img src="img/eliminar.png" alt="15" width="15"/></a> <%-- Eliminar --%>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
