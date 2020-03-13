package arapp.v1.betta.com.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import arapp.v1.betta.com.R;
import arapp.v1.betta.com.controller.ClienteController;
import arapp.v1.betta.com.datasource.DataSource;
import arapp.v1.betta.com.model.Cliente;
import arapp.v1.betta.com.util.ArteUtil;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        chamaTela();
    }

    private void chamaTela() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DataSource ds = new DataSource(getBaseContext());
                Cliente obj = new Cliente();
                ClienteController clienteController = new ClienteController(getBaseContext());


//              ======  Inserir  ==========
//                obj.setNome("Rita");
//                obj.setTelefone(955555555);
//                obj.setCpf("22223456789");
//                clienteController.salvar(obj);


//              ======  Deleta  ==========
//              obj.setId(10);
//              clienteController.deletar(obj);

//              ======  Alterar  ==========
//                obj.setNome("Mel");
//                obj.setTelefone(900005544);
//                obj.setCpf("25444498798");
//                obj.setId(13);
//                clienteController.alterar(obj);

//              ======  Alterar  ==========
                List<Cliente> lista = clienteController.listar();

                for (Cliente cliente : lista) {
                    Log.i("AR", "ID: " + cliente.getId() + " - Nome: " + cliente.getNome() + " - Telefone: " + cliente.getTelefone() + " - Cpf: " + cliente.getCpf());
                }

                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, ArteUtil.TIME);
    }
}
