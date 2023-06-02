package org.mql.biblio.controllers;

import java.util.List;

import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors") // un prefix pour les requetes /biblio/authors
public class AuthorController {
	@Autowired
	private List<Author> authors;
	
	public AuthorController() {
 	}
	
	// listes des points terminaux : End-points
	@GetMapping
	public List<Author> getAllAuthors()
	{
		return authors;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable int id) {
		for (Author author : authors) { // ce travail se fait dans la couche business
			if(author.getId() == id) 
				return ResponseEntity.ok().body(author);
		}
		return ResponseEntity.notFound().build();
	}
	
	// simple formulaire
	/*
	@PostMapping
	public Author addAuthor(Author author)
	{
		authors.add(author);
		return author;
	}
	*/
	
	/*
	 * L'annotaion request body suppose que la requete est une requete AJAX
	 * avec les données reçus dans le corps de la requete sous format JSON/XML
	 * s'il s'agit en fait d'une requete ordinaire ( no-ajax ) on ne doit pas utiliser 
	 * cette annotation. On pourra utiliser par contre l'annotation à utiliser modelAttribute. Sinon , 
	 * on peut aussi utiliser l'annotation RequestParam sur les paramétres passés individuellement comme paramétre
	 * d'une point terminal
	 */
	
	@PostMapping
	public Author addAuthor(@RequestBody Author author)
	{
		authors.add(author);
		return author;
	}
	
	// Put et Delete mapping
	
	@PutMapping("/{id}")
	public Author PutAuthor(@PathVariable int id,@RequestBody Author author)
	{
		authors.get(id).setName(author.getName());
		authors.get(id).setYearBorn(author.getYearBorn()); 
		return author;
	}
	
	@DeleteMapping("/{id}")
	public Author DeleteAuthor(@PathVariable int id)
	{
		Author a = authors.get(id);
		authors.remove(id);
		return a;
	}
	
}
