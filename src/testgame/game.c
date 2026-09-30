#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// 1. "Classe Base" usando Struct e Ponteiro de Função para a habilidade
typedef struct Personagem {
    int vida;
    int dano;
    char nome[50];
    const char* (*habilidade)(); // Ponteiro para a função da habilidade
} Personagem;

// Habilidade padrão do Mago
const char* habilidade_mago() {
    return "mana regen";
}

// 2. "Classe Filha" contendo a struct base e o atributo próprio
typedef struct {
    Personagem base; // Herança em C
    int mana;
} Mago;

// Imprime a ficha do personagem
void ficha_mago(Mago* m) {
    printf("%s (vida: %d, dano: %d, habilidade: %s) [mana: %d]\n",
           m->base.nome, 
           m->base.vida, 
           m->base.dano, 
           m->base.habilidade(), 
           m->mana);
}

// Em C não há sobrecarga, então usamos nomes diferentes:

// Recuperação personalizada de mana
void recuperar_mana_qtd(Mago* m, int quantidade) {
    m->mana += quantidade;
    printf("%s recuperou +%d mana\n", m->base.nome, quantidade);
}

// Recuperação padrão de mana (reaproveita a personalizada)
void recuperar_mana(Mago* m) {
    recuperar_mana_qtd(m, 10);
}

int main() {
    // Criando e inicializando o Mago
    Mago mago;
    strcpy(mago.base.nome, "Gandalf");
    mago.base.vida = 100;
    mago.base.dano = 25;
    mago.base.habilidade = habilidade_mago; // Atribui a função
    mago.mana = 30;

    printf("--- Ficha Inicial ---\n");
    ficha_mago(&mago);

    printf("\n--- Recuperacao Padrao ---\n");
    recuperar_mana(&mago);
    ficha_mago(&mago);

    printf("\n--- Recuperacao Personalizada ---\n");
    recuperar_mana_qtd(&mago, 25);
    ficha_mago(&mago);

    return 0;
}