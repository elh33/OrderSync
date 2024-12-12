# Devoir Libre Java 🧵📦

## 🚀 Présentation du Projet

OrderSync est une application Java innovante qui exploite la programmation multi-threadée pour synchroniser et valider des commandes à partir de fichiers JSON vers une base de données MySQL.

## ✨ Caractéristiques Principales

- **Programmation Multi-threadée** 
  - Utilisation de `Thread` pour le traitement asynchrone des commandes
  - Amélioration des performances grâce au traitement parallèle
  - Gestion efficace du parsing de fichiers JSON

- **Synchronisation de Données**
  - Validation des commandes par rapport à la base de données clients
  - Séparation automatique des commandes valides et invalides
  - Journalisation détaillée des erreurs

## 🛠 Prérequis Techniques

- Java 8 ou supérieur
- Maven
- Connecteur MySQL
- Base de données MySQL configurée

## 🔍 Architecture Multi-threadée

### Fonctionnement des Threads

#### Avantages de l'Approche Multi-threadée
- Traitement non bloquant
- Amélioration du temps de réponse
- Utilisation optimale des ressources du processeur

## 📦 Structure du Projet

```
OrderSync/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ma/
│   │   │       └── ensa/
│   │   │           ├── OrderSync/
│   │   │           │   ├── App.java
│   │   │           │   ├── Customer.java
│   │   │           │   └── Order.java
│   │   │           └── services/
│   │   │               ├── DatabaseService.java
│   │   │               └── OrderService.java
│   │   └── resources/
│   │       └── data/
│   │           ├── error.json
│   │           ├── input.json
│   │           └── output.json
│   └── test/
│       └── java/
│           └── ma/
│               └── ensa/
│                   └── OrderSync/
                        └──AppTest.java
└── pom.xml
```

## 🚀 Installation et Démarrage

### Clonage du Projet

```bash
git clone https://github.com/elh33/OrderSync.git
cd OrderSync
```

### Configuration

1. Configurer les paramètres de connexion à la base de données
2. Préparer les fichiers JSON dans `resources/data/`

### Compilation

```bash
mvn clean install
```

### Exécution

```bash
java -jar target/OrderSync-1.0.jar
```

## 🔐 Règles de Validation

- Vérification de l'existence du client avant insertion
- Détection des commandes en doublon
- Séparation des commandes valides et invalides

## 🧵 Gestion Avancée des Threads

### Points Clés

- Création dynamique de threads
- Traitement asynchrone des commandes
- Gestion des exceptions dans le contexte multi-threadé

## 📊 Fichiers de Données

- `input.json` : Commandes source
- `output.json` : Commandes validées
- `error.json` : Commandes invalides

## ⚠️ Recommandations

- Toujours vider `output.json` et `error.json` avant l'exécution
- Vérifier la connexion à la base de données
- Gérer les exceptions potentielles

## 🔍 Débogage et Logs

L'application génère des logs pour chaque étape :
- Insertion de commandes
- Validation des clients
- Erreurs de traitement
