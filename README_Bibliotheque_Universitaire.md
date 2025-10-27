# 📚 Bibliothèque Universitaire — API Spring Boot

> **Développé par [Aliou Diop (Les Serviteurs)](mailto:alioudiop463@gmail.com)**  
> GitHub : [AliouServiteurs](https://github.com/AliouServiteurs)

---

## 🧩 Description du projet

Ce projet est une **API RESTful complète** pour la gestion d’une **bibliothèque universitaire**, développée en **Java 17 + Spring Boot 3**.

Il met en œuvre toutes les **bonnes pratiques modernes** :  
- Architecture en couches claires (Controller / Service / Repository / Mapper / DTO)
- Gestion d’exceptions centralisée
- Validation des entrées utilisateur
- Documentation automatique Swagger (OpenAPI)
- Persistance avec PostgreSQL et JPA/Hibernate

---

## ⚙️ Stack technique

| Domaine | Technologies |
|----------|--------------|
| Langage | Java 17+ |
| Framework principal | Spring Boot 3.x |
| ORM | JPA / Hibernate |
| Mapper | MapStruct |
| Base de données | PostgreSQL |
| Documentation | Springdoc OpenAPI (Swagger UI) |
| Build Tool | Maven |
| Validation | Jakarta Validation |
| Gestion des exceptions | `@RestControllerAdvice` |

---

## 🏗️ Structure du projet

```
src/main/java/com/leserviteurs/sn/bibliotheque/
├── config/                 → Configuration Swagger & autres
├── controller/             → Couches REST exposant les endpoints
├── dto/                    → Objets de transfert de données (DTO)
├── entity/                 → Entités JPA
├── exception/              → Gestion centralisée des erreurs
├── mapper/                 → MapStruct DTO ↔ Entity
├── repository/             → Interfaces JPA Repository
├── services/
│   ├── implement/          → Logique métier
│   └── interfaces/         → Contrats des services
└── BibliothequeApplication.java
```

---

## 🧠 Fonctionnalités principales

| Module | Description |
|---------|-------------|
| **Livres (`Book`)** | CRUD complet sur les livres |
| **Clients / Abonnés** | Gestion des abonnés à la bibliothèque |
| **Emprunts / Retours** | Gestion des prêts de livres |
| **Utilisateurs** | Gestion des comptes internes (bibliothécaires, admins) |
| **Exceptions globales** | Gestion centralisée des erreurs avec des statuts HTTP cohérents |
| **Documentation Swagger** | Interface web interactive pour explorer l’API |

---

## 🧾 Configuration du projet

Fichier : `src/main/resources/application.properties`

```properties
spring.application.name=bibliotheque

# --- Configuration PostgreSQL ---
spring.datasource.url=jdbc:postgresql://localhost:5432/back_end
spring.datasource.username=postgres
spring.datasource.password=leserviteurs
spring.datasource.driver-class-name=org.postgresql.Driver

# --- JPA / Hibernate ---
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# --- Contexte de l'application ---
server.servlet.context-path=/api
```

---

## 🚀 Démarrage de l’application

### 1️⃣ Cloner le dépôt

```bash
git clone https://github.com/AliouServiteurs/bibliotheque-universitaire.git
cd bibliotheque-universitaire
```

### 2️⃣ Lancer PostgreSQL

Créer une base de données :
```sql
CREATE DATABASE back_end;
```

### 3️⃣ Lancer le backend

```bash
mvn spring-boot:run
```

### 4️⃣ Accéder à Swagger

📍 Swagger UI →  
[`http://localhost:8080/api/swagger-ui/index.html`](http://localhost:8080/api/swagger-ui/index.html)

📍 Documentation JSON →  
[`http://localhost:8080/api/v3/api-docs`](http://localhost:8080/api/v3/api-docs)

---

## 📚 Exemple de module : Livres

### ➕ Créer un livre

**POST** `/api/books`

```json
{
  "titre": "Programmation Java Moderne",
  "nombreExemplaireDisponible": 12,
  "nombreTotalExemplaire": 20
}
```

---

### 🔍 Récupérer tous les livres

**GET** `/api/books`

---

### 📘 Trouver un livre par ID

**GET** `/api/books/{id}`

---

### ✏️ Mettre à jour un livre

**PUT** `/api/books/{id}`

```json
{
  "titre": "Algorithmique avancée",
  "nombreTotalExemplaire": 25
}
```

---

### 🗑️ Supprimer un livre

**DELETE** `/api/books/{id}`

---

## ⚠️ Gestion des exceptions

Fichier : `GlobalExceptionHandler.java`

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Internal error: " + ex.getMessage());
    }
}
```

### ✨ Exemple d’erreur

**GET** `/api/books/999`  
Réponse :
```json
{
  "status": 404,
  "message": "Book not found with id 999"
}
```

---

## 📖 Documentation OpenAPI

### Exemple de configuration Swagger :

```java
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bibliothequeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("📚 API de Gestion de Bibliothèque Universitaire")
                        .description("API complète pour gérer les abonnés, les livres, les emprunts et les retours.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Les Serviteurs")
                                .email("support@leserviteurs.sn")
                                .url("https://leserviteurs.sn"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
```

---

## 🧪 Tests Postman

Un fichier `Bibliotheque-Universitaire.postman_collection.json` est disponible pour tester :
- 📕 `Books` : CRUD complet
- 👥 `Customers` : Gestion des abonnés
- 📦 `Loans` : Emprunts/retours
- 🔐 `Users` : Authentification (à venir)

Importer ce fichier dans Postman, puis exécuter les requêtes.

---

## ✅ Bonnes pratiques appliquées

- Architecture claire & extensible  
- Gestion des erreurs centralisée  
- Utilisation de DTO pour découpler les couches  
- Validation des entrées `@Valid`  
- Lombok pour réduire le boilerplate  
- MapStruct pour un mapping propre et maintenable  
- Documentation Swagger pour une API transparente  
- Respect des conventions RESTful  

---

## 💼 Objectif professionnel

Ce projet illustre les **compétences attendues d’un développeur Java/Spring Boot confirmé** :  
- Structuration d’un backend prêt pour la production  
- Respect des standards d’entreprise et de l’État (lisibilité, sécurité, extensibilité)  
- Connaissance des bonnes pratiques d’API REST modernes  
- Capacité à concevoir un code maintenable et évolutif  

---

## 👨‍💻 Auteur

**Aliou Diop (Les Serviteurs)**  
📧 [alioudiop463@gmail.com](mailto:alioudiop463@gmail.com)  
🌐 [GitHub : AliouServiteurs](https://github.com/AliouServiteurs)

> *« La rigueur du code, c’est la première preuve du professionnalisme du développeur. »*

---

## 🏁 Licence

Ce projet est sous licence **Apache 2.0** — libre d’utilisation et de modification à des fins éducatives et professionnelles.
