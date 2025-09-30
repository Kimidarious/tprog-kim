
# Exercício: Listar diretórios e arquivos em Java (usando `File`, `Path`, recursividade e Streams)

## Objetivo
Crie um programa em Java que percorra recursivamente uma árvore de diretórios a partir de um caminho inicial e liste **todos os diretórios e subdiretórios**, juntamente com os **arquivos correspondentes**.

>> Você deve implementar a navegação utilizando **`File`**, **`Path`** e **recursividade**. O uso de **Streams** é permitido para auxiliar no processamento de listas de arquivos e diretórios.
---

## Requisitos
1. Crie uma classe `DirectoryLister` que contenha um método público:
   ```java
   public static void listTree(File start, String indent, List<String> out)
   ```
    - `start` é o diretório inicial.
    - `indent` é uma string de indentação (ex.: `"  "`), para controlar a profundidade da árvore.
    - `out` é uma lista (`List<String>`) onde você armazenará as linhas com o resultado (diretórios terminam com `/`, arquivos apenas com o nome).

2. A listagem deve ser **recursiva**:
    - Se o elemento atual for diretório → adicionar o nome com `/` e chamar o método recursivamente para seus filhos.
    - Se for arquivo → apenas adicionar o nome com a indentação correta.

3. O uso de **Streams** é permitido, por exemplo:
    - Para iterar sobre `File[]` retornado por `listFiles()`.
    - Para filtrar arquivos ou ordenar resultados antes de imprimir.

---

## Exemplo de saída esperada
```
/tmp/mytempdir/
  docs/
    readme.md
  src/
    Main.java
  notes.txt
```

---

## Critérios de avaliação
- Uso correto de **recursividade**.
- Uso opcional (mas bem aplicado) de **Streams**.

----

# Exercicio copia de imagem

## Objetivo
Adicione uma imagem na pasta /src/resources (pode ser **jpg**, **jpeg** ou **png**), e com as abstracoes de **InputStream** e **OutputStream**, realize uma copia em um outro arquivo de imagem do mesmo tipo.
O codigo deve ser executado na classe **ImageCopyMain.java**