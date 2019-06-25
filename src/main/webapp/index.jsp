<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="./css/bootstrap.min.css">

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="./js/jquery-3.4.1.slim.min.js"></script>
  <script src="./js/popper.min.js"></script>
  <script src="./js/bootstrap.min.js"></script>

  <title>Simulador XJ</title>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Simulador XJ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            Dropdown
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>


  <div class="container-fluid">

    <form>
      <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label col-form-label-sm">Aplicacion</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="staticEmail"
            placeholder="Nombre de la aplicacion">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Codificacion</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword"
            placeholder="Default UTF-8">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Tipo de busqueda</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword" placeholder="Password">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Condicion de busqueda</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword" placeholder="Password">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Valor esperado</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword" placeholder="Password">
        </div>
      </div>
      <div class="form-group row">
        <div class="col-sm-10">
          <button type="submit" class="btn btn-primary">Crear</button>
        </div>
      </div>
    </form>

  </div>



  <!-- OTRA PANTALLA -->

  <div class="container-fluid">

    <form>
      <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label col-form-label-sm">Nombre de mensajeria</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="staticEmail"
            placeholder="Nombre de la aplicacion">
        </div>
      </div>
      <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label col-form-label-sm">Descripcion</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="staticEmail"
            placeholder="Nombre de la aplicacion">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Codificacion RQ</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword"
            placeholder="Default UTF-8">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Tipo de busqueda</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword" placeholder="Password">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Condicion de busqueda</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword" placeholder="Password">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Valor esperado</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword" placeholder="Password">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Headers</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword"
            placeholder="Default UTF-8">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label col-form-label-sm">Codigo de respuesta</label>
        <div class="col-sm-9">
          <input type="text" class="form-control-plaintext form-control-sm" id="inputPassword"
            placeholder="Por defecto 200">
        </div>
      </div>
      <div class="form-group row">
        <label for="txtMensaje" class="col-sm-2 col-form-label col-form-label-sm">Mensajeria de respuesta</label>
      </div>
      <div class="form-group row">
        <div class="col-sm-12">
          <textarea class="form-control-plaintext" id="txtMensaje" rows="3" placeholder="Password"></textarea>
        </div>
      </div>
      <div class="form-group row">
        <div class="col-sm-10">
          <button type="submit" class="btn btn-primary">Crear</button>
        </div>
      </div>
    </form>

  </div>


</body>

</html>