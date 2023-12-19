function mostrarFormulario(formId) {
    // Ocultar todos los formularios
    var containers = document.querySelectorAll('.form-container');
    containers.forEach(function(container) {
        container.style.display = 'none';
    });

    // Obtener el contenedor
    var container = document.getElementById(formId);

    // Realizar una solicitud AJAX solo si el formulario no está ya cargado o si es diferente
    var currentContent = container.innerHTML.trim();
    if (currentContent === '' || currentContent.indexOf(formId) === -1) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                container.innerHTML = xhr.responseText;
            }
        };
        xhr.open("GET", "/Practica3/mvc/view/" + formId + "View.jsp", true);
        xhr.send();
    }

    // Mostrar el formulario seleccionado
    container.style.display = 'block';
}
