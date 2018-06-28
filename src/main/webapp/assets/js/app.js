$(function () {
	$('[data-toggle="tooltip"]').tooltip();
	$('[data-tt="tooltip"]').tooltip();
	
	$(document).click(function (event) {
	    var clickover = $(event.target);
	    var $navbar = $(".navbar-collapse");               
	    var _opened = $navbar.hasClass("show");
	    if (_opened === true && !clickover.hasClass("navbar-toggle")) {
	        $navbar.collapse('hide');
	    }
	});
	
	$(".link-inativacao").on("click", function(event) {
		var url = $(this).attr("href");
		event.preventDefault();
		bootbox.confirm({
			message: "Deseja realmente inativar?",		
			buttons: {
				confirm: {
					label: "Inativar",
					className: "btn btn-sm btn-primary btn-amber"
				},
				cancel: {
					label: "Cancelar",
					className: "btn btn-sm btn-default btn-blue-grey"					
				}
			},
			callback: function(result) {
				if(result) {
					window.location = url;
				}
			}
		})
	});

	$(".link-ativacao").on("click", function(event) {
		var url = $(this).attr("href");
		event.preventDefault();
		bootbox.confirm({
			message: "Deseja realmente ativar?",		
			buttons: {
				confirm: {
					label: "Ativar",
					className: "btn btn-sm btn-primary btn-dark-green"
				},
				cancel: {
					label: "Cancelar",
					className: "btn btn-sm btn-default btn-blue-grey"					
				}
			},
			callback: function(result) {
				if(result) {
					window.location = url;
				}
			}
		})
	});
	
	$(".link-remocao").on("click", function(event) {
		var url = $(this).attr("href");
		event.preventDefault();
		bootbox.confirm({
			message: "Deseja realmente remover?",		
			buttons: {
				confirm: {
					label: "Remover",
					className: "btn btn-sm btn-danger"
				},
				cancel: {
					label: "Cancelar",
					className: "btn btn-sm btn-default btn-blue-grey"					
				}
			},
			callback: function(result) {
				if(result) {
					window.location = url;
				}
			}
		})
	});
	
	$(".form-wait-dialog").submit(function(){
		bootbox.dialog({ 
			closeButton: false,
			size: 'large',
			title: '<i class="fa fa-clock"></i> A operação está sendo executada',
			message: '<div class="progress">' +
					 	 '<div class="progress-bar bg-success progress-bar-striped active"' +
					 	 'role="progressbar" aria-valuenow="100" aria-valuemin="0" ' +
					 	 'aria-valuemax="100" style="width: 100%">' +
					 		 '<span>Aguarde<span class="dotdotdot"></span></span>' + 
					 	 '</div>' +
					 '</div>'
		});
	});
	
})
