# Testify

**by Group 8 LD20 OOP**

A JavaFX + Maven desktop application. This guide walks you through setting up a fresh Windows machine, installing the required tools, cloning the repository, and compiling/running the app locally.

---

## Prerequisites

Install these tools once in order (standardized on **Java 25**):

| Tool | Purpose | Download |
| --- | --- | --- |
| **Git for Windows** | Clones the repository from GitHub and pulls/pushes updates | [Git for Windows](https://git-scm.com/download/win) |
| **Eclipse Temurin JDK 25 (64-bit)** | Provides Java (`java`) and the Java compiler (`javac`) | [Eclipse Temurin JDK 25](https://adoptium.net/temurin/releases/?version=25) |
| **Apache Maven** | Builds the project and resolves JavaFX dependencies from `pom.xml` | [Apache Maven](https://maven.apache.org/install.html) |

> **Important:** Use **JDK 25** to match the rest of the team. Do **not** install the JavaFX SDK separately — Maven automatically resolves JavaFX dependencies declared in `pom.xml`. You can use any Java-compatible IDE or code editor you prefer.

---

## Installation Guide (Windows)

### 1. Install Git for Windows
1. Open the [Git for Windows download page](https://git-scm.com/download/win).
2. Download the **Windows x64** installer (choose **ARM64** only on an ARM-based Windows PC).
3. Run the installer with default options, keeping the option that makes Git available from the command line / third-party software.
4. Close and reopen your terminal (e.g., PowerShell) and verify:
   ```powershell
   git --version
   ```

### 2. Install Eclipse Temurin JDK 25
Install a **JDK** (not only a JRE) so both `java` and `javac` are available.
1. Open [Eclipse Temurin JDK 25 downloads](https://adoptium.net/temurin/releases/?version=25).
2. Select **Version 25**, **JDK**, **Windows**, and **x64** (or **ARM64** for ARM PCs), then download the `.msi` installer.
3. Run the `.msi` installer and keep the options to **Add to PATH** and **Set `JAVA_HOME`** enabled.
4. Close and reopen PowerShell and verify both report version 25:
   ```powershell
   java --version
   javac --version
   ```
   > If `JAVA_HOME` is not set automatically, find the installed Temurin JDK folder inside `Program Files` and set `JAVA_HOME` to that exact path in Windows Environment Variables.

### 3. Install Apache Maven
1. Open the [Apache Maven installation page](https://maven.apache.org/install.html) and download the latest stable **Binary zip archive**.
2. Extract it to a simple folder such as `C:\Tools\apache-maven` (the folder should contain a `bin` subfolder with `mvn.cmd`).
3. Open Windows Search → **Edit the system environment variables** → **Environment Variables**.
4. Under **User variables**, edit **Path** and add the Maven `bin` folder (e.g., `C:\Tools\apache-maven\bin`).
5. Save all dialogs, reopen PowerShell, and verify:
   ```powershell
   mvn --version
   ```
   Confirm the output shows both the Apache Maven version and **Java version 25**.

---

## Clone the Repository

> Do **not** download the GitHub ZIP if you plan to collaborate with Git. Always clone so you can pull and push changes.

1. Open PowerShell in the folder where you keep your coding projects (for example, `cd C:\code`).
2. Clone the repository:
   ```powershell
   git clone https://github.com/Abysswdh/Testify.git
   cd Testify
   ```
3. Open the `Testify` folder (the folder containing `pom.xml`) in your preferred IDE or code editor.

---

## Compile and Run

Open a terminal in the project root (the folder where `pom.xml` is located).

### One-Time Tool Verification
```powershell
git --version
java --version
javac --version
mvn --version
```

### Compile Only
```powershell
mvn clean compile
```

### Build and Run the Application
```powershell
mvn clean javafx:run
```
*The first run may take a bit longer while Maven downloads dependencies. On subsequent runs, you can use:*
```powershell
mvn javafx:run
```

---

## Project Structure

```text
Testify/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   └── com/example/
│       │       ├── App.java
│       │       ├── TestController.java
│       │       ├── PrimaryController.java
│       │       └── SecondaryController.java
│       └── resources/
│           └── com/example/
│               ├── test.fxml
│               ├── primary.fxml
│               ├── secondary.fxml
│               └── styles.css
└── testFX.java
```

> `target/` and `out/` are generated build outputs (ignored by Git) — do not edit or commit them.

---

## Everyday Git Workflow

### First-Time Git Identity Setup
If Git asks you to identify yourself, run (using your GitHub email):
```powershell
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```

### Before Starting Work
```powershell
git pull
```
*(If a merge conflict occurs, stop and coordinate with the teammate who edited the same file.)*

### After Making Changes
```powershell
git status
git add .
git commit -m "Describe your change"
git push
```

### Team Rules
- **Do:** Pull before starting a session, commit small meaningful changes, coordinate which files/features you are editing, and push when ready to share.
- **Avoid:** Editing the same files simultaneously without coordinating, committing secrets/tokens, committing `target/` or `out/`, or force-pushing shared branches.
