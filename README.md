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

```
🟡 POLICY VIOLATION DETECTED
============================================================
🔍 Policy: unusual_time_access
📂 Category: BEHAVIOR
⚡ Severity: MEDIUM
🕒 Detected: 2025-08-25 12:56:23
🎯 Method: llm (confidence: 0.80)

📋 Description:
   Activité détectée en dehors des heures normales de travail

📄 Affected Log:
   Timestamp: 2025-08-25 12:54:41
   Level: [INFO]
   Message: Data migration running at 04:30 AM

🧠 AI Analysis:
   The following log messages indicate unusual time access: Data migration running at 04:30 AM, System maintenance scheduled at 01:00 AM, Emergency patch applied at 02:00 AM, Security scan initiated at 03:15 AM, and Database reindex running at 03:00 AM. These activities are taking place between 22h and 6h du matin, which could indicate unusual activity.

✅ RECOMMENDED ACTION:
   Vérifier si cette activité est justifiée
```

```
🟠 POLICY VIOLATION DETECTED
============================================================
🔍 Policy: sudden_request_spike
📂 Category: BEHAVIOR
⚡ Severity: HIGH
🕒 Detected: 2025-08-25 12:56:23
🎯 Method: llm (confidence: 0.90)

📋 Description:
   Pic d'activité inhabituel détecté - possibilité d'attaque

📄 Affected Log:
   Timestamp: 2025-08-25 12:55:27
   Level: [WARNING]
   Message: Cache requests: 300 cache misses in 1 minute from same session

🧠 AI Analysis:
   The following log messages indicate a sudden request spike: Cache requests: 300 cache misses in 1 minute from same session and Network alert: CPU usage 78% due to high traffic. These messages suggest a rapid increase in the number of requests from a single session and high CPU usage, which could indicate a sudden request spike.

✅ RECOMMENDED ACTION:
   Analyser les IP ou utilisateurs associés à cette hausse d'activité
```

```
🟠 POLICY VIOLATION DETECTED
============================================================
🔍 Policy: detect_api_key_leak
📂 Category: SECURITY
⚡ Severity: HIGH
🕒 Detected: 2025-08-25 12:56:23
🎯 Method: regex (confidence: 1.00)

📋 Description:
   Violation de policy security

📄 Affected Log:
   Timestamp: 2025-08-25 12:54:47
   Level: [ERROR]
   Message: API request failed: invalid api-key xyz123456789abcdef

✅ RECOMMENDED ACTION:
   Vérifier si une clé ou un token a été exposé
```

```
🟠 POLICY VIOLATION DETECTED
============================================================
🔍 Policy: detect_resource_saturation
📂 Category: PERFORMANCE
⚡ Severity: HIGH
🕒 Detected: 2025-08-25 12:56:23
🎯 Method: regex (confidence: 1.00)

📋 Description:
   Violation de policy performance

📄 Affected Log:
   Timestamp: 2025-08-25 12:56:05
   Level: [CRITICAL]
   Message: Network alert: CPU usage 78% due to high traffic

✅ RECOMMENDED ACTION:
   Surveiller et ajuster l'utilisation des ressources
```
