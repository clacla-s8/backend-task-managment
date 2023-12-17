
Aplicação Spring Boot REST
Esta é uma aplicação Spring Boot simples que demonstra uma API REST para gestão de tarefas.

Pré-requisitos
Antes de começar, certifique-se de ter instalado o seguinte:

Kit de Desenvolvimento Java (JDK) - versão 11 ou posterior
Apache Maven
Seu ambiente de desenvolvimento integrado (IDE) favorito, como Eclipse ou IntelliJ IDEA
Iniciando
Siga estas etapas para executar a aplicação Spring Boot:

Clonar o Repositório:

git clone https://github.com/clacla-s8/backend-task-managment.git

Navegar até o Diretório do Projeto

Construir o Projeto:
mvn clean install

Executar a Aplicação

Alternativamente, você pode executar a aplicação usando o Maven:
mvn spring-boot:run
Acessar as APIs REST:

Abra o seu navegador da web ou uma ferramenta como o Postman ou Insomnia e acesse os seguintes endpoints:

URL Base: http://localhost:8090
Exemplos de Endpoints:

GET http://localhost:8090/tasks: Lista todas as tarefas.
POST http://localhost:8090/tasks: Cria uma nova tarefa.
Desligar a Aplicação:

Pressione Ctrl + C no terminal onde a aplicação está em execução para encerrá-la.

Configuração
Você pode configurar a aplicação modificando o arquivo application.properties no diretório src/main/resources.

Esta Aplicação usa o Mysql como banco de dados
Se for utilizar o mesmo, crie uma base de dados "tasks"
