import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//extends serve para o formulário herdar tudo da outra classe
public class FrmCadPessoa extends JFrame{
    private JLabel lblModelo, lblMarca, lblCompra, lblLucro, lblEstoque;
    private JTextField txtModelo, txtMarca, txtCompra, txtLucro, txtEstoque;
    private JButton btnCadastrar, btnExibir;
    private Conexao con;
    
    private void initComponents(){
        setTitle("Cadastro de veículos");
        setSize(280, 140);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        /***MODELO***/
        lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(10, 10, 80, 20);
        
        txtModelo = new JTextField();
        txtModelo.setBounds(70, 10, 180, 20);
        
        /***MARCA***/
        lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(10, 40, 50, 20);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(70, 40, 50, 20);
        
        /***PREÇO DE COMPRA***/
        lblCompra = new JLabel("Valor de compra:");
        lblCompra.setBounds(10, 40, 50, 20);
        
        txtCompra = new JTextField();
        txtCompra.setBounds(70, 40, 50, 20);
        
        /***ESTOQUE***/
        lblEstoque = new JLabel("Quantidade em estoque:");
        lblEstoque.setBounds(20, 40, 100, 20);
        
        txtEstoque = new JTextField();
        txtEstoque.setBounds(20, 80, 200, 40);
        
        /***CADASTRAR***/
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(10, 70, 120, 20);
        
        /***EXIBIR***/
        btnExibir = new JButton("Veículos Cadastrados");
        btnExibir.setBounds(10, 140, 240, 20);
        
        
        
        
        con = new Conexao();
        
        btnCadastrar.addActionListener(
                new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        con.conectar();
                        con.cadastrar(txtModelo.getText(), txtMarca.getText());
                               // Float.parseFloat(txtCompra.getText()), 
                               // Float.parseFloat(txtLucro.getText()), 
                               // Integer.parseInt(txtEstoque.getText()));
                        con.desconectar();
                    }
                }
        );
        
        getContentPane().add(lblModelo);
        getContentPane().add(txtModelo);
        
        getContentPane().add(lblMarca);
        getContentPane().add(txtMarca);        
        
        //getContentPane().add(lblCompra);
        //getContentPane().add(txtCompra);
        
        //getContentPane().add(lblLucro);
        //getContentPane().add(txtLucro);
        
        //getContentPane().add(lblEstoque);
        //getContentPane().add(txtEstoque);
                
        getContentPane().add(btnCadastrar);
        getContentPane().add(btnExibir);
        
        setVisible(true);
    }
    
    public FrmCadPessoa(){
        initComponents();
    }
    
}
