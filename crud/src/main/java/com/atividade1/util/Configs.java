
package com.atividade1.util;

public class Configs {
    //Dados de acesso ao banco;
    public static final String DB_URL = "jdbc:postgresql://mypostgresql.cxlxdd9xytdm.us-east-1.rds.amazonaws.com:5432";
    public static final String DB_USERNAME = "professor";
    public static final String DB_PASSWORD = "professor";
    
    //DB Name;
    public static final String DB_NAME = "/bancoDb";
    
    //Tabelas Conta_digital_pf, Realiza e Transacao;
    public static final String CONTA_DIGITAL_PF_TABLE = "banco.conta_digital_pf";
    public static final String REALIZA_TABLE = "banco.realiza";
    public static final String TRANSACAO_TABLE = "banco.transacao";
}
