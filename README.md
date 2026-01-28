## 🕹️ Saltos e Segredos

![Java](https://img.shields.io/badge/java-8%2B-blue)
![Greenfoot](https://img.shields.io/badge/greenfoot-3.6%2B-lightgrey)
![GitHub last commit](https://img.shields.io/github/last-commit/JoaoP-30/Projeto-IPOO)

**Saltos e Segredos** é um jogo desenvolvido com [Greenfoot](https://www.greenfoot.org/door), voltado para aprendizado e experimentação com programação orientada a objetos em Java.  

---
### 📦 Estrutura atual do projeto

**Worlds:**
- `Fases` (superclasse abstrata)
- `Fase_1`
- `Fase_2`
- `Fase_3`
- `Fase_4`
- `Tela_Derrota`
- `Tela_Inicial`
- `Tela_Instrucoes`
- `Tela_Vitoria`
- `Dicas`

**Actors e Itens:**
- `Ataque`
- `AtaqueDireito` 
- `AtaqueEsquerdo` 
- `Auxilia_Som` 
- `Chao_Falso`
- `Coletaveis` (superclasse abstrata)
- `Chave`
- `Moeda`
- `HUD`
- `Inimigos` (superclasse abstrata)
- `Monstro`
- `Boss`
- `Cacto`
- `Skull`
- `Jogador`
- `PainelJogo`
- `Portal`
- `Solo`(superclasse abstrata)
- `Chao`
- `Barreira`
- `Plataforma`

**Classes Independentes:**
- `Pontuacao` (Singleton)
- `Som` (SingleTon)

---

### 🚧 Status do projeto

> ⚠️ **Em desenvolvimento**  
Todas as classes fundamentais foram implementadas e estão funcionando conforme esperado. A arquitetura do projeto está solida, com os papéis de cada componente bem definidos.

---

### 🛠️ Como executar

1. Instale o [Greenfoot](https://www.greenfoot.org/download)
2. Certifique-se de ter Java 8+ instalado
3. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/saltos-e-segredos.git
   ```
4. Abra o projeto no Greenfoot
5. Explore as classes e contribua!

---

### 🤝 Contribuições

Contribuições são bem-vindas! Para colaborar:
- Abra uma issue para discutir melhorias ou bugs
- Envie um pull request com suas alterações
- Siga o padrão de código e estilo definido no projeto

---
<img src = "/Saltos_%20e%20_Segredos/images/In_game/TelaInicial.png" height = 300 alt = "Tela inicial">
<img src = "/Saltos_%20e%20_Segredos/images/In_game/Fase1.png" height = "300" alt = "Fase 1">
