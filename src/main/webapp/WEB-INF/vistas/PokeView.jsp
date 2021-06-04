<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrapValidator.css" />
<title>Pokemón API - Henry Castell</title>
</head>
<body>

	<div class="container">
		<h3>Lista Pokemon</h3>
		<div class="col-md-23">

			<div class="row" style="height: 70px">
				<div class="col-md-2">
					<input class="form-control" id="id_txt_filtro" name="filtro"
						placeholder="Ingrese el nombre" type="text" maxlength="30" />
				</div>
				<div class="col-md-2">
					<button type="button" class="btn btn-primary" id="id_btn_filtrar"
						style="width: 150px">FILTRA</button>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="content">

						<table id="id_table" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th style="width: 25%">Nombre</th>
									<th style="width: 8%">Informacion</th>
									<th style="width: 8%">Cadena Evolutiva</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		
		


	<script type="text/javascript">
        $(document).ready(function() {
            $("#consultaPokeDex").DataTable();
        });
    </script>
    
	<script type="text/javascript">
		$("#id_btn_filtrar").click(function() {
			var fil = $("#id_txt_filtro").val();
			$.getJSON("consultaPokeDex", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista);
			});
		});

		function agregarGrilla(lista) {
			$('#id_table').DataTable().clear();
			$('#id_table').DataTable().destroy();
			$('#id_table')
					.DataTable(
							{
								data : lista,
								searching : false,
								ordering : true,
								processing : true,
								pageLength : 5,
								lengthChange : false,
								columns : [
										{
											data : "name"
										},
										{
											data : "url"
										},
										{data: function(row, type, val, meta){
											var salida='<img src='+ row.img +' >';
											return salida;
										},className:'text-center'},
										/*{data: function(row, type, val, meta){
											var salida='<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''+ url +'\')">Editar</button>';
											return salida;
										},className:'text-center'},*/
										  ]
							});
		}



		function editar(id,nombre,numHombres,numMujeres,edadMaxima, edadMinima,sede, idDeporte){	
			$('#id_ID').val(id);
			$('#id_act_nombre').val(nombre);
			$('#id_act_num_hombres').val(numHombres);
			$('#id_act_num_mujeres').val(numMujeres);
			$('#id_act_minima').val(edadMinima);
			$('#id_act_maxima').val(edadMinima);
			$('#id_act_deporte').val(idDeporte);
			$('#id_act_sede').val(sede);
			$('#id_div_modal_actualiza').modal("show");
		}

		
	</script>

	

</body>
</html>
