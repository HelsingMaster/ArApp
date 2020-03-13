package arapp.v1.betta.com.datamodel;

public class ClienteDataModel {
    // Dados para criar tabelas no banco de dados
    // MOR - Modelo Objeto relacional
    // Tupla ou Registros

    private static String TABELA = "tabela_cliente";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String telefone = "telefone";
    private final static String cpf = "cpf";

    // Cria dinamicamente uma query SQL para criar a tabela


//    private static String queryCriarTabela = "";


   public static String criarTabela(){
       StringBuilder sql = new StringBuilder();

       sql.append(" CREATE TABLE IF NO EXISTS "+ TABELA +"( ");
       sql.append( id +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
       sql.append( nome +" VARCHAR (100) NOT NULL DEFAULT (''), ");
       sql.append( telefone +" INTEGER NOT NULL DEFAULT (''), ");
       sql.append( cpf +" INTEGER NOT NULL DEFAULT ");
       sql.append(" )");

       return sql.toString();


//        queryCriarTabela = "CREATE TABLE " + TABELA;
//        queryCriarTabela += " (";
//        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
//        queryCriarTabela += nome + " TEXT, ";
//        queryCriarTabela += telefone + " INTEGER, ";
//        queryCriarTabela += cpf + " INTEGER ";
//        queryCriarTabela +=  " )";
//        return queryCriarTabela;
   }

    public static String getTABELA() {
        return TABELA;
    }

    public static void setTABELA(String TABELA) {
        ClienteDataModel.TABELA = TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getNome() {
        return nome;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static String getCpf() {
        return cpf;
    }

//    public static String getQueryCriarTabela() {
//        return queryCriarTabela;
//    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
//        ClienteDataModel.queryCriarTabela = queryCriarTabela;
    }
}
