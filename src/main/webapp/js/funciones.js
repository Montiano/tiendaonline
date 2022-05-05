function Eliminado() {
	//swal("Good job!", "You clicked the button!", "success");
	alert("¡Producto eliminado correctamente!");
}

/*$(document).ready(function() {
	$("tr #Cantidad").click(function(){
		var idProducto=$(this).parent().find("#idPro").val();
		var cantidad=$(this).parent.find("#Cantidad").val();
		var url="Controlador?accion=ActualizarCantidad";
		$.ajax({
			type: 'POST',
			url: url,
			data: "idProducto="+idProducto+"&Cantidad="+cantidad,
			success: function(data, textStatus, jqXHR) {
				location.href="Controlador?accion=Carrito";
			}
		});
	});
});*/

/*$(document).ready(function() {
	$("tr #btnDelete").click(function() {
		var idProducto = $(this).parent().find("#idProducto").val();
		swal({
			title: "Are you sure?",
			text: "Once deleted, you will not be able to recover this imaginary file!",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		})
			.then((willDelete) => {
				if (willDelete) {
					eliminar(idProducto);
					swal("Poof! Your imaginary file has been deleted!", {
						icon: "success",
					}).then((willDelete)=>{
						if(willDelete){
							parent.location.href="Controlador?accion=Carrito";
						}
					});
				} else {
					swal("Your imaginary file is safe!");
				}
			});
		
	});
	function eliminar(idProducto) {
		var url = "Controlador?accion=Delete";
		$.ajax({
			type: 'POST',
			url: url,
			data: "idProducto=" + idProducto,
			success: function(data, textStatus, jqXHR) {
				alert("Registro eliminado!");
			}
		});
	}
});*/

