/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
      $.ajax({
        url: "/usuario",
        dataType: "json",
        type: "GET",
        success: function (respuesta) {
            console.log(respuesta);
            $("#usuario").html(respuesta.name);
            $(".sinAutenticacion").hide();
            $(".conAutenticacion").show();
        }       
    });
});

function logout(){
    $.post("/logout", function() {
        $("#usuario").html('');
        $(".sinAutenticacion").show();
        $(".conAutenticacion").hide();
    });
    return true;
}
