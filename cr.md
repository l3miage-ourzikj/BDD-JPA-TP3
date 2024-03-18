Authors : [Jugurta OURZIK](https://www.linkedin.com/in/jugurtao/) - [Nils MIEL]() 

### Compte rendu TP3 - JPA

##### *Question 1*:  Avez-vous remarqué quelque-chose avec les fonctions par interpolation ?
Les requêtes par interpollation de nom de fonction est une magie de Spring Boot car il arrive à implémenter la 
fonction correspondant à la requête seulement en lisant un nom de fonction normé.
De plus, l'**IDE** **intelliJ** propose des noms normés variés et adéquats à nos besoins.

Il met l'accent sur les paramètres des fonctions ainsi que leurs types.

##### *Question 2*: A votre avis, quelle est la manière la plus efficace pour récupérer et mettre en relation plusieurs éléments entre eux ?
Il existe des manières éfficaces pour récupérer et mettre en relation les éléments entre eux comme:

- L'utilisation de Spring Data JPA qui consiste à créer une couche d'abstraction pour le requêtage SQL (Object Relationnal Mapping à travers l'ORM Hibernate),
      cela nous évite donc d'écrire du code SQL. 
- Implémentation des services et des repositoris: respecter une certaine architecture permet de bien lier ses éléments et bien récupérer ses données.
  Par exemple, le fait d'avoir des services sert à envelopper toute la logique métier et donc par la suite faire appel à ce service facilement dans le controller par exemple en gardant le corps du controller propre et pas surchargé avec du code.
- L'Héritage **[Usage avec attention et intelligence]**: L'héritage permet de lier des éléments entre eux s'il existe si l'un hérite de l'autre et donc facilite l'accès à l'information à condition que la stratégie d'héritage soit bien adéquate au contexte dans lequel l'héritage est réalisé car parfois l'héritage rend les choses plus compliquées et moins lisible.
  - Éviter des jointures quand cela n'est pas nécessaire.
  - Bien choisir sa stratégie en fonction du besoin.


##### *Question 3*: Ici, Les components renvoient directement les entités, pensez-vous que cela soit une bonne chose ? Sinon, quelle serait la bonne méthode ?
Effectivement dans notre première expérimentation, les components renvoient des entités et cela n'est pas considéré comme bonne pratique car on charge tous les champs correspondants à l'entité demandée.Parfois, on n'a pas besoin  de les avoir.
La bonne méthodes serait de mapper vers des DTO qui sont des objets qui contiennet seulement les champs nécessaires pour réaliser notre tâche.
    Exemple: Une entité **User** a comme champs : (firstName, lastName, email, password,dateOfBirth, Sexe)
    Lors d'une connexion (Login) on n'est pas sensé fournir une entité User car on a rien à faire avec sa date de naissance.Cela dit, on fournit uniquement son email et son mot de passe 
    qui seront des champs d'un DTO appelé **UserDTO**.

C'est à nous de controller les données que doit fournir l'utilisateur et celles qu'on veut lui transmettre.

##### *Question 4*: Si je supprime un artiste, que se passe-t-il ?
La suppression d'un artiste entraîne la supression en cascade de tous ses albums car  il est annoté de **cascade =CascadeType.ALL**.
Si jamais cette entité n'est pas annotée avec le type de cascade correspondant, les entitées liées à cette dernières seront des orphelines et poseront des problèmes d'intégrité des données car elles ne sont plus référencées par le schéma de la base de données. (on peut dire qu'elles sont détachées du schéma).

##### *Question 5*: Si je récupère une playlist, est-ce que toute l'entité est chargée ?
Non l'entité n'est pas entièrement chargée car par défaut JPA applique un chargement paresseux (Lazy loading), cela dit que la liste des sons de la playlist ne sont pas immédiatement chargés car il y a aucune configuration du chargement ajoutée aux deux entités.
Il est d'ailleurs très intéressant d'opter pour ce type de chargements pour les relations OneToMany par exemple pour des raison de performances en évitant d'intéroger notre base de données.
(Les accès au disque sont très couteux)


## Remarque :
1-Comme nous avons discuté en TP, la relation entre **Playlist** et **Song** est plutôt une @ManyToMany mais pas une  @OneToMany car une playlist peut contenir plusieurs sons et un son peut appartenir à plusieurs playlists.

##Suggestion : 
Il est intéressant d'implémenter un héritage entre  **Artist** et **User** car un artist est un utilisateur particulier qui peut publier des sons de son choix sur une plateforme comme Spotify par exemple.

