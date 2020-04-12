
app = (function () {
    var emailU;
    var userNameU;
    var nameU;
    var passwordU;
    var url= '';


    return {
        setUserRegistry: function () {
            emailU = document.getElementById("txt_email").value;
            userNameU= email = document.getElementById("txt_userName").value;
            nameU = document.getElementById("txt_name").value;
            passwordU = document.getElementById("txt_password").value;
        },
        setUserLogin: function () {
            userNameU= email = document.getElementById("txt_userName").value;
            passwordU = document.getElementById("txt_password").value;
        },
        showUsers: function (dataR) {
            //$("#resultados").empty();

            for (i in dataR.data.data) {
                $("#resultados").find("#resultsBody").append(
                    "<tr><td>" + dataR.data.data[i].userId + "</td><td>" + dataR.data.data[i].name +"</td><td>"+ dataR.data.data[i].email+"</td></tr>")
    
            }
            
        },

        loginUser: function () {    
            //document.getElementById("funcionesTxt").innerHTML = "function app";
            //axios.get('/users')
            app.setUserLogin();
            axios.get(url+'/login/'+userNameU+'/'+passwordU, {
                    userName: userNameU,
                    password: passwordU
                }).then(response => {
                    // Respuesta del servidor
                    console.log(response)
                    alert("correcto")
                    //app.showUsers(response);
                    
                })
                .catch(e => {
                    // Capturamos los errores
                    console.log(e);
                })
            
        },
        registerUser: function () {           
            app.setUserRegistry();
            axios.post(url+'/signUp', {
                name: nameU,
                email: emailU,
                userName: userNameU,
                password: passwordU
            }).then(response => {
                // Respuesta del servidor
                alert('User registered')
                console.log(response);

            }).catch(e => {
                console.log(e);
        });
            
        }


    };
})();
