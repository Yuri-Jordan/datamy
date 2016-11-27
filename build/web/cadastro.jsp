<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <title>DataMy</title>
</head>
<body>
    
    <script>
        function validar() {
         
          var usuario = document.getElementById('cmpLogin').value;
          
          var senha= document.getElementById('cmpSenha').value;
            
          var senha2= document.getElementById('cmpSenha2').value;    
          
           if(usuario==0 || senha==0 || senha2==0 ) {
               window.alert("Dados n�o informados."); 
               
          }else if(senha != senha2){
               window.alert("A senha tem que ser id�nticas."); 
          }
		  
        }
    
    </script>

<br><br><br><br><br><br><br><br><br>
    
    <!--T�tulo do Datamy --> 
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-sm-offset-4">
			<h3 class="text-center text-primary">
				DataMy Cadastro
			</h3>
            </div>
        </div>
    </div>
<div id="blocoLogin" class="container">

<!--formul�rio do login -->
<form action="/cadastrar" method="post">
<!--col-sm-offset-6 deixa o conte�do na outra div -->    
  <div class="row">
    <div class="col-md-4 col-sm-offset-4">
      <div class="input-group" >
	    <label class="input-group input-group-addon"><b class="glyphicon glyphicon-user"></b></label>
	    <input autofocus type="text" class="form-control" id="cmpLogin" placeholder="Login ou email">
      </div>
	</div>
  </div>
  
  <!--formul�rio da senha -->    
  <br>
  <div class="row">
    <div class="col-md-4 col-sm-offset-4">
      <div class="input-group">
	    <label class="input-group input-group-addon"><b class="glyphicon glyphicon-log-in"></b></label>
	    <input type="password" class="form-control" id="cmpSenha" placeholder="Senha">
      </div>
	</div>
  </div>
    
   <!--formul�rio da cofirma��o da senha -->    
  <br>
  <div class="row">
    <div class="col-md-4 col-sm-offset-4">
      <div class="input-group">
	    <label class="input-group input-group-addon"><b class="glyphicon glyphicon-log-in"></b></label>
	    <input type="password" class="form-control" id="cmpSenha2" placeholder="Confirme sua Senha">
      </div>
	</div>
  </div> 
    

  <!--bot�o de login -->
    <br>
  <div class="row">
    <div class="col-md-4 col-sm-offset-4 text-right">
	  <button class="btn btn-default" onclick="validar()" id="btnLogin">Cadastrar</button>
	</div>
  </div>
</form>
</div>

</body>
</html>