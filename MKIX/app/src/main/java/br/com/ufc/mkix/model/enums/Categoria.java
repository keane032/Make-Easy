package br.com.ufc.mkix.model.enums;

public enum Categoria {

    // 100 serviços domésticos
    // 200 serviços de construção
    // 300 serviços de transporte
    // 400 serviços de lazer
    // 500 serviços de oficina
    // 1000 outros

    COZINHA(101),
    DIARISTA(102),
    MORDOMO(103),
    BABA(104),
    EMPREGADA(105),
    JARDINEIRO(106),
    GARCOM(107),
    PISCINEIRO(108),
    LAVADEIRA(109),
    COPEIRA(110),
    CHURRASQUEIRO(111),
    MARCENARIA(201),
    PEDREIRO(202),
    ENCANADOR(203),
    ELETRICISTA(204),
    CARPINTEIRO(205),
    MECANICA_DE_CARRO(501),
    MECANICA_DE_MOTO(502),
    MECANICA_DE_CAMINHAO(503),
    OUTRO(1000)
    ;

    private final int codigo;
    //TODO Adicionar um campo de texto pra pegar o nome da categoria como string

    Categoria(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
