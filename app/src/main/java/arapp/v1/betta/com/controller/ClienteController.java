package arapp.v1.betta.com.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import arapp.v1.betta.com.datamodel.ClienteDataModel;
import arapp.v1.betta.com.datasource.DataSource;
import arapp.v1.betta.com.model.Cliente;

public class ClienteController extends DataSource {
    ContentValues dados;

    public ClienteController(Context context) {
        super(context);
    }

    public boolean salvar(Cliente obj) {
        boolean sucesso = true;
        dados = new ContentValues();
        dados.put(ClienteDataModel.getNome(), obj.getNome());
        dados.put(ClienteDataModel.getTelefone(), obj.getTelefone());
        dados.put(ClienteDataModel.getCpf(), obj.getCpf());
        sucesso = insert(ClienteDataModel.getTABELA(), dados);
        return sucesso;
    }
    public boolean deletar(Cliente obj){
        boolean sucesso = true;
    sucesso = deletar(ClienteDataModel.getTABELA(), obj.getId());

        return sucesso;
    }
    public boolean alterar(Cliente obj) {
        boolean sucesso = true;
        dados = new ContentValues();
        dados.put(ClienteDataModel.getId(), obj.getId());
        dados.put(ClienteDataModel.getNome(), obj.getNome());
        dados.put(ClienteDataModel.getTelefone(), obj.getTelefone());
        dados.put(ClienteDataModel.getCpf(), obj.getCpf());
        sucesso = alterar(ClienteDataModel.getTABELA(), dados);
        return sucesso;
    }

    public List<Cliente> listar() {
        return getAllCliente();
    }

}
