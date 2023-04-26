# API Rest pour la gestion de bibliothèque
Nous appelons API Rest toute solution web permettant de désservir des objets "JSON" ( ou "XML" ), plutot que des pages Web selon les conventions d'une architecture Rest.

## 1. Requetes HTTP Rest
Une architecture Rest se base sur le protocol HTTP et un ensemble de conventions HTTP basées sur des méthodes HTTP classiques. Ainsi, pour l'échange d'auteurs par exemple , on utilisera les conventions suivantes : 

```
GET 		/biblio/authors
GET 		/biliio/authors/{id}
POST  		/biblio/authors
PUT 		/biblio/authors/{id}
DELETE		/biblio/authors/{id}
```

