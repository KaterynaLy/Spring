/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', (event) => {
    const registerForm = document.getElementById('registerForm');

    registerForm.addEventListener('submit', function(event) {
        event.preventDefault();
        
        const formData = new FormData(registerForm);
        const registerData = {
            nombreUsuario: formData.get('nombreUsuario'),
            password: formData.get('contraseña')
        };
        console.log(registerData);
        fetch('/usuarios/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(registerData)
        })
        .then(response => {
            if (response.ok) {
                alert('Registro exitoso. Ahora puede iniciar sesión.');
                window.location.href = '/login.html';
            } else {
                return response.text().then(text => { throw new Error(text); });
            }
        })
        .catch(error => {
            alert('Registro fallido: ' + error.message);
        });
    });
});


