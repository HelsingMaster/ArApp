package arapp.v1.betta.com.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import arapp.v1.betta.com.datamodel.ClienteDataModel;
import arapp.v1.betta.com.model.Cliente;
import arapp.v1.betta.com.util.ArteUtil;

public class DataSource extends SQLiteOpenHelper {
    private SQLiteDatabase db = getWritableDatabase();

    public DataSource(Context context) {
        super(context, ArteUtil.DB_NAME, null, ArteUtil.DB_VERSION);

        Log.i("DT", "Banco AQUI");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(ClienteDataModel.criarTabela());
            Log.i("AR", "Criando as tabelas no bancoo agora");
        } catch (Exception e) {
            Log.e("AR", "Erro de inclusão de dados--> " + e.getMessage());
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    protected boolean insert(String tabela, ContentValues dados) {
        boolean sucesso = true;
        try {
            Log.i("AR", "Agora vamos inserir valores na tabela");
            sucesso = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            sucesso = false;
        }

        return true;
    }

    protected boolean deletar(String tabela, int id) {
        boolean sucesso = true;
        sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;
        return sucesso;
    }

    protected boolean alterar(String tabela, ContentValues dados) {
        boolean sucesso = true;
        int id = dados.getAsInteger("id");
        sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;
        return sucesso;
    }

    protected List<Cliente> getAllCliente() {
        Cliente obj;
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM " + ClienteDataModel.getTABELA() + " ORDER BY nome";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                obj = new Cliente();
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getNome())));
                obj.setTelefone(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getTelefone())));
                obj.setCpf(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getCpf())));

                lista.add(obj);
            } while (cursor.moveToNext());
        }
         cursor.close();
        return lista;
    }


}
