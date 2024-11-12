async function obtenerPerfilCompleto() {
            const urlParams = new URLSearchParams(window.location.search);
            const idPaciente = urlParams.get('id');

            const perfilResponse = await fetch(`/api/paciente/${idPaciente}/perfil`);
            const documentosResponse = await fetch(`/api/paciente/${idPaciente}/documentos`);
            const presupuestosResponse = await fetch(`/api/paciente/${idPaciente}/presupuestos`);
            const tratamientosResponse = await fetch(`/api/paciente/${idPaciente}/tratamientos`);

            if (perfilResponse.ok && documentosResponse.ok && presupuestosResponse.ok && tratamientosResponse.ok) {
                const perfilCompleto = {
                    perfil: await perfilResponse.json(),
                    documentos: await documentosResponse.json(),
                    presupuestos: await presupuestosResponse.json(),
                    tratamientos: await tratamientosResponse.json()
                };
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

        window.onload = obtenerPerfilCompleto;