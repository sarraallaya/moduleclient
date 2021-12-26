# moduleclient
Back end avec spring boot 2 java 11 , base de donnée PostgreSQL 14 .
Avant d'exécuter le projet , créez une base de donnée vide sous le nom "gestioncommandes"
Modifiez les paramètres de la connexion à la base(nom , password..) dans le fichier "application.properties" 
Des apis pour ajouter , modifier , consulter et retrait : categorie produit , produit , client , commande documentés par swagger2 url : http://localhost:9096/swagger-ui.html#/:
Apis pour categorie:
http://localhost:9096/rest/categorie/api/ajouterCategorie
http://localhost:9096/rest/categorie/api/modifierCategorie
http://localhost:9096/rest/categorie/api/supprimerCategorie/{categorieId}
http://localhost:9096/rest/categorie/api/listeCategories
Apis pour client :
http://localhost:9096/rest/client/api/ajouterClient
http://localhost:9096/rest/client/api/listeClients

Apis pour produit:
http://localhost:9096/rest/produit/api/listeProduits
http://localhost:9096/rest/produit/api/supprimerProduit/{produitId}

Apis pour carnet commande:
http://localhost:9096/rest/commande/api/ajouterCommande
http://localhost:9096/rest/commande/api/modifierCommande
http://localhost:9096/rest/commande/api/supprimerCategorie/{commandeId}/{clientd}
http://localhost:9096/rest/commande/api//listeCommandes/{clientId}