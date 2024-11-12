async function obtenerPerfilCompleto() {
    const idPaciente = document.getElementById('pacienteId').value;
    const response = await fetch(`/api/paciente/${idPaciente}/perfil-completo`);

    if (response.ok) {
        const perfilCompleto = await response.json();
        mostrarPerfil(perfilCompleto);
    } else {
        alert('Error al cargar el perfil del paciente.');
    }
}

async function obtenerPerfilCompletoPorDocumento() {
    const documentoIdentidad = document.getElementById('pacienteDocumento').value;
    const response = await fetch(`/api/paciente/documento/${documentoIdentidad}/perfil-completo`);

    if (response.ok) {
        const perfilCompleto = await response.json();
        mostrarPerfil(perfilCompleto);
    } else {
        alert('Error al cargar el perfil del paciente.');
    }
}



function mostrarPerfil(perfilCompleto) {
    const perfilDiv = document.getElementById('perfil');
    perfilDiv.innerHTML = `
        <h2>Perfil del Paciente</h2>
        <p><strong>Nombre:</strong> ${perfilCompleto.perfil.nombre} ${perfilCompleto.perfil.apellido}</p>
        <p><strong>Email:</strong> ${perfilCompleto.perfil.email}</p>
        <p><strong>Teléfono:</strong> ${perfilCompleto.perfil.telefono}</p>
        <p><strong>Dirección:</strong> ${perfilCompleto.perfil.direccion}</p>
        <p><strong>Fecha de Nacimiento:</strong> ${new Date(perfilCompleto.perfil.fechaNacimiento).toLocaleDateString()}</p>
        <p><strong>Género:</strong> ${perfilCompleto.perfil.genero}</p>
        <h3>Documentos</h3>
        <ul>${perfilCompleto.documentos.map(doc => `<li>${doc.nombre}</li>`).join('')}</ul>
        <h3>Presupuestos</h3>
        <ul>${perfilCompleto.presupuestos.map(pres => `<li>${pres.descripcion}</li>`).join('')}</ul>
        <h3>Tratamientos</h3>
        <ul>${perfilCompleto.tratamientos.map(trat => `<li>${trat.descripcion}</li>`).join('')}</ul>
    `;
}

// Función para agregar paciente
async function agregarPaciente() {
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const email = document.getElementById('email').value;
    const telefono = document.getElementById('telefono').value;
    const direccion = document.getElementById('direccion').value;
    const fechaNacimiento = document.getElementById('fechaNacimiento').value;
    const genero = document.getElementById('genero').value;
    const origenCliente = document.getElementById('origenCliente').value;
    const fechaCreacion = document.getElementById('fechaCreacion').value;
    const documentoIdentidad = document.getElementById('documentoIdentidad').value;

    const response = await fetch('/api/paciente/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({nombre, apellido, email, telefono, direccion, fechaNacimiento, genero, origenCliente, fechaCreacion, documentoIdentidad})
    });

    if (response.ok) {
        alert('Paciente agregado con éxito');
        listarPacientes();
    } else {
        alert('Error al agregar paciente');
    }
}

async function listarPacientes() {
    const response = await fetch('/api/paciente/listar');
    const pacientes = await response.json();
    const lista = document.getElementById('listaPaciente');
    lista.innerHTML = '';

    pacientes.forEach(paciente => {
        const li = document.createElement('li');
        li.textContent = `${paciente.nombre} ${paciente.apellido} - ${paciente.email}`;
        const eliminarBtn = document.createElement('button');
        eliminarBtn.textContent = 'Eliminar';
        eliminarBtn.onclick = () => eliminarPaciente(paciente.id);
        li.appendChild(eliminarBtn);
        lista.appendChild(li);
    });
}

async function eliminarPaciente(id) {
    const response = await fetch(`/api/paciente/${id}`, { method: 'DELETE' });

    if (response.ok) {
        alert('Paciente eliminado con éxito');
        listarPacientes();
    } else {
        alert('Error al eliminar paciente');
    }
}

// Búsqueda de pacientes
async function buscarPorNombre() {
    const nombre = document.getElementById("nombreBuscar").value;
    const response = await fetch(`/api/paciente/buscarPorNombre?nombre=${nombre}`);
    const pacientes = await response.json();
    mostrarResultados(pacientes);
}

async function buscarPorFechaAlta() {
    const startDate = document.getElementById("startDate").value;
    const endDate = document.getElementById("endDate").value;

    const response = await fetch(`/api/paciente/buscarPorFechaAlta?startDate=${startDate}&endDate=${endDate}`);
    const pacientes = await response.json();
    mostrarResultados(pacientes);
}

function mostrarResultados(pacientes) {
    const listaPacientes = document.getElementById("listaPaciente");
 listaPacientes.innerHTML = "";

    if (pacientes.length > 0) {
        pacientes.forEach(paciente => {
            const item = document.createElement("li");
            item.textContent = `ID: ${paciente.id}, Nombre: ${paciente.nombre}, Fecha de Creación: ${paciente.fechaCreacion}`;
            listaPacientes.appendChild(item);
        });
    } else {
        listaPacientes.innerHTML = "<li>No se encontraron pacientes.</li>";
    }
}

window.onload = listarPacientes;
