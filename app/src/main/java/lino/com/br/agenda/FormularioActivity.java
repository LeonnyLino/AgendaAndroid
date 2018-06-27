package lino.com.br.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import lino.com.br.agenda.dao.AlunoDAO;
import lino.com.br.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {
    private FormularioHelper formHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        formHelper = new FormularioHelper(this);

//        Button btnSalvar = (Button) findViewById(R.id.formulario_botao);
//
//        btnSalvar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(FormularioActivity.this, "Aluno Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Aluno aluno = formHelper.pegaAluno();
                AlunoDAO dao = new AlunoDAO(this);
                dao.insere(aluno);
                dao.close();
                Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
                finish();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater infleter = getMenuInflater();
        infleter.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

}
