function addAuthor() {
	let url = 'authors';
	let result = document.getElementById('result');
	let data = {
		id : document.getElementById('id').value,
		name : document.getElementById('name').value,
		yearBorn : document.getElementById('yearBorn').value
	}
	let options = {
		method : 'POST',
		body : JSON.stringify(data),
		headers : {vbbbbbbbbbbbbbbbbbb
			'Content-Type' : 'application/json'
		}
	}
	fetch(url, options)
	.then(response => response.json())
	.then(data => result.innerHTML = data.name + ', bien enregistré!!')
	.catch(err => console.log('Erreur :' + err))
	
}

function putAuthor(id)
{
	let url = 'authors/'+id;
	let result = document.getElementById('result');
	let data = {
		id : document.getElementById('id').value,
		name : document.getElementById('name').value,
		yearBorn : document.getElementById('yearBorn').value
	}
	let options = {
		method : 'PUT',
		body : JSON.stringify(data),
		headers : {
			'Content-Type' : 'application/json'
		}
	}
	fetch(url, options)
	    .then(response => response.json())
		.then(data => result.innerHTML = data.name + ', bien modifié!!')
		.catch(err => console.log('Erreur :' + err))
}

function putAuthor(id)
{
	let url = 'authors/'+id;
	let result = document.getElementById('result');
	let options = {
			method : 'PUT', 
			headers : {
				'Content-Type' : 'application/json'
			}
		}
	fetch(url, options)
		.then(res => res.text()) // or res.json()
		.then(res => console.log(res))
}



