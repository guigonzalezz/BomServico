function carregar()
{
	const filtro = document.getElementById("filtro").value; 
    const data = new URLSearchParams();
    data.append("filtro",filtro);
    
    fetch("listar", {method: 'POST', body: data})
    .then(function (response) {
        return response.text();})
    .then(function (text) {
        var json=JSON.parse(text);
        var table="";
        for (let i=0;i<json.length;i++)
        table+=`
        	<div id="${json[i].id}" class="anuncio">
                <div class="anuncio-imagem">
                    <p>Imagem</p>
                </div>
                <p class="titulo-anuncio">${json[i].titulo}</p>
                <p class="tipo-anuncio">${json[i].tipo_servico}</p>
                <p class="descricao-anuncio">${json[i].descricao}</p>
            </div>
        `; 
        document.getElementsByClassName("painel-anuncios").innerHTML=table;
    }).catch(function (error) {
        console.error(error);
    });
}