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
		headers : {
			'Content-Type' : 'application/json'
		}
	}
	fetch(url, options)
	.then(response => response.json())
	.then(data => result.innerHTML = data.name + ', bien enregistré!!')
	.catch(err => console.log('Erreur :' + err))
	
}


