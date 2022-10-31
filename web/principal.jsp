<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Control Calzados</title>
    </head>
    <body>
        <%-- ---------------------------------- --%>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
      <%-- <a class="navbar-brand" href="#">Navbar</a> --%>
<%--      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>  --%>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="ControladorGestionarModelos?menu=modelos&accion=Listar" target="myFrame">Modelos</a> <%-- class="nav-link" --%>
          </li>
          <li class="nav-item">
            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador1?menu=colores" target="myFrame">Colores</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"></a>
          </li>
          <div class="dropdown">
          <button class="btn btn-secondary dropdown-toggle" type="button" id="opButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            OP  
          </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="Controlador1?menu=OP" target="myFrame">Listar OPs</a>
            <a class="dropdown-item" href="#">Iniciar OP</a>
            <a class="dropdown-item" href="Controlador1?menu=semaforo" target="myFrame">Consultar Semáforo</a>
    
          </div>
</div>
        </ul>
        <%-- ------------------------------------------------------------------- --%>
      <div class="dropdown">
        <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ${usuario.getUsuario()}
        </button>
        <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#">
                <img src="img/user.png" alt="60" width="60"/>
            </a>
          <a class="dropdown-item" href="#">usuario</a>
          <a class="dropdown-item" href="#">correo</a>
          
          <div class="dropdown-divider"></div>
          <form action="ControladorAutenticarUsuario" method="POST">
              <button name="accion" value="Salir" class="dropdown-item" href="#" >Salir</button>
          </form>
          
        </div>
      </div>
        
        
        <%-- ------------------------------------------------------------------- --%>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
        <%-- ---------------------------------- --%>
    <div class="m-4" style="height: 550px;">
        <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
    </div>
        <%-- ---------------------------------- --%>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
