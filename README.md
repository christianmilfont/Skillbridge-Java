# SkillBridge — Plataforma de requalificação e conexão trabalho×aprendizado

![Imagem do WhatsApp de 2025-11-23 à(s) 17 49 10_e1532feb](https://github.com/user-attachments/assets/ccfeba80-f5e7-4e06-b530-8dc6f9457fa8)


Grupo:
```
  Christian Milfont Rm555345
  Iago Victor Rm558450
```
## SkillBridge — Plataforma de requalificação e conexão trabalho×aprendizado

**Por que encaixa no tema “Futuro do Trabalho”? conecta requalificação, IA como parceira e inclusão — tudo pedido pelo desafio.**

2TDS Fevereiro - Global Solutio…
### Nosso Product Deck com BrainStorm
<img width="922" height="576" alt="image" src="https://github.com/user-attachments/assets/4701f2da-c27c-4a12-ae9c-913ae26be990" />


### Tecnologias utilizadas:
- MySQL 8.0
- Java SDK 21 (Sdk da oracle utilizada pelos laboratórios da FIAP)
- SpringBoot
- Flaway (Para migrar os dados para o banco, automatizando processos)
- Thymeleaf (Para denonstrar a aplicação montada de uma maneira mais visual utilizando HTML)
- Spring Security (Para permisionamentos dos acessos de determinadas ações da API, configurei o projeto com os arquivos SecurityConfig e na parte de Services nosso UserDetails para definir nossas Roles)

Comandos essenciais (Utilize os comandos abaixo sobre o banco de dados para conseguir rodar a aplicação sem problemas):
```bash
    git clone https://github.com/christianmilfont/Java-Mottu.git
    cd Java-Mottu
```

## JAVA ADVANCED (Java / Spring Boot)

Objetivo: Serviço de orquestração e IA + requisitos Spring (validation, security, mensageria).

**Responsabilidades concretas:**

- Serviço Spring Boot que expõe endpoints auxiliares: geração de learning path, validações de compatibilidade, fila de notificações.

- Spring Data JPA para interagir com MySQL.

- Spring Security com JWT para transformar as senhas em Hashs.

- Caching (Redis in-memory ou cache local) para endpoints de catálogo.

Mensageria: Montamos um serviço que faz com que associe as melhores notas com base no nome do Usuário e assim recomende as vagas ou cursos para ele.

- Integração de Spring AI, chamada à API generativa OpenIA para gerar descrições para as melhores vagas.

**Entrega: deploy em nuvem, documentação.**
Uitlizamso banco MySQL hospedado no RailWay e Aplicação java Hospedada no Render
