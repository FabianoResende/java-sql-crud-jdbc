📌 Projeto Java + SQLite — Sistema de Tarefas (CRUD Completo)
https://img.shields.io/badge/Java-17%2B-red
https://img.shields.io/badge/SQLite-JDBC-blue
https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen
https://img.shields.io/badge/Licen%C3%A7a-Livre-lightgrey

Aplicação Java com integração ao banco de dados SQLite utilizando JDBC.
O projeto implementa um CRUD completo de tarefas com arquitetura organizada e código limpo, ideal para estudos, portfólio e evolução para sistemas maiores.

🚀 Funcionalidades
✔️ Inserir tarefa

✔️ Listar tarefas

✔️ Concluir tarefa

✔️ Remover tarefa

✔️ Banco criado automaticamente

✔️ Persistência em arquivo .db

✔️ Arquitetura DAO (padrão profissional)

🛠️ Tecnologias Utilizadas
Java 17+

JDBC

SQLite

VS Code

Git & GitHub

📂 Estrutura do Projeto
Código
ProjetoJavaSQL/
 ├── Menu.java           # Interface de console
 ├── Tarefa.java         # Modelo (entidade)
 ├── TarefaDAO.java      # Acesso ao banco (DAO)
 ├── ConexaoDB.java      # Conexão com SQLite
 ├── sqlite-jdbc.jar     # Driver JDBC
 └── meu_projeto.db      # Banco de dados (ignorado no Git)
▶️ Como Executar
1. Compile:
Código
javac -cp ".;sqlite-jdbc-3.53.0.0.jar" *.java
2. Execute:
Código
java -cp ".;sqlite-jdbc-3.53.0.0.jar" Menu
🧱 Arquitetura
O projeto segue uma estrutura clara e escalável:

Menu → Entrada do sistema e interação com o usuário

DAO → Camada de acesso ao banco

Model → Representação da entidade Tarefa

Conexão → Responsável por abrir a conexão com SQLite

Essa separação facilita manutenção, testes e evolução do projeto.

📸 Demonstração (Console)
Código
=== MENU ===
1 - Inserir tarefa
2 - Listar tarefas
3 - Concluir tarefa
4 - Remover tarefa
0 - Sair
Escolha:
📜 Licença
Projeto livre para estudo, modificação e uso.

👨‍💻 Autor
Fabiano Faria de Resende  
🔗 GitHub: https://github.com/FabianoResende  
🔗 LinkedIn: https://www.linkedin.com/in/fabianofr
