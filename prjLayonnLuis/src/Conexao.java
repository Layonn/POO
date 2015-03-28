//PRIMEIRO DE TUDO FAZER A IMPORTAÇÃO DO DRIVER DE BANCO
//#########CLICAR COM O BOTÃO DIREITO EM CIMA DO PROJETO###########
//#########ESCOLHER A OPÇÃO PROPRIEDADE###########
//#########NA JANELA "CATEGORIAS", ESCOLHER A OPÇÃO "BIBLIOTECAS"###########
//#########CLICAR NO BOTÃO "ADICIONAR BIBLIOTECA"###########
//###############ESCOLHER "DRIVER JDBC DO MYSQL"#################

//IMPORTAR AS CLASSES JAVA PARA LIDAR COM SQL
//CLASSES NECESSÁRIAS APENAS PARA INSERÇÃO
import java.sql.DriverManager;//FAZ A COMUNICAÇÃO ENTRE A APLICAÇÃO E O BANCO
import java.sql.Connection;
import java.sql.PreparedStatement;//ENVIA COMANDOS SQL PARA O DRIVER
import java.sql.SQLException;//TRATA AS EXCEÇÕES PARA NAO DEIXAR O SISTEMA TRAVAR

public class Conexao {
    private String banco, usuario, senha, driver;
    private Connection con;
    
    //METODO CONSTRUTOR
    public Conexao(){
        banco = "prjRevendedora"; //nome do banco criado no MySql
        usuario = "root"; //usuario padrão do banco
        senha = ""; //senha configurada no SGBD
        driver = "com.mysql.jdbc.Driver"; //o driver recebendo a String do driver
        con = null;//ZERARA A CONECÇÃO 
    }
    
    public void conectar(){
        //tratar o erro de o banco não encontrar o driver
        try{
            Class.forName(driver);//Habilita o driver para o sistema
            
            //con entra em contato com o driver e pega uma conexão
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + banco, usuario, senha);
            
        //se não tivesse importado o driver de conxão ia entrar no exception     
        }catch(ClassNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        
        //tratar qualquer erro do SQL
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
       
    }
    
    public void cadastrar(String modelo, String marca){
        try{
            //quando houver uma interrogação ele vai entender que é uma função para
            //o prepared statement
            String sql = "insert into carro(modelo, marca) values (?, ?)";
            
            //con está conectado com o banco
            //essa linha pede para preparar a consulta
            //para não dar nenhum erro futuramente
            //caso der algum problema aqui ele já pula pra exceção
            PreparedStatement ps = con.prepareStatement(sql);
            //estabelece uma conexão com permissão de envio de dados com o banco
            
            
            ps.setString(1, modelo);
            ps.setString(2, marca);
            //ps.setFloat(3, preco_compra);
            //ps.setFloat(4, margem_lucro);
            //ps.setInt(5, estoque);
            
            //diferença entre usar o executeUpdate e só o execute 
            //que o executeUpdate retorna um int = 0 ou 1
            //execute retorna true ou false
            ps.executeUpdate();
            
            //terminar a execução, não continuar conectado
            ps.close();
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
    }
    
    //desconectar
    public void desconectar(){
        try{
            con.close();
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
    }   
    
}
