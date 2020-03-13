package arapp.v1.betta.com.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import arapp.v1.betta.com.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editNome)
    EditText editNome;
    @BindView(R.id.editTelefone)
    EditText editTelefone;
    @BindView(R.id.editIdade)
    EditText editIdade;
    @BindView(R.id.btnCadastrar)
    Button btnCadastrar;
    @BindView(R.id.btnVisualizar)
    Button btnVisualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnCadastrar, R.id.btnVisualizar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnCadastrar:
                Toast.makeText(this, "Cadastrar Clicado", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnVisualizar:
                Toast.makeText(this, "Visualizar Clicado", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
