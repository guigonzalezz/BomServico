function pesquisar()
{
    const data = new URLSearchParams();
    data.append("fitro","");
    fetch("listar", {method: 'POST', body: data})
    .then(function (response) {
        return response.text();})
    .then(function (text) {
        var json=JSON.parse(text);
        var table="";
        for (let i=0;i<json.length;i++)
        table+=`<tr><td>${json[i].id}</td><td>${json[i].nome}</td><td>${json[i].email}</td><td>${json[i].cargo}</td>
                    <td onclick='apagar(${json[i].id})'>X</td>
                    <td onclick='alterar(${json[i].id})'>▓</td>
                    </tr>`;
        document.getElementById("respesq").innerHTML=table;
    }).catch(function (error) {
        console.error(error);
    });
}

function gravar()
{
    //event.preventDefault();
    var fdados = document.getElementById("fdados");
    var jsontext = JSON.stringify(Object.fromEntries(new FormData(fdados)));
    fetch("cadastrar", {headers: {'Accept': 'application/json','Content-Type': 'application/json'},
                        method: 'POST', 
                        body: jsontext})
    .then(function (response) {
        return response.text(); })
    .then(function (text) {
        // result recebe a resposta do módulo dinâmico
        limparForm();
        pesquisar();
    }).catch(function (error) {
        console.error(error);
    });
}

function apagar(id)
{
    fetch("apagar?id="+id, {method: 'GET'})
    .then(function (response) {
        return response.text();})
    .then(function (text) {
        limparForm();
        pesquisar();
        var divm=document.getElementById("mensagem");
        divm.innerHTML=text;
        divm.style.display="block";
        setTimeout(apagarMensagem, 2000); 
    }).catch(function (error) {
        console.error(error);
    });
}

function alterar(id)
{   var fdados = document.getElementById("fdados");
    fetch("buscar?id="+id, {method: 'GET'})
    .then(function (response) {
        return response.text();})
    .then(function (text) {
        var json=JSON.parse(text);
        fdados.id.value=json.id;
        fdados.nome.value=json.nome;
        fdados.email.value=json.email;
        fdados.cargo.value=json.cargo;
        pesquisar();
    }).catch(function (error) {
        console.error(error);
    });
}

/*funcoes adicionais*/
function apagarMensagem()
{
    document.getElementById("mensagem").style.display="none";
}
function limparForm()
{
    var fdados = document.getElementById("fdados");
    //fdados.reset();
    fdados.id.value=0;
    fdados.nome.value="";
    fdados.email.value="";
    fdados.cargo.value="";
    //document.getElementById("mensagem").innerHTML="";
}


